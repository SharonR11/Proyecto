package proyectos.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyectos.spring.modelo.Oferta;
import proyectos.spring.repositorios.OfertaRepo;
@Service
public class OfertaService {
	@Autowired
	private OfertaRepo ofertaRepo;
	public List<Oferta> obtenerOfertas() {
	        return ofertaRepo.findAll();
	}
	public Oferta obtenerOfertaPorId(Long ofertaId) {
        return ofertaRepo.findById(ofertaId).orElse(null);
    }
	public Oferta guardarOferta(Oferta oferta) {
        return ofertaRepo.save(oferta);
    }
	public void eliminarOferta(Long ofertaId) {
		ofertaRepo.deleteById(ofertaId);
	}
}
