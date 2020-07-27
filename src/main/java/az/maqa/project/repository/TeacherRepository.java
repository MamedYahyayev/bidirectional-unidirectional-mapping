package az.maqa.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import az.maqa.project.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

	List<Teacher> findAllByActive(Integer active);
	
}
