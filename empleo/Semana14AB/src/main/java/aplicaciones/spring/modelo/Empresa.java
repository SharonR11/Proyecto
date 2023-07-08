package aplicaciones.spring.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;
@Entity
@Table(name="trabajo_empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//para que no sea nulo
	@NotNull
	private String tipousuario;
	@NotNull
	private String nombres;
	@NotNull
	private String apellidos;
	@NotNull
	private String correo;
	@NotNull
	private String contraseña;
	@NotNull
	private String empresa;
	@NotNull
	private String razonsocial;
	@NotNull
	private Integer ruc;
	@NotNull
	private String direccion;
	@NotNull
	private Integer telefono;
	@NotNull
	private String sector;
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
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public Integer getRuc() {
		return ruc;
	}
	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	@Override
	public String toString() {
		return "trabajo_empresa [idEmpresa=" + id + ", nombre=" + nombres 
				+ ", apellido=" + apellidos + ", correo=" + correo 
				+ ",contraseña ="+contraseña+",empresa ="+empresa+
				",razonsocial ="+razonsocial+",ruc ="+ruc+",direccion ="
				+direccion+",telefono ="+telefono+",sector ="+sector+"]";
	}
}
