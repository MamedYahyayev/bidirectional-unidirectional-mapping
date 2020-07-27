package az.maqa.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import az.maqa.project.entity.Student;
import az.maqa.project.entity.Teacher;

public interface StudentRepository extends CrudRepository<Student, Long>{

	List<Student> findAllByActive(Integer active);
	
	List<Student> findAllByTeacher(Teacher teacher);
}
