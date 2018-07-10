package ac.cr.ucenfotec.workflowengine.businesslogictest;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.businesslogic.FunctionalAreaService;
import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class UserServiceTest {

	public static UserService us;
	
	@BeforeClass
	public static void init() {
		us = new UserService();
	}
	
	@Test
	public void createUserTest() {
		FunctionalAreaService fas = new FunctionalAreaService();
		
		User user = new User();
		WFErrors errors = new WFErrors();

		user.setName("Bobby Jr");
		user.setLastName("Ray");
		user.setEmail("bobby.ray@aol.com");
		user.getAreas().add(fas.getAll().get(0));
		
		us.create(errors, user);
		
		Assert.assertNotNull(us.get(user));
	}
	
	@Test 
	public void getNonPersistedUserTest() {
		User user = new User();
		user.setId(-10);
		Assert.assertNull(us.get(user));
	}
}
