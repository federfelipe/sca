package br.cefetrj.sca.dominio.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.avaliacaoturma.AvaliacaoTurma;

public interface ItemHorarioRepositorio extends
JpaRepository<AvaliacaoTurma, Serializable> {
	
	@Query("SELECT item FROM itemhorario item WHERE item.id = ?1")
	public ItemHorario getItemHorario(Long id);
	
	@Query("SELECT item FROM itemhorario item WHERE item.dia_semana = ?1")
	public List<ItemHorario> findItensHorariosByDiaSemana(String dia);
	
	@Query("SELECT item FROM itemhorario item WHERE item.tempo = ?1")
	public List<ItemHorario> findItensHorariosByTempo(int tempo);
	
	@Query("SELECT item FROM itemhorario item WHERE item.turno = ?1")
	public List<ItemHorario> findItensHorariosByTurno(int turno);

}
