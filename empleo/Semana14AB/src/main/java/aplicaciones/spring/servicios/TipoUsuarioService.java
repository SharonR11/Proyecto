package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.TipoUsuario;
import aplicaciones.spring.repositorios.ITipoUsuario;
@Service("tipousuario")
public class TipoUsuarioService {
	@Autowired
	private ITipoUsuario iTipoUsuario;
	public void guardar(TipoUsuario tipousuario) {
		iTipoUsuario.save(tipousuario);
	}	
	public List<TipoUsuario> listar (){
		 return iTipoUsuario.findAll();
	}	
	public  TipoUsuario buscar(Long id) {
		return  iTipoUsuario.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iTipoUsuario.delete(iTipoUsuario.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	public TipoUsuario buscar(String nombre) {
		return iTipoUsuario.findByNombre(nombre);
	}
}
