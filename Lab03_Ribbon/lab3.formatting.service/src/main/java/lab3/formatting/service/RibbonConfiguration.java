package lab3.formatting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.ConfigurationBasedServerList;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;

public class RibbonConfiguration {

	  @Autowired
	  IClientConfig ribbonClientConfig;
	
	  @Bean
	  public IPing ribbonPing(IClientConfig config) {
	    return new PingUrl();
	  }
	
	  @Bean
	  public IRule ribbonRule(IClientConfig config) {
	    return new AvailabilityFilteringRule();
	  }
	  
    @Bean
    public ServerList<Server> ribbonServerList() {
        //return new ConfigurationBasedServerList(); 
        return new StaticServerList<>(new Server("localhost", 8080),
        							new Server("localhost", 8081),
        							new Server("localhost", 8082));
    }
}
