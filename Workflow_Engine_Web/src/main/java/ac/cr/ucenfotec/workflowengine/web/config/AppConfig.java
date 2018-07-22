package ac.cr.ucenfotec.workflowengine.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
}
