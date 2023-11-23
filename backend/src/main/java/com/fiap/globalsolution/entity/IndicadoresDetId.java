package com.fiap.globalsolution.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;

public class IndicadoresDetId implements Serializable {
	private String idIndicador;

	private Integer ano;

	private String regiao;

	public IndicadoresDetId(String idIndicador, Integer ano, String regiao) {
		this.idIndicador = idIndicador;
		this.ano = ano;
		this.regiao = regiao;
	}

	public IndicadoresDetId() {
	}

	public String getIdIndicador() {
		return idIndicador;
	}

	public void setIdIndicador(String idIndicador) {
		this.idIndicador = idIndicador;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IndicadoresDetId that = (IndicadoresDetId) o;
		return Objects.equals(idIndicador, that.idIndicador) && Objects.equals(ano, that.ano) && Objects.equals(regiao, that.regiao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idIndicador, ano, regiao);
	}
}
