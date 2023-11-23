package com.fiap.globalsolution.repository;

import com.fiap.globalsolution.entity.IndicadoresDet;
import com.fiap.globalsolution.entity.IndicadoresDetId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndicadoresDetRepository extends JpaRepository<IndicadoresDet, IndicadoresDetId> {
	List<IndicadoresDet> findByIdIndicador(String idIndicador);
}
