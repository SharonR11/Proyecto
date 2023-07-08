package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.Estudiante;
import aplicaciones.spring.repositorios.IEstudiante;
@Service("estudiante")
public class EstudianteService {
	@Autowired
	private IEstudiante iEstudiante;
	public void guardar(Estudiante estudiante) {
		iEstudiante.save(estudiante);
	}	
	public List<Estudiante> listar (){
		 return iEstudiante.findAll();
	}	
	public  Estudiante buscar(Long id) {
		return  iEstudiante.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iEstudiante.delete(iEstudiante.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
