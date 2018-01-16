package example.route;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.RouteNode;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.management.InstrumentationProcessor;
import org.apache.camel.processor.interceptor.Tracer;
import org.apache.camel.spi.TracedRouteNodes;
import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import example.model.Product;

@Component
public class ImportProductsCvsRoute extends RouteBuilder {
	
	@Autowired
	CamelContext camelContext;
	
	@Override
    public void configure() throws Exception {

		getContext().setTracing(true);

        
        BindyCsvDataFormat csv = new BindyCsvDataFormat(Product.class);
        
        File directory = new File("./");
        System.out.println("PATH-------------------" + directory.getAbsolutePath());
        
        File f = new File("/deployments/src/main/resources/products.csv");
        if(f.exists() && !f.isDirectory()) { 
        	System.out.println("***************** file exists");
        } else {
        	System.out.println("***************** file not exists");
        }
        
        from("file:///deployments/src/main/resources/?fileName=products.csv&noop=true").id(("import-products-cvs-route"))
            //.onException(NoNodeAvailableException.class).maximumRedeliveries(2).to("direct://error").handled(true).end()
            //.onException(Exception.class).log("************************************************************fole exception").end()
            .log("Records received : ${body}")
            .unmarshal(csv)
            .split(body())
                .setHeader("id").simple("${body.id}")
                .to("direct:addProduct");
        System.out.println("***************** end ImportProductsCvsRoute");
//        from("direct://error")
//        .log("No node Elasticsearch server is available");

    }
	


}
