package zhuowei.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zhuowei.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    Iterable<Project> findAll();
    Iterable<Project> findAllByProjectLeader(String username);

    Project findByProjectIdentifier(String projectId);
}
