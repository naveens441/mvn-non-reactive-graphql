package mvn.non.reactive.graphql.mvn.non.reactive.graphql.repository;

import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends CrudRepository<Attendee, Long> {
}
