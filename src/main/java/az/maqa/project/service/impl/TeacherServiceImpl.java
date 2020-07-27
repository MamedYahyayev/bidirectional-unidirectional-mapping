package az.maqa.project.service.impl;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List<TeacherDTO> getTeachers() {
		List<TeacherDTO> teacherDtoList = new ArrayList<>();

		ModelMapper mapper = new ModelMapper();

		List<Teacher> teachers = teacherRepository.findAllByActive(1);

		Type listType = new TypeToken<List<TeacherDTO>>() {
		}.getType();

		teacherDtoList = mapper.map(teachers, listType);

		return teacherDtoList;
	}

	private TeacherDTO toDto(Teacher teacher) {
		TeacherDTO teacherDto = new TeacherDTO();
		teacherDto.setId(teacher.getId());
		teacherDto.setName(teacher.getName());
		teacherDto.setSurname(teacher.getSurname());
		teacherDto.setAge(teacher.getAge());
		teacherDto.setTeachLesson(teacher.getTeachLesson());
		teacherDto.setDegree(teacher.getDegree());
		return teacherDto;
	}

	@Override
	public TeacherDTO getTeacherById(Long id) {
		TeacherDTO returnValue = new TeacherDTO();
		
		ModelMapper modelMapper  = new ModelMapper();
		
		Teacher teacher = teacherRepository.findById(id).get();
		
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
