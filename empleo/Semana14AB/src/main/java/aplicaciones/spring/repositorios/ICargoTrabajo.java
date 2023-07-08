package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplicaciones.spring.modelo.CargoTrabajo;
@Repository
public interface ICargoTrabajo extends JpaRepository<CargoTrabajo, Serializable>{
	public abstract CargoTrabajo findById(Long id);
}

