package br.cefetrj.sca.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "alocacao_horario")  
public class AlocacaoHorario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private ItemHorario itemHorario;
	
	@ManyToOne
	private Turma turma;
	
	public ItemHorario getItemHorario() {
		return itemHorario;
	}
	
	public Turma getTurma() {
		return turma;
	}
	
	public void setItemHorario(ItemHorario itemHorario) {
		this.itemHorario = itemHorario;				
	}
	
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	/*private ItemHorario itemHorarioInicio;*/
	/*private ItemHorario itemHorarioFim;*/
	
	@SuppressWarnings("unused")
	private AlocacaoHorario() {
	}
	
/*	public AlocacaoHorario( Turma turmaId, ItemHorario itemHorarioInicio, ItemHorario itemHorarioFim ) {
		this.turmaId = turmaId;
		this.itemHorarioInicio = itemHorarioInicio;
		this.itemHorarioFim = itemHorarioFim;
	}*/
	
	public Long getId() {
		return this.id;
	}
	
	/*public Turma getTurmaId() {
		return this.turmaId;
	}*/
	
	/*public ItemHorario getItemHorarioInicio() {
		return this.itemHorarioInicio;
	}
	
	public ItemHorario getItemHorarioFim() {
		return this.itemHorarioFim;
	}*/
	
	/*public void setTurmaId( Turma turmaId ) {
		this.turmaId = turmaId;
	}*/
	
	/*public void setItemHorarioInicio( ItemHorario itemHorarioInicio ) {
		this.itemHorarioInicio = itemHorarioInicio;
	}
	
	public void setItemHorarioFim( ItemHorario itemHorarioFim ) {
		this.itemHorarioFim = itemHorarioFim;
	}*/
	

}
