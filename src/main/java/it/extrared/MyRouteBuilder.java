package it.extrared;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

@ApplicationScoped
@ContextName("camel-cdi-context")
public class MyRouteBuilder extends RouteBuilder {

	// CDI dependency injection
	@Inject 
	@ContextName("camel-cdi-context")
	SomeProcessor someProcessor;
	
    @Override
    public void configure() throws Exception {
    	
    	from("timer:foo?repeatCount=1")
				.process(someProcessor)
				.to("direct:greeting-route")
				.log("${header.some-header}, ${body}")
    			.to("mock:end");

		//Example with properties placholder
		from("{{greeting.route}}")
				.setBody(constant("this is my first route!"));
    	
    }
}
