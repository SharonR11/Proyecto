package aplicaciones.spring.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;
@Entity
@Table(name="trabajo_postulacion")
public class Postulacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//para que no sea nulo
	@NotNull
	private String estudiante;
	@NotNull
	private String oferta;
	@Temporal(TemporalType.DATE)
	//captura fecha del sistema
	private Date fecha;
	@NotNull
	private String cv;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	public String getOferta() {
		return oferta;
	}
	public void setOferta(String oferta) {
		this.oferta = oferta;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	@Override
	public String toString() {
		return "trabajo_postulacion [idPostulacion=" + id + ", estudiante=" + estudiante +
				", oferta=" + oferta +", fecha=" + fecha +", cv=" + cv +"]";
	}
}
