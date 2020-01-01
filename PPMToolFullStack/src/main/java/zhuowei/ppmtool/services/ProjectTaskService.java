package zhuowei.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhuowei.ppmtool.domain.Backlog;
import zhuowei.ppmtool.domain.ProjectTask;
import zhuowei.ppmtool.repositories.BacklogRepository;
import zhuowei.ppmtool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        //exception: Project not found
        //PTs to be added to a specific project, project != null => backlog exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the backlog to pt
        projectTask.setBacklog(backlog);
        //we want out project sequence to be like : IDPRO-1, IDPRO-2, IDPRO-3. delete 2, the new next still 3
        // => PTSequence
        Integer BacklogSequence = backlog.getPTSequence();
        //update the backlog sequence
        BacklogSequence++;
        backlog.setPTSequence(BacklogSequence);
        //add sequence to project task
        projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
        projectTask.setGetProjectIdentifier(projectIdentifier);
        //INITIAL priority when priority null
        if ( projectTask.getPriority() == null) {// in future , projectTask.getPriority() == 0 to handle form
            projectTask.setPriority(3); //you don't care => lowest priority
        }
        //INITIAL status when status is null
        if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }

}
