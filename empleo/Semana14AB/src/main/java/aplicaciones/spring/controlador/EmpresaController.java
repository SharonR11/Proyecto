package aplicaciones.spring.controlador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import aplicaciones.spring.servicios.TipoUsuarioService;
import aplicaciones.spring.modelo.Empresa;
import aplicaciones.spring.modelo.TipoUsuario;
import aplicaciones.spring.servicios.EmpresaService;

@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/empresas")
@SessionAttributes("empresa")
public class EmpresaController {
	@Autowired
	@Qualifier("empresa")
	EmpresaService empresaService;	
	@Autowired
	@Qualifier("tipousuario")
	TipoUsuarioService tipousuarioService;
	
	@RequestMapping("/listar")
	public String listar (Model model ) {
		List<Empresa> empresas =empresaService.listar();
		model.addAttribute("empresas",empresas);
		model.addAttribute("titulo","Lista de Empresas");
		return "empresaListar";
	}
	@RequestMapping("/form")
	public String formulario (Model model) {
		Empresa empresa = new Empresa();
		model.addAttribute("empresa",empresa);
		model.addAttribute("tipousuarios", tipousuarioService.listar());
		model.addAttribute("btn", "Crear Empresa");
		return "empresaForm";
	}
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Validated Empresa empresa, Model model) {
		try {
			String id =empresa.getTipousuario();
			TipoUsuario emp = tipousuarioService.buscar(id);
			tipousuarioService.guardar(emp);
			empresaService.guardar(empresa);
			
			model.addAttribute("empresa", empresa);
			model.addAttribute("tipousuarios", tipousuarioService.listar());
			model.addAttribute("btn", "Registrar Empresa");
			return "empresaForm";
		} catch (Exception e) {
		}
		return "redirect:/empresas/listar";
	}
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("empresa",empresaService.buscar(id));
		model.addAttribute("tipousuarios", tipousuarioService.listar());
		model.addAttribute("btn","Actualiza Registro");
		return "empresaForm";
	}
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		empresaService.eliminar(id);
		return "redirect:/empresas/listar";
	}
}
