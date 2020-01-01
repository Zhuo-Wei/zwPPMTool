package zhuowei.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zhuowei.ppmtool.domain.Backlog;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {// long:id
}
