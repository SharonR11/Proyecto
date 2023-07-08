package aplicaciones.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplicaciones.spring.modelo.CargoTrabajo;
import aplicaciones.spring.repositorios.ICargoTrabajo;

@Service("cargotrabajo")
public class CargoTrabajoService {
	@Autowired
	private ICargoTrabajo iCargoTrabajo;
	
	public void guardar(CargoTrabajo cargotrabajo) {
		iCargoTrabajo.save(cargotrabajo);
	}	
	public List<CargoTrabajo> listar (){
		 return iCargoTrabajo.findAll();
	}	
	public  CargoTrabajo buscar(Long id) {
		return  iCargoTrabajo.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iCargoTrabajo.delete(iCargoTrabajo.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
