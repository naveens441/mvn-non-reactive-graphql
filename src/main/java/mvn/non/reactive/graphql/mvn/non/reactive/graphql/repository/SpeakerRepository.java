package mvn.non.reactive.graphql.mvn.non.reactive.graphql.repository;

import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.Speaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends CrudRepository<Speaker,Long> {
}
