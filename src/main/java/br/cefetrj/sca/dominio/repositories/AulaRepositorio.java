package br.cefetrj.sca.dominio.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.cefetrj.sca.dominio.Aula;

public interface AulaRepositorio extends JpaRepository<Aula, Serializable> {
	
	@Query("SELECT a from Aula a WHERE a.id = ?1")
	Aula findAulaById(Long idAula);
	
	@Query("SELECT a from Aula a WHERE a.local_id = ?1")
	List<Aula> findAulasByLocal(Long localId);
	
}
