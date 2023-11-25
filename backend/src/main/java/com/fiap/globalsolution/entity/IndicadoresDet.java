package com.fiap.globalsolution.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "INDICADORES_DET")
@IdClass(IndicadoresDetId.class)
public class IndicadoresDet {
	@Id
	@Column(name = "id_indicador", length = 10)
	@JoinColumn(name = "id_indicador") 
	private String idIndicador;

	@Id
	@Column(name = "ano", precision = 4)
	private Integer ano;

	@Id
	@Column(name = "regiao", length = 60)
	private String regiao;

	@Column(name = "valor", precision = 6, scale = 2)
	private BigDecimal valor;

	@ManyToOne(targetEntity = IndicadoresMstr.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_indicador")
	private IndicadoresMstr indicadorMstr;

	public IndicadoresDet(String idIndicador, Integer ano, String regiao, BigDecimal valor, IndicadoresMstr indicadorMstr) {
		this.idIndicador = idIndicador;
		this.ano = ano;
		this.regiao = regiao;
		this.valor = valor;
		this.indicadorMstr = indicadorMstr;
	}

	public IndicadoresDet() {
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public IndicadoresMstr getIndicadorMstr() {
		return indicadorMstr;
	}

	public void setIndicadorMstr(IndicadoresMstr indicadorMstr) {
		this.indicadorMstr = indicadorMstr;
	}
}
