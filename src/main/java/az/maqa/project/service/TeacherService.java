package az.maqa.project.service;


import java.util.List;

import az.maqa.project.dto.TeacherDTO;
import az.maqa.project.request.RequestTeacher;
import az.maqa.project.response.ResponseTeacher;

public interface TeacherService {

	List<TeacherDTO> getTeachers();
	
	TeacherDTO getTeacherById(Long id);

	TeacherDTO addTeacher(TeacherDTO teacherDTO);

}
