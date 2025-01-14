package entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@Column(name = "id_persona")
	private int idPersonas;
	@Column
	private String nombre;
	@Column
	private String direccion;
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;

	public Persona() {

	}

	public Persona(int idPersonas, String nombre, String direccion, LocalDate fechaNacimiento) {
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [idPersonas=" + idPersonas + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
