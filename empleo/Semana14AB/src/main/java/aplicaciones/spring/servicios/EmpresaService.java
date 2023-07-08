package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Empresa;
import aplicaciones.spring.repositorios.IEmpresa;
@Service("empresa")
public class EmpresaService {
	@Autowired
	private IEmpresa iEmpresa;
	public void guardar(Empresa empresa) {
		iEmpresa.save(empresa);
	}	
	public List<Empresa> listar (){
		 return iEmpresa.findAll();
	}	
	public  Empresa buscar(Long id) {
		return  iEmpresa.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iEmpresa.delete(iEmpresa.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	public Empresa buscar(String nombre) {
		return iEmpresa.findByNombre(nombre);
	}
	
}
