package zhuowei.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zhuowei.ppmtool.domain.Backlog;
import zhuowei.ppmtool.domain.Project;
import zhuowei.ppmtool.domain.ProjectTask;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {// long:id{



}
