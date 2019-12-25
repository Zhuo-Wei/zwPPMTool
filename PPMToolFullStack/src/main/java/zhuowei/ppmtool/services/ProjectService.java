package zhuowei.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhuowei.ppmtool.domain.Project;
import zhuowei.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        //logic

        return projectRepository.save(project);
    }
}
