package lab5.scheduling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class RESTController {

	@Autowired
	private Environment env;
    
	@Value("${return-sent-message:Oops, that didnt work}")
	private String returnSentMessage;

	@Value("${return-stored-message:Oops, that didnt work}")
	private String returnStoredMessage;
	
	@Value("${my.secret.val:fixed it}")
	private String secretVal;
		
	@RequestMapping(value = "/sendMessage/", method = RequestMethod.POST)
    public String returnMessage(@RequestBody Message message) {
      
		String returnMessageString = "";
		
       	String tp = TimePeriod.timePeriod();
    	
    	if( message.getTimeFrame().equals(tp) || message.getTimeFrame().equals("anytime") ) {    		
    		message.setIsSent(true);
    		//returnMessageString = "Message Sent";
    		returnMessageString = this.returnSentMessage;
    	}
    	else {
    		//returnMessageString = "Message Stored for Later Send";
    		returnMessageString = this.returnStoredMessage;
    	}
    	//String path = env.getProperty("server.port");
    	returnMessageString = returnMessageString + " using Pod=" + env.getProperty("HOSTNAME");
    	
    	return returnMessageString;
    }	

	@RequestMapping(value = "/getSecretVal/", method = RequestMethod.GET)
    public String returnCrypto() {
		return this.secretVal;
	}
      	
}
