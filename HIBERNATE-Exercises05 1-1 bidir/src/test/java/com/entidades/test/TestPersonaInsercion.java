package com.entidades.test;

import java.util.Date;

import com.entidades.Direccion;
import com.entidades.NombreCompleto;
import com.entidades.Persona;
import com.persistencia.GestorPersistencia;

public class TestPersonaInsercion {

	public static void main(String[] args) {

		GestorPersistencia persistencia = new GestorPersistencia();
		
		NombreCompleto nombreCompleto = new NombreCompleto("Bryan", "Josue", "Solares", "Perez");
		Direccion direccion = new Direccion(1, "Calle A", "6-45", "2-22", "Toledo");
		Persona persona = new Persona(1, "Bryan Josue Solares", "Ciudad de Guatemala", new Date(), "8474438-3", 24,
				direccion, nombreCompleto);
		//persona.setEstacionamiento(estacionamiento);
		

		if (persistencia.insertarPersona(persona))
			System.out.println("Persona Insertada");
		else
			System.out.println("Ha fallado la inserción");

	}

}
