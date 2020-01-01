package zhuowei.ppmtool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zhuowei.ppmtool.domain.Project;
import zhuowei.ppmtool.services.MapValidationErrorService;
import zhuowei.ppmtool.services.ProjectService;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    // route to post/create a new project
    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {
        // valid avoid server error
        // BindingResult result: an interface that invokes the validator on an object(determine whether an error)

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        //happy path
        Project project1 = projectService.saveOrUpdateProject(project);
         //object duplication error happens when persist the object to database
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId) {//identity projectId as the one in annotation

        Project project = projectService.findProjectByIdentifier(projectId.toUpperCase());

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects() {
        return projectService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId) {
        projectService.deleteProjectByIdentifier(projectId);
        return new ResponseEntity<String>("Project with Id: '" + projectId + "' was deleted", HttpStatus.OK);
    }


}
