package proyectos.spring.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import proyectos.spring.DTO.LoginDTO;
import proyectos.spring.DTO.UserDTO;
import proyectos.spring.Response.LoginResponse;
import proyectos.spring.servicios.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/estudiante")

public class UserController {
	
	@Autowired
    private UserService userService;

	@PostMapping("/save")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResponseEntity.ok("Estudiante registrado correctamente");
    }
	@PostMapping(path = "/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
	    LoginResponse loginResponse = userService.loginUser(loginDTO);
	    if (loginResponse != null) {
	        if (loginResponse.isLoggedIn()) {
	            return ResponseEntity.ok(loginResponse);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Inicio de sesión inválido");
	        }
	    } else {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al procesar la solicitud de inicio de sesión");
	    }
	}
	
}

