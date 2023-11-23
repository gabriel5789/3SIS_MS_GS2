package com.fiap.globalsolution.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "INDICADORES_MSTR")
public class IndicadoresMstr {
	@Id
	@Column(length = 10, name = "id_indicador")
	private String idIndicador;

	@Column(length = 255, name = "desc_indicador")
	private String descIndicador;

	@ManyToOne(targetEntity = Objetivos.class)
	@JoinColumn(name = "id_objetivo")
	private Objetivos objetivo;

	public IndicadoresMstr(String idIndicador, String descIndicador, Objetivos objetivo) {
		this.idIndicador = idIndicador;
		this.descIndicador = descIndicador;
		this.objetivo = objetivo;
	}

	public IndicadoresMstr() {
	}

	public String getIdIndicador() {
		return idIndicador;
	}

	public void setIdIndicador(String idIndicador) {
		this.idIndicador = idIndicador;
	}

	public String getDescIndicador() {
		return descIndicador;
	}

	public void setDescIndicador(String descIndicador) {
		this.descIndicador = descIndicador;
	}

	public Objetivos getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivos objetivo) {
		this.objetivo = objetivo;
	}
}
