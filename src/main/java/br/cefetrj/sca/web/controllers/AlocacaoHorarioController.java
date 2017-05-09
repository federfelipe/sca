package br.cefetrj.sca.web.controllers;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.cefetrj.sca.service.AvaliacaoTurmaService;

@Controller
@SessionAttributes("matricula")
@RequestMapping("/alocacaoHorario")
public class AlocacaoHorarioController {
	
	protected Logger logger = Logger.getLogger(AvaliacaoTurmaController.class.getName());

	@Autowired
	private AvaliacaoTurmaService service;

	@RequestMapping(value = "/{*}", method = RequestMethod.GET)
	public String get(Model model) {
		model.addAttribute("error", "Erro: página não encontrada.");
		return "/homeView";
	}
	
	@RequestMapping(value = "/menuPrincipal")
	public String solicitaNovamenteAlocacaoHorario() {
		return "/menuPrincipalView";
	}
	
	@RequestMapping(value = "/solicitaNovamenteAlocacaoHorario")
	public String solicitaNovamenteAlocacaoHorario(@ModelAttribute("matricula") String matricula, Model model) {

		try {
			model.addAttribute("turmasCadastradas", service.obterTurmasCursadas(matricula));

			return "/alocacaoHorario/apresentaListagemTurmasView";
		} catch (Exception exc) {
			model.addAttribute("error", exc.getMessage());

			return "/alocacaoHorario/solicitaAvaliacaoView";
		}
	}
	
	@RequestMapping(value = "/definirTabela")
	public String exibeMontarTabela() {
		return "/alocacaoHorarioTurma/alocacaoHorarioView";
		
	}

}
