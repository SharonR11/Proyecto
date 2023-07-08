package aplicaciones.spring.repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import aplicaciones.spring.modelo.Estudiante;

public interface IEstudiante extends JpaRepository<Estudiante, Serializable>{
	public abstract Estudiante findById(Long id);
}

