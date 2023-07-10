package proyectos.spring.servicios;


import proyectos.spring.DTO.LoginDTO;
import proyectos.spring.DTO.UserDTO;
import proyectos.spring.Response.LoginResponse;

public interface UserService {
	
	void addUser(UserDTO userDTO);
	
	LoginResponse loginUser(LoginDTO loginDTO);
	/*
	private UserR ofertaRepo;
	@Autowired
	public User obtenerUsuarioPorId(Long userId) {
        return ofertaRepo.findById(userId).orElse(null);
    }*/

}