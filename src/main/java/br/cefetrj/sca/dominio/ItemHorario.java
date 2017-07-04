package br.cefetrj.sca.dominio;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemHorario {
	@Id
	@GeneratedValue
	private Long id;

	@Embedded
	private IntervaloTemporal tempoAula;

	@Enumerated(EnumType.STRING)
	EnumDiaSemana dia;
	
	private int turno;
	
	private int tempo;

	@SuppressWarnings("unused")
	private ItemHorario() {
	}

	public ItemHorario(EnumDiaSemana dia, IntervaloTemporal tempoAula) {
		this.tempoAula = tempoAula;
		this.dia = dia;
	}
	
	public ItemHorario(EnumDiaSemana dia, IntervaloTemporal tempoAula, int turno, int tempo) {
		this(dia, tempoAula);
		this.turno = turno;
		this.tempo = tempo;
	}

	public Long getId() {
		return id;
	}

	public String getFim() {
		return this.tempoAula.getFim();
	}

	public String getInicio() {
		return this.tempoAula.getInicio();
	}
	
	public boolean colide(ItemHorario item) {
		return this.tempoAula.colide(item.tempoAula);
	}
	
	public EnumDiaSemana getDia()
	{
		return this.dia;
	}
		
	public void setDia(EnumDiaSemana dia)
	{
		this.dia = dia;
	}
	
	public int getTurno(){
		return this.turno;
	}
	
	public int getTempo(){
		return this.tempo;
	}

}