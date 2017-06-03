package br.cefetrj.sca.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.dominio.repositories.DisciplinaRepositorio;
import br.cefetrj.sca.dominio.repositories.ItemHorarioRepositorio;
import br.cefetrj.sca.dominio.repositories.LocalAulaRepositorio;
import br.cefetrj.sca.dominio.repositories.ProfessorRepositorio;
import br.cefetrj.sca.dominio.repositories.TurmaRepositorio;

@Service
@Transactional
public class AlocacaoHorarioService {
	
	@Autowired
	private TurmaRepositorio turmaRepositorio;
	
	private ItemHorarioRepositorio itemHorarioRepositorio;
	
	private DisciplinaRepositorio disciplinaRepositorio;
	
	private ProfessorRepositorio professorController;
	
	private LocalAulaRepositorio localAulaRepositorio;
	
	private ItemHorario itemHorarioInicio;
	
	private ItemHorario itemHorarioFim;
	
	// # estou usando esse método #
	public List<Turma> findAll() {
		return turmaRepositorio.findAll();
	}

	
	public List<ItemHorario> getItensHorario() {
		List<ItemHorario> itensHorario = itemHorarioRepositorio.findAll();
		return itensHorario;
	}
	
	public List<Date> getHorariosInicio(List<ItemHorario> itensHorario) {
		List<Date> horariosInicio = new ArrayList<Date>();
		for(ItemHorario itemHorario : itensHorario) {
		/*	Date horaInicio = itemHorario.getHoraInicio();
			horariosInicio.add(horaInicio);*/
		}
		return horariosInicio;
	}
	
	public List<Date> getHorariosFim(List<ItemHorario> itensHorario) {
		List<Date> horariosFim = new ArrayList<Date>();
		for(ItemHorario itemHorario : itensHorario) {
		/*	Date horaFim = itemHorario.getHoraFim();
			horariosFim.add(horaFim);*/
		}
		return horariosFim;
	}

}
