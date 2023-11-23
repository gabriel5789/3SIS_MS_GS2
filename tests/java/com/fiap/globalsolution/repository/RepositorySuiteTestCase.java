package com.fiap.globalsolution.repository;

import com.fiap.globalsolution.entity.IndicadoresDet;
import com.fiap.globalsolution.entity.IndicadoresMstr;
import com.fiap.globalsolution.entity.Objetivos;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class RepositorySuiteTestCase {
	@Nested
	@SpringBootTest
	@Order(1)
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class ObjetivosRepositorytest {
		@Autowired
		private ObjetivosRepository objetivosRepository;

		@Test
		@Order(1)
		void objetivosRepositorySaveTest() {
			objetivosRepository.save(
				new Objetivos(
						"3.1",
						"Até 2030, reduzir a taxa de mortalidade materna global para menos de 70 mortes por 100.000 nascidos vivos.",
						"Até 2030, reduzir a razão de mortalidade materna para no máximo 30 mortes por 100.000 nascidos vivos.",
						new LinkedList<>()
				)
			);
		}

	}

	@Nested
	@SpringBootTest
	@Order(2)
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class IndicadoresMstrRepositoryTest {
		@Autowired
		private IndicadoresMstrRepository indicadoresMstrRepository;

		@Autowired
		private ObjetivosRepository objetivosRepository;

		@Test
		@Order(1)
		void indicadoresMstrRepositorySaveTest() {
			indicadoresMstrRepository.save(
				new IndicadoresMstr(
						"3.1.1",
						"Razão de mortalidade materna",
						"Razão",
						objetivosRepository.getReferenceById("3.1")
				)
			);
		}
	}

	@Nested
	@SpringBootTest
	@Order(3)
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class IndicadoresDetRepositoryTest {
		@Autowired
		private IndicadoresDetRepository indicadoresDetRepository;

		@Autowired
		private IndicadoresMstrRepository indicadoresMstrRepository;

		@Test
		@Order(1)
		void indicadoresDetRepositorySaveTest() {
			indicadoresDetRepository.save(
					new IndicadoresDet(
							"3.1.1",
							2011,
							"Brasil",
							new BigDecimal("61.8"),
							indicadoresMstrRepository.getReferenceById("3.1.1")
					)
			);
		}

		@Test
		@Order(2)
		void indicadoresDetFindTest() {
			System.out.println(
				indicadoresDetRepository.findByIdIndicador("3.1.1").size()
			);
		}
	}

}
