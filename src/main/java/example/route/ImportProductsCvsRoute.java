package example.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.springframework.stereotype.Component;

import example.model.Product;

@Component
public class ImportProductsCvsRoute extends RouteBuilder {
	
	@Override
    public void configure() throws Exception {
		System.out.println("***************** start ImportProductsCvsRoute");
        BindyCsvDataFormat csv = new BindyCsvDataFormat(Product.class);
        
        from("file://src/main/resources?fileName=products.csv&noop=true").id(("import-products-cvs-route"))
            //.onException(NoNodeAvailableException.class).maximumRedeliveries(2).to("direct://error").handled(true).end()
            .log(LoggingLevel.INFO, "Records received : ${body}")
            .unmarshal(csv)
            .split(body())
                .setHeader("id").simple("${body.id}")
                .to("direct:addProduct");
        System.out.println("***************** end ImportProductsCvsRoute");
//        from("direct://error")
//        .log("No node Elasticsearch server is available");

    }

}
