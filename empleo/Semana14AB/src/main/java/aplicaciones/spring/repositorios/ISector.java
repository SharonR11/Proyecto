package aplicaciones.spring.repositorios;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Sector;
@Repository
public interface ISector extends JpaRepository<Sector, Serializable>{
	public abstract Sector findById(Long id);
}

