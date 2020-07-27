package az.maqa.project.controller;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import az.maqa.project.dto.TeacherDTO;
import az.maqa.project.request.RequestTeacher;
import az.maqa.project.response.ResponseStudent;
import az.maqa.project.response.ResponseTeacher;
import az.maqa.project.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private TeacherMapper mapper;

	@GetMapping
	public List<ResponseTeacher> getTeachers() {
		List<ResponseTeacher> response = new ArrayList<>();

		ModelMapper modelMapper = new ModelMapper();
		
		List<TeacherDTO> teachers = teacherService.getTeachers();

		Type listType = new TypeToken<List<ResponseTeacher>>() {
		}.getType();
		
		response = modelMapper.map(teachers, listType);
		
		return response;
	}

	@GetMapping(value = "/{id}")
	public ResponseTeacher getTeacherById(@PathVariable("id") Long id) {
		ResponseTeacher responseTeacher = new ResponseTeacher();
		
		ModelMapper mapper = new ModelMapper();

		TeacherDTO teacherDTO = teacherService.getTeacherById(id);

		responseTeacher = mapper.map(teacherDTO, ResponseTeacher.class);

		return responseTeacher;
	}

	@PostMapping
	public ResponseTeacher addTeacher(@RequestBody RequestTeacher requestTeacher) {
		ResponseTeacher response = new ResponseTeacher();

		ModelMapper modelMapper = new ModelMapper();

		TeacherDTO teacherDTO = modelMapper.map(requestTeacher, TeacherDTO.class);

		TeacherDTO createdTeacher = teacherService.addTeacher(teacherDTO);

		response = modelMapper.map(createdTeacher, ResponseTeacher.class);

		return response;
	}

}

@Component
class TeacherMapper {

	public ResponseTeacher mapToResponse(TeacherDTO teacher) {
		ResponseTeacher responseTeacher = new ResponseTeacher();
		responseTeacher.setId(teacher.getId());
		responseTeacher.setName(teacher.getName());
		responseTeacher.setSurname(teacher.getSurname());
		responseTeacher.setAge(teacher.getAge());
		responseTeacher.setTeachLesson(teacher.getTeachLesson());
		responseTeacher.setDegree(teacher.getDegree());
		return responseTeacher;
	}

}
