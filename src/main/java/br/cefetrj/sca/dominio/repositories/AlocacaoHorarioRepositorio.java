package br.cefetrj.sca.dominio.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.cefetrj.sca.dominio.AlocacaoHorario;
import br.cefetrj.sca.dominio.Departamento;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.dominio.matriculaforaprazo.AlocacacaoDisciplinasEmDepartamento;

public interface AlocacaoHorarioRepositorio extends JpaRepository<AlocacaoHorario, Serializable> {
	
	@Query("SELECT t from AlocacaoHorario t WHERE t.id = ?1")
	AlocacaoHorario findAlocacaoHorarioById(Long idAlocacaoHorario);
	
} 