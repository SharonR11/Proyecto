package proyectos.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectos.spring.modelo.Postular;
@Repository
public interface PostularRepo extends JpaRepository<Postular,Long>{

}
