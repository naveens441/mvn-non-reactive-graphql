package mvn.non.reactive.graphql.mvn.non.reactive.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.*;
import java.util.List;

@Repository
public interface AttendeeTalkRepository extends CrudRepository<AttendeeTalk, Long> {
    List<AttendeeTalk> findAllByAttendeeId(Long attendeeId);

    List<AttendeeTalk> findAllByTalkId(Long talkId);
}
