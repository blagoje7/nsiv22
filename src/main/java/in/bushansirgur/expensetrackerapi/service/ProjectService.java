package in.bushansirgur.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import in.bushansirgur.expensetrackerapi.entity.Project;

public interface ProjectService {
	
	Page<Project> getAllProjects(Pageable page);

	Project getProjectById(Long id);

	void deleteProjectById(Long id);

	Project saveProjectDetails(Project project);
	
	Project updateProjectDetails(Long id, Project project);
	
	List<Project> readByCategory(String category, Pageable page);
	
	List<Project> readByName(String keyword, Pageable page);
	
	List<Project> readByDate(Date startDate, Date endDate, Pageable page);
}
