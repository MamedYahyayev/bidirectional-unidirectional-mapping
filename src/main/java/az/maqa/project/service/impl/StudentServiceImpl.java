package az.maqa.project.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import az.maqa.project.dto.StudentDTO;
import az.maqa.project.dto.TeacherDTO;
import az.maqa.project.entity.Student;
import az.maqa.project.entity.Teacher;
import az.maqa.project.repository.StudentRepository;
import az.maqa.project.response.ResponseStudent;
import az.maqa.project.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	

	@Override
	public List<StudentDTO> getAllStudents() {
		ModelMapper modelMapper = new ModelMapper();
		List<StudentDTO> studentDTOList = new ArrayList<>();

		List<Student> students = studentRepository.findAllByActive(1);

		Type listType = new TypeToken<List<StudentDTO>>() {
		}.getType();
		studentDTOList = modelMapper.map(students, listType);
		
		return studentDTOList;
	}

}
