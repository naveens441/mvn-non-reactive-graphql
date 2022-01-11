package mvn.non.reactive.graphql.mvn.non.reactive.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.pojo.Talk;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.resolver.Query;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.resolver.TalkResolver;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.resolver.Update;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.AttendeeService;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.SpeakerService;
import mvn.non.reactive.graphql.mvn.non.reactive.graphql.service.TalkService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.w3c.dom.events.MutationEvent;

@SpringBootApplication
@EnableJpaRepositories(basePackages="mvn.non.reactive.graphql.mvn.non.reactive.graphql")
public class MvnNonReactiveGraphqlApplication {
	@Autowired
	SpeakerService speakerService;
	@Autowired
	AttendeeService attendeeService;
	@Autowired
	TalkService talkService;
    public static void main(String[] args) {
        SpringApplication.run(MvnNonReactiveGraphqlApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean graphQLServlet() {
		return new ServletRegistrationBean<>(
				SimpleGraphQLHttpServlet
						.newBuilder(buildSchema(speakerService,attendeeService,talkService))
						.build()
						,"/graphql");
    }
	private static GraphQLSchema buildSchema(
			SpeakerService speakerService,
			AttendeeService attendeeService,
			TalkService talkService){
		return SchemaParser
				.newParser()
				.file("graphql/schema.graphqls")
				.resolvers(new Query(attendeeService,speakerService, talkService)
				,new TalkResolver(speakerService)
				,new Update(speakerService))
				.build()
				.makeExecutableSchema();
	}
}
