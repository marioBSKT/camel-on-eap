package it.extrared;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.apache.camel.cdi.ContextName;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;

@ApplicationScoped
@ContextName("camel-cdi-context")
public class CustomCamelContext extends DefaultCamelContext {
	@Produces
	@Named("properties")
	@ApplicationScoped
	PropertiesComponent propertiesComponent() {
		PropertiesComponent pc = new PropertiesComponent();
		pc.setLocation("classpath:/myProperties.properties");
		return pc;
	}
	
}
