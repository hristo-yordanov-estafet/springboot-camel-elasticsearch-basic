package example.rest;

import org.apache.camel.CamelContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.inject.Inject;

@Controller
public class RestController {

	@Inject CamelContext context;

    @RequestMapping(value="/v1/batches/update") //method=RequestMethod.GET
    @ResponseStatus(value = HttpStatus.OK)
    public void update() {
    	try {
    		context.createProducerTemplate().sendBody("direct:splitterRoute", "invoke");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
