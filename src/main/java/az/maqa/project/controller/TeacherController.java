package az.maqa.project.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import az.maqa.project.dto.TeacherDTO;
import az.maqa.project.request.RequestTeacher;
import az.maqa.project.response.ResponseTeacher;
import az.maqa.project.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<ResponseTeacher> getTeachers(@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "25") int size) {
		List<ResponseTeacher> response = new ArrayList<>();

		ModelMapper modelMapper = new ModelMapper();

		List<TeacherDTO> teachers = teacherService.getTeachers(page, size);

		Type listType = new TypeToken<List<ResponseTeacher>>() {
		}.getType();

		response = modelMapper.map(teachers, listType);

		return response;
	}

	@GetMapping(value = "/{id}/students", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseTeacher getTeacherById(@PathVariable("id") Long id,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit) {
		ResponseTeacher responseTeacher = new ResponseTeacher();

		ModelMapper mapper = new ModelMapper();

		TeacherDTO teacherDTO = teacherService.getTeacherById(id, page, limit);

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
