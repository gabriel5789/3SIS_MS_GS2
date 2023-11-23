package com.fiap.globalsolution.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.globalsolution.entity.IndicadoresDet;

import java.util.HashMap;
import java.util.Map;

public class IndicadorDetModel {
	private Integer ano;
	private String regiao;
	@JsonIgnore
	private String label;
	@JsonIgnore
	private Double valor;

	public IndicadorDetModel() {
	}

	public IndicadorDetModel(IndicadoresDet indicadoresDet) {
		assert indicadoresDet != null;
		assert indicadoresDet.getIndicadorMstr() != null;
		this.ano = indicadoresDet.getAno();
		this.regiao = indicadoresDet.getRegiao();
		this.label = indicadoresDet.getIndicadorMstr().getTipoIndicador();
		this.valor = indicadoresDet.getValor().doubleValue();
	}

	public IndicadorDetModel(Integer ano, String regiao, Double valor, String label) {
		this.ano = ano;
		this.regiao = regiao;
		this.valor = valor;
		this.label = label;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@JsonAnyGetter
	public Map<String, Double> any() {
		Map<String, Double> map = new HashMap<>();
		map.put(label, valor);
		return map;
	}

	@Override
	public String toString() {
		return "IndicadorDetModel{" +
				"ano=" + ano +
				", regiao='" + regiao + '\'' +
				", label='" + label + '\'' +
				", valor=" + valor +
				'}';
	}
}
