package mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AttendeeTalk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long attendeeId;
    private Long talkId;
}
