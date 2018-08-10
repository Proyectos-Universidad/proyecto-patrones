package ac.cr.ucenfotec.workflowengine.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowStateService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean
	public WorkflowService workflowService() {
		return new WorkflowService();
	}
	
	@Bean
	public WorkflowStateService workflowStateService() {
		return new WorkflowStateService();
	}
	
}
