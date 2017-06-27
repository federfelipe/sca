package br.cefetrj.sca.web.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.cefetrj.sca.dominio.Disciplina;
import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.LocalAula;
import br.cefetrj.sca.dominio.Professor;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.dominio.usuarios.Usuario;
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
/*	@RequestMapping(value = "/salvaGrade", method = RequestMethod.POST)
	public String salvaGradeHorario(@Valid @ModelAttribute("turma")Turma turma, 
		      BindingResult result, ModelMap model) {
		
		if (result.hasErrors()) {
            return "error";
        }
		//@ModelAttribute("somedata") Turma data@PathVariable("codigoturma") String cod, Model model//
		// Obs: o jsp nao esta chamando esse metodo. O mapeamento nao esta funcionando corretamente
		//Map<String, String[]> parameters = request.getParameterMap();
		
		String cara = cod;
		System.out.println("Isso!");
		System.out.println("Felipe TESTANDO MUITO!");
		// retorna uma jsp informando que a grade de horários foi salva na base
		return "/alocacaoHorario/salvarAlocacaoHorarioView";
	}*/
	
	// Form Luiz
	@RequestMapping(value = "/definirTabela")
   	public String exibeMontarTabela(ModelMap model) {		  	
  		 		
 
 		List<Turma> turmas = alocaHorarioService.findAllTurmas();
 		List<Disciplina> disciplinas = alocaHorarioService.findAllDisciplinas();
 		List<Professor> professores = alocaHorarioService.findAllProfessores();
 		List<ItemHorario> itensHorario = alocaHorarioService.findAllItensHorario();
 	//	List<String> diasSemana = alocaHorarioService.getAllDiasSemana();
 		List<LocalAula> locaisAula = alocaHorarioService.findAllLocaisAula();
 		
 		model.addAttribute("turmas", turmas);
 		model.addAttribute("disciplinas", disciplinas);
 		model.addAttribute("professores", professores);
 	//	model.addAttribute("diasSemana", diasSemana);
 		model.addAttribute("horas", itensHorario);
 	//	model.addAttribute("horasFim", itensHorario);
 		model.addAttribute("locaisAula", locaisAula);
 		  		  
  		return "/alocacaoHorario/alocacaoHorarioViewTest";	
  				 		
  	}
	
	
	// Outro caminho
		
	/**
	 * lista Turmas
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listTurmas(ModelMap model) {

		List<Turma> turmas = alocaHorarioService.findLastTurmas();
		model.addAttribute("turmas", turmas);

		return "/alocacaoHorario/turmaslist";
	}
	
	/**
	 *  add turma.
	 */
	@RequestMapping(value = { "/newturma" }, method = RequestMethod.GET)
	public String newTurma(ModelMap model) {
		
	    List<Turma> turmas = alocaHorarioService.findAllTurmas();
		List<Disciplina> disciplinas = alocaHorarioService.findAllDisciplinas();
		List<Professor> professores = alocaHorarioService.findAllProfessores();
		
		model.addAttribute("turmaModel", new Turma());
		model.addAttribute("turmas", turmas);
		model.addAttribute("disciplinas", disciplinas);
		model.addAttribute("professores", professores);		
		
		return "/alocacaoHorario/turmaregistrar";
	
	}
/*	
	*//**
	 * submissao do formulário, post request para salvar no banco
	 *//*
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid Turma turma, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "/usuarios/registration";
		}

		if (!usuarioService.isLoginJaExistente(user.getId(), user.getLogin())) {
			FieldError loginError = new FieldError("user", "login", messageSource.getMessage("non.unique.login",
					new String[] { user.getLogin() }, Locale.getDefault()));
			result.addError(loginError);
			return "/usuarios/registration";
		}

		usuarioService.adicionarUsuario(user);

		model.addAttribute("success", "Usuário " + user.getNome() + " registrado com sucesso");

		return "/usuarios/registrationsuccess";
	}*/
	

	 // tentativa
	  @RequestMapping(value = "/felipe", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("turma")Turma turma, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        System.out.print("FELIPEEEEEEEEEEEEEEEEEEEE");
        model.addAttribute("codigo", turma.getCodigo());
        model.addAttribute("periodo", turma.getPeriodo());
        model.addAttribute("disciplina", turma.getDisciplina());
        model.addAttribute("professor", turma.getDisciplina());
        return "/alocacaoHorario/turmaslist";
    }  
	  
	  
	  
	  /**
	  * Este método remove uma turma identificada pelo id.  FUNCIONANDO!
	 */
	@RequestMapping(value = { "/delete-turma-{id}" }, method = RequestMethod.GET)
		public String deleteTurma(@PathVariable long id) {
		  alocaHorarioService.deleteTurma(id);
			return "redirect:/alocacaoHorario/list"; 
		}

	
	/**
	 * Esse método fornece uma view para atualizar uma turma .  FUNCIONANDO!
	 */
	@RequestMapping(value = { "/edit-turma-{id}" }, method = RequestMethod.GET)
	public String editTurma(@PathVariable long id, ModelMap model) {
		Turma turma = alocaHorarioService.findTurmaById(id);
		model.addAttribute("turma", turma);
		model.addAttribute("edit", true);
		return "/alocacaoHorario/turmaedit";
	}
	
	/**
	 * Esse método fornece uma view para atualizar uma turma com alocaHorario.  FUNCIONANDO!
	 */
	@RequestMapping(value = { "/edit-turmaAlocaHorario-{id}" }, method = RequestMethod.GET)
	public String editTurmaAlocaHorario(@PathVariable long id, ModelMap model) {
		Turma turma = alocaHorarioService.findTurmaById(id);
		List<ItemHorario> itensHorario = alocaHorarioService.findAllItensHorario();
		model.addAttribute("horas", itensHorario);
		model.addAttribute("turma", turma);
		model.addAttribute("edit", true);
		return "/alocacaoHorario/turmaalocahorario";
	}
	
	 		 		
 /*
 		List<Turma> turmas = alocaHorarioService.findAllTurmas();
 		List<Disciplina> disciplinas = alocaHorarioService.findAllDisciplinas();
 		List<Professor> professores = alocaHorarioService.findAllProfessores();
 		List<ItemHorario> itensHorario = alocaHorarioService.findAllItensHorario();
 		List<String> diasSemana = alocaHorarioService.getAllDiasSemana();
 		List<LocalAula> locaisAula = alocaHorarioService.findAllLocaisAula();
 		
 		model.addAttribute("turmas", turmas);
 		model.addAttribute("disciplinas", disciplinas);
 		model.addAttribute("professores", professores);
 		model.addAttribute("diasSemana", diasSemana);
 		model.addAttribute("horas", itensHorario);
 	//	model.addAttribute("horasFim", itensHorario);
 		model.addAttribute("locaisAula", locaisAula);
 		  		  
  		return "/alocacaoHorario/alocacaoHorarioViewTest";	
  				 		
  	}*/
	
 }
	


