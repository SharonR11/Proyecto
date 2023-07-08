package aplicaciones.spring.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import aplicaciones.spring.modelo.OfertaTrabajo;
import aplicaciones.spring.modelo.Empresa;
import aplicaciones.spring.servicios.EmpresaService;
import aplicaciones.spring.servicios.OfertaTrabajoService;

@Controller
@RequestMapping("/ofertatrabajos")
@SessionAttributes("ofertatrabajo")
public class OfertaTrabajoController {
	@Autowired
	@Qualifier("ofertatrabajo")
	OfertaTrabajoService ofertaTrabajoService;
	
	@Autowired
	@Qualifier("empresa")
	EmpresaService empresaService;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<OfertaTrabajo> ofertatrabajos = ofertaTrabajoService.listar();
		model.addAttribute("ofertatrabajos",ofertatrabajos);
		model.addAttribute("titulo","Lista de Ofertas de Trabajo");
		return "ofertatrabajoListar";
	}
	@RequestMapping("/form")
	public String formulario(Model model) {
		OfertaTrabajo ofertatrabajo= new OfertaTrabajo();
		model.addAttribute("ofertatrabajo", ofertatrabajo);
		model.addAttribute("empresas", empresaService.listar());
		model.addAttribute("btn", "Registrar Oferta de Trabajo");
		return "ofertatrabajoForm";
	}
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated OfertaTrabajo ofertatrabajo, Model model) {
		try {
			String id =ofertatrabajo.getEmpresa();
			Empresa emp = empresaService.buscar(id);
			empresaService.guardar(emp);
			ofertaTrabajoService.guardar(ofertatrabajo);
			
			ofertatrabajo= new OfertaTrabajo();
			model.addAttribute("ofertaTrabajo", ofertatrabajo);
			model.addAttribute("empresas", empresaService.listar());
			model.addAttribute("btn", "Registrar Oferta");
			return "ofertatrabajoForm";
			
		} catch (Exception e) {
		}
		return "redirect:/ventas/listar";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("ofertatrabajo",ofertaTrabajoService.buscar(id));
		model.addAttribute("empresas", empresaService.listar());
		model.addAttribute("btn","Actualiza Registro");
		return "ofertatrabajoForm";
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		ofertaTrabajoService.eliminar(id);
		return "redirect:/ofertatrabajos/listar";
	}
	
}
