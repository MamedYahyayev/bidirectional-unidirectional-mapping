package az.maqa.project.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDTO {

	private Long id;
	private String name;
	private String surname;
	private int age;
	private int course;
	private double groupNumber;
	private TeacherDTO teacher;

}
