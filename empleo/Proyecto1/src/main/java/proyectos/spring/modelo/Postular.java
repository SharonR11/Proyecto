package proyectos.spring.modelo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "postular")
public class Postular {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "estudiante")
	@JsonIgnore
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "oferta")
	@JsonIgnore
    private Oferta oferta;
	
	@Column(name="fecha",length = 30)
	private String fecha;
	
	@Column(name="cv",length = 255)
	private String cv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Postular(Long id, User user, Oferta oferta, String fecha, String cv) {
		super();
		this.id = id;
		this.user = user;
		this.oferta = oferta;
		this.fecha = fecha;
		this.cv = cv;
	}
	
	public Postular() {
	}

	@Override
	public String toString() {
		return "Postular [id=" + id + ", user=" + user + ", oferta=" + oferta + ", fecha=" + fecha + ", cv=" + cv + "]";
	}
}
