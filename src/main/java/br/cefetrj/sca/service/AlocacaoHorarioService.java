package br.cefetrj.sca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.cefetrj.sca.dominio.ItemHorario;
import br.cefetrj.sca.dominio.Turma;
import br.cefetrj.sca.dominio.repositories.TurmaRepositorio;
import br.cefetrj.sca.dominio.usuarios.Usuario;

public class AlocacaoHorarioService {
	
	private TurmaRepositorio turmaRepositorio;
	
	private ItemHorario itemHorarioInicio;
	
	private ItemHorario itemHorarioFim;
	
	
	public List<Turma> findAll() {
		return turmaRepositorio.findAll();
	}

}
