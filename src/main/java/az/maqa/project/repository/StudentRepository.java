package az.maqa.project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import az.maqa.project.entity.Student;
import az.maqa.project.entity.Teacher;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

	List<Student> findAllByActive(Integer active);

	Page<Student> findAllByTeacher(Teacher teacher, Pageable pageable);

}
