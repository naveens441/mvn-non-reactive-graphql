package mvn.non.reactive.graphql.mvn.non.reactive.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.Speaker;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.Talk;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.SpeakerService;

import java.util.List;

@RequiredArgsConstructor
public class TalkResolver implements GraphQLResolver<Talk> {
    private final SpeakerService speakerService;
    public List<Speaker> speakers(Talk talk){
        return  speakerService.findAllSpeakersForTalk(talk);
    }

}
