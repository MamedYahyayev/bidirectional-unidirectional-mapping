package az.maqa.project.dto;

import java.util.ArrayList;
import java.util.List;


import lombok.Data;

@Data
public class TeacherDTO {

	private Long id;

	private String name;

	private String surname;

	private int age;

	private String teachLesson;

	private String degree;

	private List<StudentDTO> students = new ArrayList<>();

	
	
	
}
