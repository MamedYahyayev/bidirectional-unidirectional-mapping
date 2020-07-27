package az.maqa.project.service;

import java.util.List;

import az.maqa.project.dto.TeacherDTO;

public interface TeacherService {

	List<TeacherDTO> getTeachers(int page, int size);

	TeacherDTO getTeacherById(Long id, int page, int limit);

	TeacherDTO addTeacher(TeacherDTO teacherDTO);

}
