package com.fiap.globalsolution.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "INDICADORES_MSTR")
public class IndicadoresMstr {
	@Id
	@Column(length = 10, name = "id_indicador")
	private String idIndicador;

	@Column(length = 255, name = "desc_indicador")
	private String descIndicador;

	@Column(length = 20, name = "tipo_indicador")
	private String tipoIndicador;

	@ManyToOne(targetEntity = Objetivos.class)
	@JoinColumn(name = "id_objetivo")
	private Objetivos objetivo;

	@OneToMany(mappedBy = "indicadorMstr", fetch = FetchType.EAGER)
	private List<IndicadoresDet> indicadoresDetList;

	public IndicadoresMstr(String idIndicador, String descIndicador, String tipoIndicador, Objetivos objetivo) {
		this.idIndicador = idIndicador;
		this.descIndicador = descIndicador;
		this.tipoIndicador = tipoIndicador;
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

	public String getTipoIndicador() {
		return tipoIndicador;
	}

	public void setTipoIndicador(String tipoIndicador) {
		this.tipoIndicador = tipoIndicador;
	}

	public Objetivos getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivos objetivo) {
		this.objetivo = objetivo;
	}

	public List<IndicadoresDet> getIndicadoresDetList() {
		return indicadoresDetList;
	}

	public void setIndicadoresDetList(List<IndicadoresDet> indicadoresDetList) {
		this.indicadoresDetList = indicadoresDetList;
	}
}
