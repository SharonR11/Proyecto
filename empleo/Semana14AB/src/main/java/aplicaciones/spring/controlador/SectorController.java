package aplicaciones.spring.controlador;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import aplicaciones.spring.modelo.Sector;
import aplicaciones.spring.servicios.SectorService;
@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/sectors")
@SessionAttributes("sector")
public class SectorController {
	@Autowired
	@Qualifier("sector")
	SectorService sectorService;	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Sector> sectors =sectorService.listar();
		model.addAttribute("sectors",sectors);
		model.addAttribute("titulo","Lista de sectores");
		return "sectorListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Sector sector = new Sector();
		model.put("sector",sector);
		model.put("btn", "Crear sector");
		return "sectorForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("sector",sectorService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "sectorForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated Sector sector,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			sector = new Sector();
			model.addAttribute("sector",sector);
			model.addAttribute("btn", "Crear Sector");
			return "sectorForm";
		}else {
			sectorService.guardar(sector);
		return "redirect:/sectors/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		sectorService.eliminar(id);
		return"redirect:/sectors/listar";
	}
}
