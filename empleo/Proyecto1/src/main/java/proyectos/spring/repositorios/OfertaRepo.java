package proyectos.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyectos.spring.modelo.Oferta;
//@EnableJpaRepositories
@Repository
public interface OfertaRepo extends JpaRepository<Oferta,Long> {
	//Oferta findByTitulo(String titulo);
}
