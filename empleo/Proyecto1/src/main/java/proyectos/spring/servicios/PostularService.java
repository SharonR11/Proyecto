package proyectos.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyectos.spring.modelo.Postular;
import proyectos.spring.repositorios.PostularRepo;
@Service
public class PostularService {
	@Autowired
	private PostularRepo postularRepo;
	public List<Postular> obtenerPostulaciones() {
        return postularRepo.findAll();
	}
	public Postular obtenerPostulacionPorId(Long postularId) {
        return postularRepo.findById(postularId).orElse(null);
    }
	public Postular guardarPostulacion(Postular postulacion) {
        return postularRepo.save(postulacion);
    }
	public void eliminarPostulacion(Long postularId) {
		postularRepo.deleteById(postularId);
	}
}
