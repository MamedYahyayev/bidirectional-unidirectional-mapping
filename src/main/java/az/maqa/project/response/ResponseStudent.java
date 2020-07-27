package az.maqa.project.response;


import lombok.Data;

@Data
public class ResponseStudent {
	
	private Long id;
	private String name;
	private String surname;
	private int age;
	private int course;
	private double groupNumber;

}
