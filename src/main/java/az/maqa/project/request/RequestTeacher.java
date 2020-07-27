package az.maqa.project.request;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RequestTeacher {

	private String name;

	private String surname;

	private int age;

	private String teachLesson;

	private String degree;

	private List<RequestStudent> students = new ArrayList<>();

}
