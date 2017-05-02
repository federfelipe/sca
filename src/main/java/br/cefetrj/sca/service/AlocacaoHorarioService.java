package br.cefetrj.sca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.repositories.TurmaRepositorio;

public class AlocacaoHorarioService {
	
	private TurmaRepositorio turmaRepositorio;
	
	private ItemHorario itemHorarioInicio;
	
	private ItemHorario itemHorarioFim;

}
