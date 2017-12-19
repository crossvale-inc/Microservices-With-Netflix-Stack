package hystrix.scheduling.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

	@RequestMapping(value = "/sendMessage/", method = RequestMethod.POST)
    public String returnMessage(@RequestBody Message message) {
      
		String returnMessageString = "";
		
       	String tp = TimePeriod.timePeriod();
    	
    	if( message.getTimeFrame().equals(tp) || message.getTimeFrame().equals("anytime") ) {    		
    		message.setIsSent(true);
    		returnMessageString = "Message Sent";
    	}
    	else {
    		returnMessageString = "Message Stored for Later Send";
    	}
    	return returnMessageString;
    }	
}
