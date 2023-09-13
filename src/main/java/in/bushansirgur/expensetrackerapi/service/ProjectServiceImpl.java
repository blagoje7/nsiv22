package in.bushansirgur.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.bushansirgur.expensetrackerapi.entity.Project;
import in.bushansirgur.expensetrackerapi.exceptions.ResourceNotFoundException;
import in.bushansirgur.expensetrackerapi.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Page<Project> getAllProjects(Pageable page) {
		return projectRepository.findByUserId(userService.getLoggedInUser().getId(), page);
	}

	@Override
	public Project getProjectById(Long id){
		Optional<Project> expense = projectRepository.findByUserIdAndId(userService.getLoggedInUser().getId(), id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Project is not found for the id "+id);
	}

	@Override
	public void deleteProjectById(Long id) {
		Project project = getProjectById(id);
		projectRepository.delete(project);
	}

	@Override
	public Project saveProjectDetails(Project project) {
		project.setUser(userService.getLoggedInUser());
		return projectRepository.save(project);
	}

	@Override
	public Project updateProjectDetails(Long id, Project project){
		Project existingProject = getProjectById(id);
		existingProject.setName(project.getName() != null ? project.getName() : existingProject.getName());
		existingProject.setDescription(project.getDescription() != null ? project.getDescription() : existingProject.getDescription());
		existingProject.setCategory(project.getCategory() != null ? project.getCategory() : existingProject.getCategory());
		existingProject.setDate(project.getDate() != null ? project.getDate() : existingProject.getDate());
		return projectRepository.save(existingProject);
	}

	@Override
	public List<Project> readByCategory(String category, Pageable page) {
		return projectRepository.findByUserIdAndCategory(userService.getLoggedInUser().getId(), category, page).toList();
	}

	@Override
	public List<Project> readByName(String keyword, Pageable page) {
		return projectRepository.findByUserIdAndNameContaining(userService.getLoggedInUser().getId(), keyword, page).toList();
	}

	@Override
	public List<Project> readByDate(Date startDate, Date endDate, Pageable page) {
		
		if (startDate == null) {
			startDate = new Date(0);
		}
		
		if (endDate == null) {
			endDate = new Date(System.currentTimeMillis());
		}
		
		return projectRepository.findByUserIdAndDateBetween(userService.getLoggedInUser().getId(), startDate, endDate, page).toList();
	}

}



























