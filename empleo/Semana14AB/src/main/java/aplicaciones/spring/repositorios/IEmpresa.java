package aplicaciones.spring.repositorios;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aplicaciones.spring.modelo.Empresa;
@Repository
public interface IEmpresa extends JpaRepository<Empresa, Serializable>{
	public abstract Empresa findById(Long id);
	public abstract Empresa findByNombre(String empresa);
}