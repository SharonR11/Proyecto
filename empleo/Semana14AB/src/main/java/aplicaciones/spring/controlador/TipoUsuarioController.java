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
import aplicaciones.spring.modelo.TipoUsuario;
import aplicaciones.spring.servicios.TipoUsuarioService;
@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/tipousuarios")
@SessionAttributes("tipousuario")
public class TipoUsuarioController {
	@Autowired
	@Qualifier("tipousuario")
	TipoUsuarioService tipousuarioservice;	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<TipoUsuario> tipousuarios =tipousuarioservice.listar();
		model.addAttribute("tipousuarios",tipousuarios);
		model.addAttribute("titulo","Lista de Tipos de Usuario");
		return "tipousuarioListar";
	}
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		TipoUsuario tipousuario = new TipoUsuario();
		model.put("tipousuario",tipousuario);
		model.put("btn", "Crear Tipo Usuario");
		return "tipousuarioForm";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("tipousuario",tipousuarioservice.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "tipousuarioForm";
	}
	@RequestMapping(value="/insertar" ,method=RequestMethod.POST )
	public String guardar(@Validated TipoUsuario tipousuario,BindingResult result,Model model) {		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			tipousuario = new TipoUsuario();
			model.addAttribute("tipousuario",tipousuario);
			model.addAttribute("btn", "Crear Tipo Usuario");
			return "tipousuarioForm";
		}else {
			tipousuarioservice.guardar(tipousuario);
		return "redirect:/tipousuarios/listar";
		}
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		tipousuarioservice.eliminar(id);
		return"redirect:/tipousuarios/listar";
	}
}
