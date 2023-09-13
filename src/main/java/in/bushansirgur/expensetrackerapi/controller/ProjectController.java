package in.bushansirgur.expensetrackerapi.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.expensetrackerapi.entity.Project;
import in.bushansirgur.expensetrackerapi.service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/projects")
	public List<Project> getAllProjects(Pageable page) {
		return projectService.getAllProjects(page).toList();
	}
	
	@GetMapping("/projects/{id}")
	public Project getProjectById(@PathVariable Long id){
		return projectService.getProjectById(id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/projects")
	public void deleteProjectById(@RequestParam Long id) {
		projectService.deleteProjectById(id);
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/projects")
	public Project saveProjectDetails(@Valid @RequestBody Project project) {
		return projectService.saveProjectDetails(project);
	}
	
	@PutMapping("/projects/{id}")
	public Project updateProjectDetails(@RequestBody Project project, @PathVariable Long id){
		return projectService.updateProjectDetails(id, project);
	}
	
	@GetMapping("/projects/category")
	public List<Project> getProjectByCategory(@RequestParam String category, Pageable page) {
		return projectService.readByCategory(category, page);
	}
	
	@GetMapping("/projects/name")
	public List<Project> getProjectsByName(@RequestParam String keyword, Pageable page) {
		return projectService.readByName(keyword, page);
	}
	
	@GetMapping("/projects/date")
	public List<Project> getProjectsByDate(@RequestParam(required = false) Date startDate,
											@RequestParam(required = false) Date endDate,
											Pageable page) {
		return projectService.readByDate(startDate, endDate, page);
	}
}






















