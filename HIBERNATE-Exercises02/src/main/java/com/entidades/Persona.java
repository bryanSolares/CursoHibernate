package com.entidades;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "NuevaPersona")
public class Persona {

	@Id
	@Column(name = "PER_ID")
	private int idPersonas;
	@Column(name = "PER_NOMBRE", nullable = false, length = 60)
	private String nombre;
	@Column(name = "PER_DIRECCION", length = 80)
	private String direccion;
	@Column(name = "PER_FECHANAC")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Column(name = "PER_ID_FISCAL", unique = true, length = 25)
	private String nit;
	@Transient
	private int edad;
	@Embedded
	private NombreCompleto nombreCompleto;

	public Persona() {

	}

	public Persona(int idPersonas, String nombre, String direccion, Date fechaNacimiento) {
		this.idPersonas = idPersonas;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getIdPersonas() {
		return idPersonas;
	}

	public void setIdPersonas(int idPersonas) {
		this.idPersonas = idPersonas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public NombreCompleto getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(NombreCompleto nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Override
	public String toString() {
		return "Persona [idPersonas=" + idPersonas + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
