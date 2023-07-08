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
import aplicaciones.spring.modelo.CargoTrabajo;
import aplicaciones.spring.servicios.CargoTrabajoService;
@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/cargotrabajos")
@SessionAttributes("cargotrabajo")
public class CargoTrabajoController {
	@Autowired
	@Qualifier("cargotrabajo")
	CargoTrabajoService cargotrabajoService;	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<CargoTrabajo> cargotrabajos =cargotrabajoService.listar();
		model.addAttribute("cargotrabajos",cargotrabajos);
		model.addAttribute("titulo","Lista de Cargos de Trabajo");
		return "cargotrabajoListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		CargoTrabajo cargotrabajo = new CargoTrabajo();
		model.put("cargotrabajo",cargotrabajo);
		model.put("btn", "Crear Cargo de Trabajo");
		return "cargotrabajoForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("cargotrabajo",cargotrabajoService.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "cargotrabajoForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated CargoTrabajo cargotrabajo,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			cargotrabajo = new CargoTrabajo();
			model.addAttribute("cargotrabajo",cargotrabajo);
			model.addAttribute("btn", "Crear CargoTrabajo");
			return "clienteForm";
		}else {
			cargotrabajoService.guardar(cargotrabajo);
		return "redirect:/cargotrabajos/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		cargotrabajoService.eliminar(id);
		return"redirect:/cargotrabajos/listar";
	}	
}
