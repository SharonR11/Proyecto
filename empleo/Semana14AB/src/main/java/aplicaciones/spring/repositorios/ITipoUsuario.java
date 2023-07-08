package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.TipoUsuario;
@Repository
public interface ITipoUsuario extends JpaRepository<TipoUsuario, Serializable>{
	public abstract TipoUsuario findById(Long id);
	public abstract TipoUsuario findByNombre(String tipousuario);
}