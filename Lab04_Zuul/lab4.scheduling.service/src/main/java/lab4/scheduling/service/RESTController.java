package lab4.scheduling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {

	@Autowired
	private Environment env;
	
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
    	String path = env.getProperty("server.port");
    	returnMessageString = returnMessageString + " using Server Port=" + path;
    	
    	return returnMessageString;
    }	
}
