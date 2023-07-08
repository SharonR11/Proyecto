package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Empleado;
import aplicaciones.spring.repositorios.IEmpleado;
@Service("empleado")
public class EmpleadoService {
	@Autowired
	private IEmpleado iEmpleado;
	public void guardar(Empleado empleado) {
		iEmpleado.save(empleado);
	}	
	public List<Empleado> listar (){
		 return iEmpleado.findAll();
	}	
	public  Empleado buscar(Long id) {
		return  iEmpleado.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iEmpleado.delete(iEmpleado.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
