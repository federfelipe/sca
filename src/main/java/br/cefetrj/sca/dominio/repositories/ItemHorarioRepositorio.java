package br.cefetrj.sca.dominio.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.cefetrj.sca.dominio.ItemHorario;

public interface ItemHorarioRepositorio extends JpaRepository<ItemHorario, Serializable> {
	
	/*@Query("SELECT * FROM itemhorario WHERE id = ?1")
	public ItemHorario getItemHorario(Long id);*/
	
	/*@Query("SELECT * FROM itemhorario WHERE dia = ?1")
	public List<ItemHorario> findItensHorariosByDiaSemana(String dia); */
	
	/*@Query("SELECT * FROM itemhorario WHERE tempo = ?1")
	public List<ItemHorario> findItensHorariosByTempo(int tempo);*/
	
	/*@Query("SELECT * FROM itemhorario WHERE turno = ?1")
	public List<ItemHorario> findItensHorariosByTurno(int turno);*/
	
/*	@Query("SELECT * FROM itemhorario WHERE inicio = ?1")
	public List<ItemHorario> findItemHorariosByHoraInicio(Date horaInicio);*/
	
	/*@Query("SELECT * FROM itemhorario WHERE fim = ?1")
	public List<ItemHorario> findItemHorariosByHoraFim(Date horaFim);*/

}
