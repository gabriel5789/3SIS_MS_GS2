package com.fiap.globalsolution.model;

public class ObjetivosListModel {
	private String global;
	private String brasil;

	public ObjetivosListModel() {
	}

	public ObjetivosListModel(String global, String brasil) {
		this.global = global;
		this.brasil = brasil;
	}

	public String getGlobal() {
		return global;
	}

	public void setGlobal(String global) {
		this.global = global;
	}

	public String getBrasil() {
		return brasil;
	}

	public void setBrasil(String brasil) {
		this.brasil = brasil;
	}
}
