package mvn.non.reactive.graphql.mvn.non.reactive.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.Speaker;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.SpeakerInput;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.SpeakerService;

@RequiredArgsConstructor
public class Update implements GraphQLMutationResolver {
    private final SpeakerService speakerService;

    public Speaker addSpeaker(SpeakerInput speakerInput) {
        Speaker speaker=new Speaker();
        speaker.setName(speakerInput.getName());
        speaker.setTwitter(speakerInput.getTwitter());
        return speakerService.save(speaker);
    }
}
