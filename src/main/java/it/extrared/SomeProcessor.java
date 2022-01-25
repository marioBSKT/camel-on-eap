package it.extrared;

import org.apache.camel.Exchange;
import org.apache.camel.cdi.ContextName;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ContextName("camel-cdi-context")
public class SomeProcessor implements org.apache.camel.Processor {
    
	@Override
	public void process(Exchange exchange) throws Exception {
        //Do whatever you want with the exchange
		exchange.getIn().setHeader("some-header", "Hello");
    }
}
