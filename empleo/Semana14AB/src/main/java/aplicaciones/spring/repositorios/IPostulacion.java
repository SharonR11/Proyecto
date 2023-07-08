package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Postulacion;

public interface IPostulacion extends JpaRepository<Postulacion, Serializable>{
	public abstract Postulacion findById(Long id);
}

