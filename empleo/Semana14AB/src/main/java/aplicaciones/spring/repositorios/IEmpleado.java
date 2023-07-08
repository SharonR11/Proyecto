package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Empleado;
@Repository
public interface IEmpleado extends JpaRepository<Empleado, Serializable>{
	public abstract Empleado findById(Long id);
}
