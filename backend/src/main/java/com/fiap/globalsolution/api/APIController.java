package com.fiap.globalsolution.api;

import com.fiap.globalsolution.entity.IndicadoresDet;
import com.fiap.globalsolution.model.IndicadorDetModel;
import com.fiap.globalsolution.model.ObjetivosModel;
import com.fiap.globalsolution.repository.IndicadoresDetRepository;
import com.fiap.globalsolution.repository.ObjetivosRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class APIController {
	@Autowired
	private ObjetivosRepository objetivosRepository;

	@Autowired
	private IndicadoresDetRepository indicadoresDetRepository;

	@GetMapping("/objetivos")
	public List<ObjetivosModel> getObjetivos() {
		return objetivosRepository.findAll()
				.stream()
				.map((ObjetivosModel::new))
				.toList();
	}

	@GetMapping("/indicador/{id}")
	public List<IndicadorDetModel> getIndicador(@PathVariable("id") String id) {
		return indicadoresDetRepository.findByIdIndicador(id)
				.stream()
				.map(IndicadorDetModel::new)
				.toList();
	}
}
