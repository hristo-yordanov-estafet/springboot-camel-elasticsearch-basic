package example.route;

import org.springframework.stereotype.Component;

import example.model.Batch;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;


@Component
public class LogRoute extends RouteBuilder {
	
	@Override
	 public void configure() throws Exception {
		from("direct:logRoute").id("logRoute").log(LoggingLevel.INFO, "executing logRoute... ${body}");

	 }

}
