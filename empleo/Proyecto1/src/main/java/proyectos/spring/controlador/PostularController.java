package proyectos.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectos.spring.modelo.Postular;
import proyectos.spring.repositorios.PostularRepo;
import proyectos.spring.servicios.PostularService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/postulacion")
public class PostularController {
	@Autowired
	private PostularService postularService;
	@Autowired
	private PostularRepo postularRepo;
	@GetMapping("/lista")
	public ResponseEntity<List<Postular>> obtenerPostulaciones() {
		List<Postular> postulaciones = postularService.obtenerPostulaciones();
		return ResponseEntity.ok(postulaciones);
	}

	@GetMapping("/lista/{postularId}")
	public ResponseEntity<Postular> obtenerPostulacionPorId(@PathVariable Long postularId) {
		Postular postulacion = postularService.obtenerPostulacionPorId(postularId);
		if (postulacion != null) {
			return ResponseEntity.ok(postulacion);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Postular> guardarPostulacion(@RequestBody Postular postulacion) {
		Postular postulacionGuardada = postularService.guardarPostulacion(postulacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(postulacionGuardada);
	}
	@PutMapping("/update/{postularId}")
    public ResponseEntity<Postular> actualizaPostulacion(@PathVariable Long postularId, @RequestBody Postular postulacion) {
		 Postular postulacionExistente = postularRepo.findById(postularId).orElse(null);
		    if (postulacionExistente != null) {
		        postulacionExistente.setOferta(postulacion.getOferta());
		        Postular postulacionActualizada = postularRepo.save(postulacionExistente);
		        return ResponseEntity.ok(postulacionActualizada);
		    } else {
		        return ResponseEntity.notFound().build();
		    }
    }

	@DeleteMapping("/eliminar/{postularId}")
	public ResponseEntity<Void> eliminarPostulacion(@PathVariable Long postularId) {
		postularService.eliminarPostulacion(postularId);
		return ResponseEntity.noContent().build();
	}
}
