package br.cefetrj.sca.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.cefetrj.sca.dominio.AlocacaoHorario;
import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.EnumDiaSemana;
import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.LocalAula;
import br.cefetrj.sca.dominio.Professor;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.dominio.repositories.AlocacaoHorarioRepositorio;
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
	
	// Nao esta funcionando
	@Autowired
	private ItemHorarioRepositorio itemHorarioRepositorio;
	
	@Autowired
	private ProfessorRepositorio professorRepositorio;
	
	@Autowired
	private LocalAulaRepositorio localAulaRepositorio;
	
	@Autowired 
	private AlocacaoHorarioRepositorio alocacaoHorarioRepositorio;
	
	@Autowired
	private DisciplinaRepositorio disciplinaRepositorio;
	
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
	/*public List<String> getAllHorasInicio() {
		List<String> horasInicio = new ArrayList<String>();
		List<ItemHorario> itensHorario = itemHorarioRepositorio.findAll();
		for(ItemHorario itemHorario : itensHorario)
		{
			String horaInicio = itemHorario.getInicio();
			horasInicio.add(horaInicio);
		}
		return horasInicio;
	}*/
	
	// Metodo adicionado
	/*public List<String> getAllHorasFim() {
		List<String> horasFim = new ArrayList<String>();
		List<ItemHorario> itensHorario = itemHorarioRepositorio.findAll();
		for(ItemHorario itemHorario : itensHorario)
		{
			String horaFim = itemHorario.getFim();
			horasFim.add(horaFim);
		}
		return horasFim;
	}*/
	
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
	
	public void deleteTurma(Long id) {
		Turma turma = turmaRepositorio.findTurmaById(id);
		turmaRepositorio.delete(turma);
	}
	
	public Turma findTurmaById(Long id) {
		return turmaRepositorio.findTurmaById(id);
	}
	
	public List<Turma> findLastTurmas() {
		return turmaRepositorio.findLastTurmas();
	}

	public void atualizarTurma(Turma turma, Disciplina disciplina, Professor professor) {
		if (turma != null) {
			turma.setDisciplina(disciplina);
			turma.setProfessor(professor);
		}
		
	}

	public Disciplina findDisciplinaById(long disciplina) {
		return disciplinaRepositorio.findDisciplinaById(disciplina);
	}

	public Professor findProfessorById(long professor) {
		return professorRepositorio.findProfessorById(professor);
	}

	public List<AlocacaoHorario> findAllAlocacaoHorario() {
		return alocacaoHorarioRepositorio.findAll();
	}
    
	/*public void atualizarUsuario(Usuario user) {
		Usuario entity = repositorio.findOne(user.getId());
		if (entity != null) {
			entity.setLogin(user.getLogin());
			entity.setNome(user.getNome());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}*/
	
}
