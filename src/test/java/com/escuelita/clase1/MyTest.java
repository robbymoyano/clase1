package com.escuelita.clase1;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.escuelita.clase1.mapper.EstudiantesMapper;
import com.escuelita.clase1.model.Estudiante;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

	@Autowired
	EstudiantesMapper mapper;
	
	private final Logger log = LoggerFactory.getLogger(MyTest.class);

	@Test
	public void testEstudiantes() {
		List<Estudiante> estudiantes = mapper.getAllEstudiantes();
		
		for(Estudiante e: estudiantes) {
			log.info(e.toString());
		}
		
	}
	
	
}
