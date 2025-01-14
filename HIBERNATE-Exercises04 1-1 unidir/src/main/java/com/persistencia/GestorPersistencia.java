package com.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidades.Persona;

public class GestorPersistencia {

	private EntityManagerFactory fabrica;
	private EntityManager manager;

	public GestorPersistencia() {
		this.fabrica = Persistence.createEntityManagerFactory("miBaseDeDatos");
	}

	public Persona getPersonaPorId(int id) {
		manager = this.fabrica.createEntityManager();
		Persona persona = (Persona) manager.find(Persona.class, id);
		manager.close();
		return persona;
	}

	public boolean insertarPersona(Persona persona) {
		manager = fabrica.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(persona);
		try {
			manager.getTransaction().commit();
		} catch (Exception e) {
			return false;
		} finally {
			manager.close();
		}
		return true;
	}

	public boolean actualizarPersona(Persona persona) {
		manager = fabrica.createEntityManager();
		manager.getTransaction().begin();
		try {
			Persona personaMerge = manager.merge(persona);
			manager.persist(personaMerge);
			manager.getTransaction().commit();
		} catch (Exception e) {
			return false;
		} finally {
			manager.close();
		}
		return true;
	}

	public boolean eliminarPersona(Persona persona) {
		manager = fabrica.createEntityManager();
		manager.getTransaction().begin();
		try {
			Persona personaMerge = manager.merge(persona);
			manager.remove(personaMerge);
			manager.getTransaction().commit();
		} catch (Exception e) {
			return false;
		} finally {
			manager.close();
		}
		return true;
	}
	
	public void cerrar() {
		this.fabrica.close();
	}

}
