package br.cefetrj.sca.dominio.repositories;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.cefetrj.sca.dominio.ItemHorario;

public interface ItemHorarioRepositorio extends
JpaRepository<ItemHorario, Serializable> {
	
	@Query("SELECT ih FROM itemhorario ih WHERE ih.id = ?1")
	public ItemHorario getItemHorario(Long id);
	
	@Query("SELECT ih FROM itemhorario ih WHERE ih.dia_semana = ?1")
	public List<ItemHorario> findItensHorariosByDiaSemana(String dia);
	
	@Query("SELECT ih FROM itemhorario ih WHERE ih.tempo = ?1")
	public List<ItemHorario> findItensHorariosByTempo(int tempo);
	
	@Query("SELECT ih FROM itemhorario ih WHERE ih.turno = ?1")
	public List<ItemHorario> findItensHorariosByTurno(int turno);
	
	@Query("SELECT ih FROM itemhorario ih WHERE ih.hora_inicio = ?1")
	public List<ItemHorario> findItemHorariosByHoraInicio(Date horaInicio);
	
	@Query("SELECT ih FROM itemhorario ih WHERE ih.hora_fim = ?1")
	public List<ItemHorario> findItemHorariosByHoraFim(Date horaFim);

}
