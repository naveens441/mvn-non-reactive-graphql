package mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SpeakerTalk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long speakerId;
    private Long talkId;
}
