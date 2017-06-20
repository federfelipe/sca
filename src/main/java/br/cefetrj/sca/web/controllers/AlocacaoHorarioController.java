package br.cefetrj.sca.web.controllers;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.LocalAula;
import br.cefetrj.sca.dominio.Professor;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.service.AlocacaoHorarioService;

@Controller
@SessionAttributes("matricula")
@RequestMapping("/alocacaoHorario")
public class AlocacaoHorarioController {
	
	protected Logger logger = Logger.getLogger(AvaliacaoTurmaController.class.getName());
	
	@Autowired
	private AlocacaoHorarioService alocaHorarioService; 

	@RequestMapping(value = "/{*}", method = RequestMethod.GET)
	public String get(Model model) {
		model.addAttribute("error", "Erro: página não encontrada.");
		return "/homeView";
	}
	
	@RequestMapping(value = "/menuPrincipal", method = RequestMethod.GET)
	public String retornaMenuPrincipal() {
		return "/menuPrincipalView";
	}
	
	@RequestMapping(value = "/montarTabela", method = RequestMethod.GET)
	public String exibeMontarTabela(Model model) {

		List<Turma> turmas = alocaHorarioService.findAllTurmas();
		List<Disciplina> disciplinas = alocaHorarioService.findAllDisciplinas();
		List<Professor> professores = alocaHorarioService.findAllProfessores();
//		List<ItemHorario> itensHorario = alocaHorarioService.findAllItensHorario();
		List<String> diasSemana = alocaHorarioService.getAllDiasSemana();
		List<LocalAula> locaisAula = alocaHorarioService.findAllLocaisAula();
		
		model.addAttribute("turmas", turmas);
		model.addAttribute("disciplinas", disciplinas);
		model.addAttribute("professores", professores);
//		model.addAttribute("horasInicio", itensHorario);
//		model.addAttribute("horasFim", itensHorario);
		model.addAttribute("diasSemana", diasSemana);
		model.addAttribute("locaisAula", locaisAula);
		
		return "/alocacaoHorario/alocacaoHorarioView";
		
	}
	
	// Pega os dados submetidos pelo form, monta a grade e salva na base
	@RequestMapping(value = "/salvaGrade", method = RequestMethod.POST)
	public String salvaGradeHorario(Model model) {
		// Obs: o jsp nao esta chamando esse metodo. O mapeamento nao esta funcionando corretamente
		//Map<String, String[]> parameters = request.getParameterMap();
		
		// retorna uma jsp informando que a grade de horários foi salva na base
		return "/alocacaoHorario/salvarAlocacaoHorarioView";
	}

}
