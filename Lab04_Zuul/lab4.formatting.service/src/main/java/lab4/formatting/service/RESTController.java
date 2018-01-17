package lab4.formatting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RibbonClient(name="schedule-service", configuration=RibbonConfiguration.class)
public class RESTController {

	
    @LoadBalanced
    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
 
    @Autowired
    RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	//@HystrixCommand(fallbackMethod = "defaultMessageResponse" )
    @RequestMapping(value = "/formatter/", method = RequestMethod.POST)
    public String returnMessage(@RequestBody Message message){
        message.convertBody();
        /*
        ServiceInstance serviceInstance=loadBalancer.choose("spring-cloud-mongodb-service");
		
		String baseUrl=serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/sendMessage/";
	
		return restTemplate2.postForObject(baseUrl, message, String.class);
        */
        return restTemplate.postForObject("http://scheduling-service/sendMessage/", message, String.class);

    }
	
	public String defaultMessageResponse( Message message ) {
		return "Send of " + message.toString() + " to formatter did not work.";
	}
	
}
