package base.formatting.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RESTController {

    @RequestMapping(value = "/formatter/", method = RequestMethod.POST)
    public String returnMessage(@RequestBody Message message){
        message.convertBody();
        
        RestTemplate restTemplate = new RestTemplate();
        
		return restTemplate.postForObject("http://scheduling-service-test-microservices.apps.crossvale-ocp.com/sendMessage/", message, String.class);
    }
}
