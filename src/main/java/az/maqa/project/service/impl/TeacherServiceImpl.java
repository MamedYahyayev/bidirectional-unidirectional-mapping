package az.maqa.project.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import az.maqa.project.dto.StudentDTO;
import az.maqa.project.dto.TeacherDTO;
import az.maqa.project.entity.Student;
import az.maqa.project.entity.Teacher;
import az.maqa.project.repository.StudentRepository;
import az.maqa.project.repository.TeacherRepository;
import az.maqa.project.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<TeacherDTO> getTeachers(int page, int size) {
		List<TeacherDTO> teacherDtoList = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();

		if (page > 0)
			page = page - 1;

		Pageable pageable = PageRequest.of(page, size);

		Page<Teacher> teachersPage = teacherRepository.findAllByActive(pageable, 1);

		List<Teacher> teachers = teachersPage.getContent();

		Type listType = new TypeToken<List<TeacherDTO>>() {
		}.getType();

		teacherDtoList = mapper.map(teachers, listType);

		return teacherDtoList;
	}

	@Override
	public TeacherDTO getTeacherById(Long id, int page, int limit) {
		TeacherDTO returnValue = new TeacherDTO();
		ModelMapper modelMapper = new ModelMapper();

		Teacher teacher = teacherRepository.findById(id).get();

		if (page > 0)
			page = page - 1;

		Pageable pageable = PageRequest.of(page, limit);

		Page<Student> studentsPage = studentRepository.findAllByTeacher(teacher, pageable);

		List<Student> students = studentsPage.getContent();

		teacher.setStudents(students);

		returnValue = modelMapper.map(teacher, TeacherDTO.class);

		return returnValue;
	}

	@Override
	public TeacherDTO addTeacher(TeacherDTO teacherDTO) {
		TeacherDTO returnValue = new TeacherDTO();

		ModelMapper mapper = new ModelMapper();

		for (int i = 0; i < teacherDTO.getStudents().size(); i++) {

			StudentDTO studentDTO = teacherDTO.getStudents().get(i);

			studentDTO.setTeacher(teacherDTO);

			teacherDTO.getStudents().set(i, studentDTO);

		}

		Teacher teacher = mapper.map(teacherDTO, Teacher.class);

		Teacher savedTeacher = teacherRepository.save(teacher);

		returnValue = mapper.map(savedTeacher, TeacherDTO.class);

		return returnValue;

	}

}
