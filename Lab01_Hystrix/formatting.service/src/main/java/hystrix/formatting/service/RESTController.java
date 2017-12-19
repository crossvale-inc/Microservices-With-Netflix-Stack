package hystrix.formatting.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RESTController {

	@HystrixCommand(fallbackMethod = "defaultMessageResponse" )
    @RequestMapping(value = "/formatter/", method = RequestMethod.POST)
    public String returnMessage(@RequestBody Message message){
        message.convertBody();
        
        RestTemplate restTemplate = new RestTemplate();
        
		return restTemplate.postForObject("http://localhost:8080/sendMessage/", message, String.class);
    }
	
	public String defaultMessageResponse( Message message ) {
		return "Send of " + message.toString() + " to formatter did not work.";
	}
	
}
