package br.cefetrj.sca.dominio;

public class AlocacaoHorario {
	
	private Long id;
	
	private Turma turmaId;
	private ItemHorario itemHorarioInicio;
	private ItemHorario itemHorarioFim;
	
	@SuppressWarnings("unused")
	private AlocacaoHorario() {
	}
	
	public AlocacaoHorario( Turma turmaId, ItemHorario itemHorarioInicio, ItemHorario itemHorarioFim ) {
		this.turmaId = turmaId;
		this.itemHorarioInicio = itemHorarioInicio;
		this.itemHorarioFim = itemHorarioFim;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public Turma getTurmaId() {
		return this.turmaId;
	}
	
	public ItemHorario getItemHorarioInicio() {
		return this.itemHorarioInicio;
	}
	
	public ItemHorario getItemHorarioFim() {
		return this.itemHorarioFim;
	}
	
	public void setTurmaId( Turma turmaId ) {
		this.turmaId = turmaId;
	}
	
	public void setItemHorarioInicio( ItemHorario itemHorarioInicio ) {
		this.itemHorarioInicio = itemHorarioInicio;
	}
	
	public void setItemHorarioFim( ItemHorario itemHorarioFim ) {
		this.itemHorarioFim = itemHorarioFim;
	}
	

}
