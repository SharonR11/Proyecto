package aplicaciones.spring.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
@Table(name = "trabajo_ofertatrabajo")
public class OfertaTrabajo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String empresa;
	@NotNull
	private String nombre;
	@NotNull
	private String descripcion;
	@NotNull
	private Double sueldo;
	@NotNull
	private String cargo;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "trabajo_ofertatrabajo [idOferta=" + id + ", fecha=" + fecha + ", empresa=" 
				+ empresa + ", nombre=" + nombre+ ", descripcion=" + descripcion 
				+ ", sueldo=" + sueldo + ", cargo=" + cargo + "]";
	}
	
}
