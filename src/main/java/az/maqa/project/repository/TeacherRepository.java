package az.maqa.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import az.maqa.project.entity.Teacher;

public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {

	Page<Teacher> findAllByActive(Pageable pageable,Integer active);
	
	
}
