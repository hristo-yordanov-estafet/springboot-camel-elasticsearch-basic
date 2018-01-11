package example.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;
import org.apache.camel.component.elasticsearch.ElasticsearchConstants;

import example.model.Product;
import example.service.ElasticSearchService;

@Component
public class AddProductToElasticSearchRoute extends RouteBuilder {
	
	@Override
    public void configure() throws Exception {

        
//        from("direct:add").log("AddProductToElasticsearch : ${body.name}");
		
		JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(Product.class);
        final String ID = "id";
        System.out.println(ElasticsearchConstants.OPERATION_INDEX);

        from("direct:addProduct").id("add-product-route")
                .log(LoggingLevel.INFO,"Add new product...${body.id}  : ${body.name} ")
                .setHeader(ElasticsearchConstants.PARAM_INDEX_NAME).simple("platform")
                .setHeader(ElasticsearchConstants.PARAM_INDEX_TYPE).simple("product")
                .setHeader(ElasticsearchConstants.PARAM_OPERATION).constant(ElasticsearchConstants.OPERATION_INDEX)
                // Transform Java Blog Object to JSON String. IT will be used as Source Body content to insert the record in ElasticSearch
                .setHeader(ID).simple("${body.id}")
                .marshal(jacksonDataFormat)
                
                // Call the add service of the elasticsearchService POJO to generate the IndexRequest object
                //.bean(ElasticSearchService.class, "add")

                // Call the elasticsearch Service to add/insert an entry within the index
                //.to("elasticsearch://local")
                //.to("elasticsearch://cluster")
                //.to("jetty://http://localhost:9200")

                //.to("restlet:http://localhost:9200/platform/product/{id}?restletMethod=put")
                .to("restlet:http://elastisearch.vaosce.svc:9200/platform/product/{id}?restletMethod=put")
                .log("********************Response received");
        

    }

}
