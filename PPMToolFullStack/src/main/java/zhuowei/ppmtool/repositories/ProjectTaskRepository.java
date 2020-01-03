package zhuowei.ppmtool.repositories;

        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import zhuowei.ppmtool.domain.ProjectTask;

        import java.util.List;



@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {// long:id{

    Iterable<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

    ProjectTask findByProjectSequence(String sequence);
}