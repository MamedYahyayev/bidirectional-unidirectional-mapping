package az.maqa.project.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.maqa.project.dto.StudentDTO;
import az.maqa.project.dto.TeacherDTO;
import az.maqa.project.entity.Student;
import az.maqa.project.response.ResponseStudent;
import az.maqa.project.response.ResponseTeacher;
import az.maqa.project.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<ResponseStudent> getAllUsers() {
		ModelMapper modelMapper = new ModelMapper();

		List<ResponseStudent> responseStudentList = new ArrayList<>();

		List<StudentDTO> studentDto = studentService.getAllStudents();

		Type listType = new TypeToken<List<ResponseStudent>>() {
		}.getType();

		responseStudentList = modelMapper.map(studentDto, listType);

		return responseStudentList;
	}

}
