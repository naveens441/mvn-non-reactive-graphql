package mvn.non.reactive.graphql.mvn.non.reactive.graphql.repository;

import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.SpeakerTalk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerTalkRepository extends CrudRepository<SpeakerTalk,Long> {
    List<SpeakerTalk> findAllBySpeakerId(Long speakerId);
    List<SpeakerTalk> findAllByTalkId(Long talkId);
}
