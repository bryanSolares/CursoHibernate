package com.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidades.AreaGeografica;
import com.entidades.Automovil;
import com.entidades.AutomovilPK;
import com.entidades.Empleado;
import com.entidades.LugarEstacionamiento;
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
		persona.getMascotas().size();
		manager.close();
		return persona;
	}

	public LugarEstacionamiento getEstacionamientoPorId(int id) {
		manager = this.fabrica.createEntityManager();
		LugarEstacionamiento estacionamiento = (LugarEstacionamiento) manager.find(LugarEstacionamiento.class, id);
		//manager.close();
		return estacionamiento;
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
	
	public Automovil getAutomivilPorId(AutomovilPK llave) {
		manager = this.fabrica.createEntityManager();
		Automovil automovilI = (Automovil) manager.find(Automovil.class, llave);
		automovilI.getPatrocinadores().size();
		manager.close();
		return automovilI;
	}
	
	public AreaGeografica getAreaPorId(String id) {
		manager = this.fabrica.createEntityManager();
		AreaGeografica area = (AreaGeografica) manager.find(AreaGeografica.class, id);
		area.getAreasHijo().size();
		manager.close();
		return area;
	}
	
	public boolean insertarEmpleado(Empleado empleado) {
		manager = fabrica.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(empleado);
		try {
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
