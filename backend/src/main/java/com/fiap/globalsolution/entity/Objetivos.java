package com.fiap.globalsolution.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "OBJETIVOS")
public class Objetivos {
	@Id
	@Column(name = "id_objetivo", length = 10)
	private String idObjetivo;

	@Column(name = "desc_objetivo_global", length = 255)
	private String descObjetivoGlobal;

	@Column(name = "desc_objetivo_brasil", length = 255)
	private String descObjetivoBrasil;

	@OneToMany(targetEntity = IndicadoresMstr.class, fetch = FetchType.LAZY, mappedBy = "objetivo")
	private List<IndicadoresMstr> indicadoresMstr;

	public Objetivos(String idObjetivo, String descObjetivoGlobal, String descObjetivoBrasil, List<IndicadoresMstr> indicadoresMstr) {
		this.idObjetivo = idObjetivo;
		this.descObjetivoGlobal = descObjetivoGlobal;
		this.descObjetivoBrasil = descObjetivoBrasil;
		this.indicadoresMstr = indicadoresMstr;
	}

	public Objetivos() {
	}

	public String getIdObjetivo() {
		return idObjetivo;
	}

	public void setIdObjetivo(String idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	public String getDescObjetivoGlobal() {
		return descObjetivoGlobal;
	}

	public void setDescObjetivoGlobal(String descObjetivoGlobal) {
		this.descObjetivoGlobal = descObjetivoGlobal;
	}

	public String getDescObjetivoBrasil() {
		return descObjetivoBrasil;
	}

	public void setDescObjetivoBrasil(String descObjetivoBrasil) {
		this.descObjetivoBrasil = descObjetivoBrasil;
	}

	public List<IndicadoresMstr> getIndicadoresMstr() {
		return indicadoresMstr;
	}

	public void setIndicadoresMstr(List<IndicadoresMstr> indicadoresMstr) {
		this.indicadoresMstr = indicadoresMstr;
	}
}
