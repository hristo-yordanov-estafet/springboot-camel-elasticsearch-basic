package example.route;

import org.springframework.stereotype.Component;

import example.model.Batch;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

@Component
public class SplitterRoute extends RouteBuilder {
	
	@Override
	 public void configure() throws Exception {
		
//		from("timer://timer1?period=5s").to("http://localhost:8080/v1/batches").log("executed... ${body}");
		from("direct:splitterRoute").to("http://localhost:8080/v1/batches").log("executed... ${body}");
		

//		
//		
//		from("direct:splitterRoute").id("splitterRoute").log("executing splitterRoute...");

		
		//restConfiguration().component("restlet").bindingMode(RestBindingMode.json);
		
		
	
	  
	  //from("timer://timer1?period=3s").to("rest:get:v1/batches/update").log("${body}");
	  //from("cxfrs://http://localhost:8080/v1/batches").log("${body}");
	  
	  //.to("log:demo");
//	  System.out.println("...............");
//	  //restConfiguration().host("localhost").port(8080);
//	  from("direct:splitterRoute").route("rest:get:v1/batches/update").log("-----------------");
	  
	  //from("direct:splitterRoute").

	 }

}
