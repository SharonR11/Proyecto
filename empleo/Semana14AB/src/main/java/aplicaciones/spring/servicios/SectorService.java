package aplicaciones.spring.servicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aplicaciones.spring.modelo.Sector;
import aplicaciones.spring.repositorios.ISector;
@Service("sector")
public class SectorService {
	@Autowired
	private ISector iSector;
	public void guardar(Sector sector) {
		iSector.save(sector);
	}	
	public List<Sector> listar (){
		 return iSector.findAll();
	}	
	public  Sector buscar(Long id) {
		return  iSector.findById(id);
	}	
	public boolean eliminar (Long id) {
		try {
			iSector.delete(iSector.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
}
