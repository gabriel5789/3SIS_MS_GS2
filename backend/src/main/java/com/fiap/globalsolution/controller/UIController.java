package com.fiap.globalsolution.controller;

import com.fiap.globalsolution.entity.IndicadoresMstr;
import com.fiap.globalsolution.model.IndicadorDetModel;
import com.fiap.globalsolution.model.IndicadorMstrModel;
import com.fiap.globalsolution.model.ObjetivosModel;
import com.fiap.globalsolution.repository.IndicadoresDetRepository;
import com.fiap.globalsolution.repository.IndicadoresMstrRepository;
import com.fiap.globalsolution.repository.ObjetivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/ui")
public class UIController {

	@Autowired
	private ObjetivosRepository objetivosRepository;

	@Autowired
	private IndicadoresMstrRepository indicadoresMstrRepository;

	@Autowired
	private IndicadoresDetRepository indicadoresDetRepository;

	@GetMapping("/objetivos")
	public ModelAndView getObjetivos() {
		ModelAndView modelAndView = new ModelAndView("objetivos");
		modelAndView.addObject(
				"objetivos",
				objetivosRepository.findAll().stream().map(ObjetivosModel::new).toList());
		return modelAndView;
	}

	@GetMapping("/indicador/{id}")
	public ModelAndView getIndicadorById(@PathVariable String id) {
		ModelAndView modelAndView = new ModelAndView("view-indicador");

		IndicadorMstrModel indicadorMstrModel = new IndicadorMstrModel(
				indicadoresMstrRepository.findById(id).orElse(new IndicadoresMstr()));

		List<IndicadorDetModel> indicadorDetList = indicadoresDetRepository.findByIdIndicador(id)
				.stream()
				.map(IndicadorDetModel::new)
				.toList();

		List<ArrayList<String>> rows = new LinkedList<ArrayList<String>>();

		List<Integer> anos = indicadorDetList
				.stream()
				.map(IndicadorDetModel::getAno)
				.distinct()
				.sorted()
				.toList();

		List<String> regioes = indicadorDetList
				.stream()
				.map(IndicadorDetModel::getRegiao)
				.distinct()
				.sorted()
				.toList();

		for (String regiao : regioes) {
			ArrayList<String> row = new ArrayList<>();
			row.add(regiao);
			for (Integer ano :
					anos) {
				row.add(indicadorDetList.stream()
						.filter(ind -> (Objects.equals(ind.getAno(), ano) && Objects.equals(ind.getRegiao(), regiao)))
						.toList()
						.get(0)
						.getValor()
						.toString());
			}
			rows.add(row);
		}


		modelAndView.addObject("anos", anos);
		modelAndView.addObject("rows", rows);
		modelAndView.addObject("indicador", indicadorMstrModel);

		return modelAndView;
	}
}
