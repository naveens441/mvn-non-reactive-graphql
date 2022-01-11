package mvn.non.reactive.graphql.mvn.non.reactive.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.*;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.AttendeeService;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.SpeakerService;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.TalkService;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final AttendeeService attendeeService;
    private final SpeakerService speakerService;
    private final TalkService talkService;
    public List<Talk> allTalks() {
        return talkService.findAll();
    }

    public List<Speaker> allSpeakers() {
        return speakerService.findAll();
    }

    public List<Attendee> allAttendees() {
        return attendeeService.findAll();
    }

    public List<Object> allAll(){
        List list1=talkService.findAll();
        List list2=speakerService.findAll();
        list1.addAll(list2);
        return list1;
    }

}
