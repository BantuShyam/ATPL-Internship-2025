package com.aaslin.springJdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aaslin.springJdbc.model.Student;


@Repository
public class StudentDAO {

	private final JdbcTemplate jdbcTemplate;
	public StudentDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	public int insertStudents(Student student) {
		String sql="insert into student (name,email,department) values(?,?,?)";
		return jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getDepartment());
	}
	
	public List<Student> getStudents() {
		String sql="select * from student";
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
	}
}
