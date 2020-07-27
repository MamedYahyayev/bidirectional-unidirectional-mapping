package az.maqa.project.request;

public class RequestStudent {

	private String name;

	private String surname;

	private int age;

	private int course;

	private double groupNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public double getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(double groupNumber) {
		this.groupNumber = groupNumber;
	}

}
