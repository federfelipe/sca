package br.cefetrj.sca.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.EnumDiaSemana;
import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.LocalAula;
import br.cefetrj.sca.dominio.Professor;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.dominio.repositories.ItemHorarioRepositorio;
import br.cefetrj.sca.dominio.repositories.LocalAulaRepositorio;
import br.cefetrj.sca.dominio.repositories.ProfessorRepositorio;
import br.cefetrj.sca.dominio.repositories.TurmaRepositorio;

@Service
@Transactional
public class AlocacaoHorarioService {
	
	@Autowired
	private TurmaRepositorio turmaRepositorio;
	
	// Nao esta funcionando
	@Autowired
	private ItemHorarioRepositorio itemHorarioRepositorio;
	
	@Autowired
	private ProfessorRepositorio professorRepositorio;
	
	@Autowired
	private LocalAulaRepositorio localAulaRepositorio;
	
	public List<ItemHorario> getItensHorario() {
		List<ItemHorario> itensHorario = itemHorarioRepositorio.findAll();
		return itensHorario;
	}
	
	// Metodo adicionado
	public List<Turma> findAllTurmas() {
		return turmaRepositorio.findAll();
	}
	
	// Metodo adicionado
	public List<Disciplina> findAllDisciplinas() {
		List<Turma> turmas = findAllTurmas();
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for(Turma turma : turmas)
		{
			Disciplina disciplina = turma.getDisciplina();
			disciplinas.add(disciplina);
		}
		return disciplinas;
	}
	
	// Metodo adicionado
	public List<Professor> findAllProfessores() {
		return professorRepositorio.findAll();
	}
	
	// Metodo adicionado
	public List<ItemHorario> findAllItensHorario() {
		return itemHorarioRepositorio.findAll();
	}
	
	// Metodo adicionado
	public List<String> getAllHorasInicio() {
		List<String> horasInicio = new ArrayList<String>();
		List<ItemHorario> itensHorario = itemHorarioRepositorio.findAll();
		for(ItemHorario itemHorario : itensHorario)
		{
			String horaInicio = itemHorario.getInicio();
			horasInicio.add(horaInicio);
		}
		return horasInicio;
	}
	
	// Metodo adicionado
	public List<String> getAllHorasFim() {
		List<String> horasFim = new ArrayList<String>();
		List<ItemHorario> itensHorario = itemHorarioRepositorio.findAll();
		for(ItemHorario itemHorario : itensHorario)
		{
			String horaFim = itemHorario.getFim();
			horasFim.add(horaFim);
		}
		return horasFim;
	}
	
	// Metodo adicionado
	public List<String> getAllDiasSemana() {
		return EnumDiaSemana.dias();
	}
	
	// Metodo adicionado
	public List<String> getAllDescricoesLocaisAula() {
		List<LocalAula> locaisAula = localAulaRepositorio.findAll();
		List<String> descricoes = new ArrayList<String>();
		for(LocalAula localAula : locaisAula){
			descricoes.add(localAula.getDescricao());
		}
		return descricoes;
	}
	
	// Metodo adicionado
	public List<LocalAula> findAllLocaisAula() {
		return localAulaRepositorio.findAll();
	}
	

}
