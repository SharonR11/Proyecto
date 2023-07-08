package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Postulacion;
import aplicaciones.spring.repositorios.IPostulacion;
@Service("postulacion")
public class PostulacionService {
	@Autowired
	IPostulacion iPostulacion;
	public void guardar(Postulacion postulacion) {		
		iPostulacion.save(postulacion);
	}
	
	public List<Postulacion> listar(){
		return iPostulacion.findAll();
	}
	public Postulacion buscar(Long id) {
		return iPostulacion.findById(id);
	}
	
	public boolean eliminar(Long id) {
		try {
			iPostulacion.delete(iPostulacion.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
