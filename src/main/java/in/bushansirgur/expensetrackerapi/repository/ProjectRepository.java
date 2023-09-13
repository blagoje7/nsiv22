package in.bushansirgur.expensetrackerapi.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.expensetrackerapi.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	Page<Project> findByUserIdAndCategory(Long userId, String category, Pageable page);
	
	Page<Project> findByUserIdAndNameContaining(Long userId, String keyword, Pageable page);
	
	Page<Project> findByUserIdAndDateBetween(Long userId, Date startDate, Date endDate, Pageable page);
	
	Page<Project> findByUserId(Long userId, Pageable page);
	
	Optional<Project> findByUserIdAndId(Long userId, Long expenseId);

	
}
