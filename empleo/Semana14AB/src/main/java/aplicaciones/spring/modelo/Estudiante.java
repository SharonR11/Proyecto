package aplicaciones.spring.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity
@Table(name="trabajo_estudiante")
public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//para que no sea nulo
	@NotNull
	private String tipousuario;
	@NotNull
	private String nombre;
	@NotNull
	private String apellido;
	@NotNull
	private String dni;
	@NotNull
	private Integer telefono;
	@NotNull
	private String correo;
	@NotNull
	private String contraseña;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return "trabajo_estudiante [idEstudiante=" + id + ", tipousuario=" + tipousuario 
				+ ", nombre=" + nombre + ", apellido=" + apellido + ",dni = "+dni+
				",telefono ="+telefono+",correo ="+correo+ ",contraseña =" +contraseña+"]";
	}
}
