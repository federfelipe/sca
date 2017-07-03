package br.cefetrj.sca.web.controllers;

import java.util.List;
import java.util.logging.Logger;

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

import br.cefetrj.sca.dominio.AlocacaoHorario;
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
	
/*	@RequestMapping(value = "/montarTabela", method = RequestMethod.GET)
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
		
	}*/
	
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
	
/*	// Form Luiz
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
  				 		
  	}*/
	
	 /** TURMAS */
	
	/**
	 * Menu Principal - Listar Turmas
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listTurmas(ModelMap model) {

		List<Turma> turmas = alocaHorarioService.findLastTurmas();
		Turma turma = new Turma();
		int numberOfTurmas = getNumOfElementInList(turmas, turma);
		model.addAttribute("countTurmas", numberOfTurmas);
		model.addAttribute("turmas", turmas);
		return "/alocacaoHorario/turmaslist";
	}
	
	public int getNumOfElementInList(List<Turma> list, Object Turma){
		   int count = 0;
		   for(Turma element: list){
		      if(element.equals(Turma)) 
		    	  System.out.print("Entrou!!!");
		    	  count++;
		     	  
		   }
		   return count;
	}	
	
	/**
	 *  add Turma
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
	
	/**
	  * remove Turma id.  FUNCIONANDO!
	 */
	@RequestMapping(value = { "/delete-turma-{id}" }, method = RequestMethod.GET)
		public String deleteTurma(@PathVariable long id) {
		  alocaHorarioService.deleteTurma(id);
		  return "redirect:/alocacaoHorario/list"; 
		}
	
    /**
	 * View Update Turma
	 */
	@RequestMapping(value = { "/edit-turma-{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable long id, ModelMap model) {
	
		Turma turma = alocaHorarioService.findTurmaById(id);
		List<Disciplina> disciplinas = alocaHorarioService.findAllDisciplinas();
		List<Professor> professores = alocaHorarioService.findAllProfessores();	
		
    	model.addAttribute("turma", turma);	
		model.addAttribute("disciplinas", disciplinas);	
		model.addAttribute("professores", professores);	
		
		System.out.println("AQUIIIII CACETE!");
    	return "/alocacaoHorario/turmaedit";
	}

	/**
	 * Este método, chamado na submissão do form, manipula a requisição POST
	 * para atualizar um usuário. Ele também valida os dados fornecidos.
	 */  
	@RequestMapping(value = { "/edit-turma-{id}" }, method = RequestMethod.POST) //
	public String updateUser(@Valid  @ModelAttribute Turma turma, BindingResult result, ModelMap model, @PathVariable long id, 
			@RequestParam long disciplina, @RequestParam long professor) {
		
		for (Object object : result.getAllErrors()) {
		    if(object instanceof FieldError) {
		        FieldError fieldError = (FieldError) object;
		        System.out.println(fieldError.getCode());
		    }
		}	
		
		if (result.hasErrors()) {
			Turma turmaUpdate = alocaHorarioService.findTurmaById(id);
			Disciplina disciplinaUpdate = alocaHorarioService.findDisciplinaById(disciplina);
			Professor professorUpdate = alocaHorarioService.findProfessorById(professor);
			System.out.println("está entrando aqui!");
			alocaHorarioService.atualizarTurma(turmaUpdate, disciplinaUpdate, professorUpdate);
			return "redirect:/alocacaoHorario/list";
		}
		
		Turma turmaUpdate = alocaHorarioService.findTurmaById(id);
		Disciplina disciplinaUpdate = alocaHorarioService.findDisciplinaById(disciplina);
		Professor professorUpdate = alocaHorarioService.findProfessorById(professor);
		System.out.println("está entrando aqui!");
		alocaHorarioService.atualizarTurma(turmaUpdate, disciplinaUpdate, professorUpdate);
		return "redirect:/alocacaoHorario/list";
	}
	
		
	/** Alocação Horario */
	
	 /** Menu Principal - Alocação de Horário */
	
		@RequestMapping(value = { "/alocahorario" }, method = RequestMethod.GET)
		public String listAlocaHorarioTurmas(ModelMap model) {

			List<ItemHorario> itensHorario = alocaHorarioService.findAllItensHorario();
			List<AlocacaoHorario> alocacaoHorario = alocaHorarioService.findAllAlocacaoHorario();
			model.addAttribute("horas", itensHorario);
			//model.addAttribute("turma", turma);
			model.addAttribute("edit", true);
			model.addAttribute("alocacaoHorario",alocacaoHorario);
			return "/alocacaoHorario/alocaHorarioList";
		}	
	
	/**
	 * View para atualizar uma turma com alocaHorario.  FUNCIONANDO!
	 */
	@RequestMapping(value = { "/edit-turmaAlocaHorario-{id}" }, method = RequestMethod.GET)
	public String editTurmaAlocaHorario(@PathVariable long id, ModelMap model) {
		Turma turma = alocaHorarioService.findTurmaById(id);
		List<ItemHorario> itensHorario = alocaHorarioService.findAllItensHorario();
		List<AlocacaoHorario> alocacaoHorario = alocaHorarioService.findAllAlocacaoHorario();
		model.addAttribute("horas", itensHorario);
		model.addAttribute("turma", turma);
		model.addAttribute("edit", true);
		model.addAttribute("alocacaoHorario",alocacaoHorario);
		return "/alocacaoHorario/turmaalocahorario";
	}
	//Request Mapping (value = { "/edit-turmaAlocaHorario-{id}" }
	//@Valid  @ModelAttribute Turma turma, BindingResult result,
	@RequestMapping(value = { "/edit-turmaAlocaHorario" }, method = RequestMethod.POST)
	public String updateTurmaAlocaHorario(ModelMap model, @RequestParam String nomeTurma, 
			@RequestParam String nomeProfessor) {
		//Turma turma = alocaHorarioService.findTurmaById(id);
		System.out.print(nomeProfessor);
		
		/*System.out.println("CHEGOU AQUI");
		List<ItemHorario> itensHorario = alocaHorarioService.findAllItensHorario();
		model.addAttribute("horas", itensHorario);
		model.addAttribute("turma", turma);
		model.addAttribute("edit", true);*/
		return "/alocacaoHorario/turmaalocahorario2";
	}
	
/*	////////////////////////////////////////////////
	 //	System.out.println("Esse é o ID: " + id);
	 // System.out.println("Esse é o ID da disciplina: " + disciplina);
	 //	System.out.println("Esse é o ID do professor: " + professor);
	//	System.out.println(turma); O objeto 'turma' do Jsp está vindo 'null' 
				
		// Print da mensagem de erro
		for (Object object : result.getAllErrors()) {
		    if(object instanceof FieldError) {
		        FieldError fieldError = (FieldError) object;
		        System.out.println(fieldError.getCode());
		    }
		}	
		
		// teste erro
		if (result.hasErrors()) {
			Turma turmaUpdate = alocaHorarioService.findTurmaById(id);
			Disciplina disciplinaUpdate = alocaHorarioService.findDisciplinaById(disciplina);
			Professor professorUpdate = alocaHorarioService.findProfessorById(professor);
			System.out.println("está entrando aqui!");
			alocaHorarioService.atualizarTurma(turmaUpdate, disciplinaUpdate, professorUpdate);
			return "redirect:/alocacaoHorario/list";
		}
		
		Turma turmaUpdate = alocaHorarioService.findTurmaById(id);
		Disciplina disciplinaUpdate = alocaHorarioService.findDisciplinaById(disciplina);
		Professor professorUpdate = alocaHorarioService.findProfessorById(professor);
		System.out.println("está entrando aqui!");
		alocaHorarioService.atualizarTurma(turmaUpdate, disciplinaUpdate, professorUpdate);
		return "redirect:/alocacaoHorario/list";
	}*/
	
	
	
	
}
	