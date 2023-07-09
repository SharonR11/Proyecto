package proyectos.spring.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="oferta")
public class Oferta {
	@Id
	@Column(name="id",length = 45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long oferta;
	
	@Column(name="empresa",length = 255)
	private String empresa;
	
	@Column(name="titulo",length = 255)
	private String titulo;
	
	@Column(name="descripcion",columnDefinition = "LONGTEXT")
	private String descripcion;
	
	@Column(name="sueldo",length = 15)
	private String sueldo;
	
	@Column(name="cargo",length = 50)
	private String cargo;
	
	@Column(name="fecha",length = 30)
	private String fecha;

	public Oferta(Long oferta, String empresa, String titulo, String descripcion, String sueldo, String cargo,
			String fecha) {
		super();
		this.oferta = oferta;
		this.empresa = empresa;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.sueldo = sueldo;
		this.cargo = cargo;
		this.fecha = fecha;
	}

	public Oferta() {
	}

	public Long getOferta() {
		return oferta;
	}

	public void setOferta(Long oferta) {
		this.oferta = oferta;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSueldo() {
		return sueldo;
	}

	public void setSueldo(String sueldo) {
		this.sueldo = sueldo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Oferta [oferta=" + oferta + ", empresa=" + empresa + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", sueldo=" + sueldo + ", cargo=" + cargo + ", fecha=" + fecha + "]";
	}
	
}
