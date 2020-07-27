package az.maqa.project.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseTeacher {

	private Long id;

	private String name;

	private String surname;

	private int age;

	private String teachLesson;

	private String degree;

	private List<ResponseStudent> students = new ArrayList<>();

	
	
	
}
