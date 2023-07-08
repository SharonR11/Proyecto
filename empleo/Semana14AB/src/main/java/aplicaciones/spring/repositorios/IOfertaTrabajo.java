package aplicaciones.spring.repositorios;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.OfertaTrabajo;
@Repository
public interface IOfertaTrabajo extends JpaRepository<OfertaTrabajo, Serializable>{
	public abstract OfertaTrabajo findById(Long id);
}
