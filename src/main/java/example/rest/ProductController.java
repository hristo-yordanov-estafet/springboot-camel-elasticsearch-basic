package example.rest;

import javax.inject.Inject;

import org.apache.camel.CamelContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import example.model.Product;

@Controller
public class ProductController {
	@Inject CamelContext context;
	
	@RequestMapping(value="/v1/product", method=RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void putProduct(@RequestBody String payload) {
		System.out.println("***************** putProduct");
    	try {
    		context.createProducerTemplate().sendBody("direct:addProduct", new ObjectMapper().readValue(payload, Product.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	System.out.println("***************** END putProduct");
    }
	
	@RequestMapping(value="/v1/test", method=RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void getTest() {
		System.out.println("***************** test");
    }

}
