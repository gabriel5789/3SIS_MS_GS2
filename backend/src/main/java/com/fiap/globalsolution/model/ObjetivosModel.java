package com.fiap.globalsolution.model;


import com.fiap.globalsolution.entity.IndicadoresMstr;
import com.fiap.globalsolution.entity.Objetivos;

import java.util.LinkedList;
import java.util.List;

public class ObjetivosModel {
	private String id;
	private ObjetivosListModel objetivos;
	private List<IndicadorMstrModel> indicadores;

	public ObjetivosModel(Objetivos objetivosEntity) {
		assert objetivosEntity != null;
		this.id = objetivosEntity.getIdObjetivo();
		this.objetivos = new ObjetivosListModel();
		this.objetivos.setBrasil(objetivosEntity.getDescObjetivoBrasil());
		this.objetivos.setGlobal(objetivosEntity.getDescObjetivoGlobal());
		this.indicadores = new LinkedList<>();
		if (objetivosEntity.getIndicadoresMstr() != null) {
			for (IndicadoresMstr indicadoresMstr :
					objetivosEntity.getIndicadoresMstr()) {
				this.indicadores.add(new IndicadorMstrModel(
						indicadoresMstr.getIdIndicador(),
						indicadoresMstr.getDescIndicador()
				));
			}
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ObjetivosListModel getObjetivos() {
		return objetivos;
	}

	public void setObjetivos(ObjetivosListModel objetivos) {
		this.objetivos = objetivos;
	}

	public List<IndicadorMstrModel> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<IndicadorMstrModel> indicadores) {
		this.indicadores = indicadores;
	}
}
