package com.fiap.globalsolution.model;

import com.fiap.globalsolution.entity.IndicadoresMstr;

public class IndicadorMstrModel {
	private String id;
	private String descricao;

	public IndicadorMstrModel() {
	}

	public IndicadorMstrModel(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public IndicadorMstrModel(IndicadoresMstr indicadoresMstr) {
		assert indicadoresMstr != null;
		this.id = indicadoresMstr.getIdIndicador();
		this.descricao = indicadoresMstr.getDescIndicador();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
