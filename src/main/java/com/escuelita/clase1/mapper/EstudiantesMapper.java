package com.escuelita.clase1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.escuelita.clase1.model.Estudiante;

@Mapper
public interface EstudiantesMapper {

	@Select("select rut, nombre, apellido, mail, c.ciudad from estudiantes e, ciudad c where e.id_ciudad = c.id")
	public List<Estudiante> getAllEstudiantes();
	
	
	@Select("select rut, nombre, apellido, mail, c.ciudad from estudiantes e, ciudad c "
			+ "where e.id_ciudad = c.id and rut = #{rut}")
	public Estudiante getEstudiante(long rut);
	
	@Insert("insert into estudiantes values (#{rut}, #{nombre}, #{apellido}, #{mail}, #{ciudad})")
	public void ingresarEstudiante(long rut, String nombre, String apellido, String mail, int ciudad);

	
}
