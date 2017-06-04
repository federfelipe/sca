package br.cefetrj.sca.web.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.cefetrj.sca.dominio.Disciplina;
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
//		List<Professor> professores = alocaHorarioService.findAllProfessores();
//		List<String> horasInicio = alocaHorarioService.getAllHorasInicio();
//		List<String> horasFim = alocaHorarioService.getAllHorasFim();
		List<String> diasSemana = alocaHorarioService.getAllDiasSemana();
		
		model.addAttribute("turmas", turmas);
		model.addAttribute("disciplinas", disciplinas);
//		model.addAttribute("professores", professores);
//		model.addAttribute("horasInicio", horasInicio);
//		model.addAttribute("horasFim", horasFim);
		model.addAttribute("diasSemana", diasSemana);
		
		return "/alocacaoHorario/alocacaoHorarioView";
		
	}
	
	// Metodo usado antes apenas para teste. Depois sera removido
	@RequestMapping(value = "/definirTabela")
	public String exibeMontarTabela(ModelMap model) {
		
		List<Turma> turmas = alocaHorarioService.findAll();
		model.addAttribute("turmas", turmas);

		return "/alocacaoHorarioTurma/alocacaoHorarioView";
		
	}

}
