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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyectos.spring.modelo.Oferta;
import proyectos.spring.servicios.OfertaService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/ofertas")
public class OfertaController {
	@Autowired
	private OfertaService ofertaService;

	@GetMapping("/lista")
	public ResponseEntity<List<Oferta>> obtenerOfertas() {
		List<Oferta> ofertas = ofertaService.obtenerOfertas();
		return ResponseEntity.ok(ofertas);
	}

	@GetMapping("/lista/{ofertaId}")
	public ResponseEntity<Oferta> obtenerOfertaPorId(@PathVariable Long ofertaId) {
		Oferta oferta = ofertaService.obtenerOfertaPorId(ofertaId);
		if (oferta != null) {
			return ResponseEntity.ok(oferta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Oferta> guardarOferta(@RequestBody Oferta oferta) {
		Oferta ofertaGuardada = ofertaService.guardarOferta(oferta);
		return ResponseEntity.status(HttpStatus.CREATED).body(ofertaGuardada);
	}

	@DeleteMapping("/eliminar/{ofertaId}")
	public ResponseEntity<Void> eliminarOferta(@PathVariable Long ofertaId) {
		ofertaService.eliminarOferta(ofertaId);
		return ResponseEntity.noContent().build();
	}
}
