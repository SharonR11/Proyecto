package proyectos.spring.DTO;

public class UserDTO {
	private int id;
	private String nombres;
	private String apellidos;
	private String dni;
	private String carrera;
	private String ciclo;
	private String telefono;
	private String email;
	private String password;
	
	
	public UserDTO(int id, String nombres, String apellidos, String dni, String carrera, String ciclo,
			String telefono, String email, String password) {
		
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.carrera = carrera;
		this.ciclo = ciclo;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}

	public UserDTO() {
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", carrera=" + carrera + ", ciclo=" + ciclo + ", telefono=" + telefono + ", email=" + email
				+ ", password=" + password + "]";
	}

	
	
	

}
