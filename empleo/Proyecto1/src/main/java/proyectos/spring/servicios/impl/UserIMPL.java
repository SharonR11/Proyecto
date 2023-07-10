package proyectos.spring.servicios.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import proyectos.spring.DTO.LoginDTO;
import proyectos.spring.DTO.UserDTO;
import proyectos.spring.Response.LoginResponse;
import proyectos.spring.modelo.User;
import proyectos.spring.repositorios.UserRepo;
import proyectos.spring.servicios.UserService;

@Service
public class UserIMPL implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void addUser(UserDTO userDTO) {

	    User user = new User();
	    user.setUser(userDTO.getId());
	    user.setNombres(userDTO.getNombres());
	    user.setApellidos(userDTO.getApellidos());
	    user.setDni(userDTO.getDni());
	    user.setCarrera(userDTO.getCarrera());
	    user.setCiclo(userDTO.getCiclo());
	    user.setTelefono(userDTO.getTelefono());
	    user.setEmail(userDTO.getEmail());
	    user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));

	    userRepo.save(user);
	}
	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
	    String email = loginDTO.getEmail();
	    String password = loginDTO.getPassword();

	    User user = userRepo.findByEmail(email);

	    if (user != null) {
	        String encodedPassword = user.getPassword();
	        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);

	        if (isPasswordMatch) {
	            return new LoginResponse("Inicio de sesión exitoso", true);
	        } else {
	            return new LoginResponse("Contraseña incorrecta", false);
	        }
	    } else {
	        return new LoginResponse("Email no existe", false);
	    }
	}
}