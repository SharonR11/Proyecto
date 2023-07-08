package aplicaciones.spring.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.OfertaTrabajo;
import aplicaciones.spring.repositorios.IOfertaTrabajo;

@Service("ofertatrabajo")
public class OfertaTrabajoService {
	@Autowired
	IOfertaTrabajo iOfertaTrabajo;
	public void guardar(OfertaTrabajo ofertatrabajo) {		
		iOfertaTrabajo.save(ofertatrabajo);
	}
	
	public List<OfertaTrabajo> listar(){
		return iOfertaTrabajo.findAll();
	}
	public OfertaTrabajo buscar(Long id) {
		return iOfertaTrabajo.findById(id);
	}
	
	public boolean eliminar(Long id) {
		try {
			iOfertaTrabajo.delete(iOfertaTrabajo.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
