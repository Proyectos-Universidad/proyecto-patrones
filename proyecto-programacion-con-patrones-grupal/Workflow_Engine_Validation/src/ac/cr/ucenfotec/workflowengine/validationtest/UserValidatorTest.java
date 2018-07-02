package ac.cr.ucenfotec.workflowengine.validationtest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.validation.UserValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

import org.junit.Assert;

public class UserValidatorTest {

	public static User user;
	public static WFErrors errors;
	
	@BeforeClass
	public static void init() {
		user = new User();
	}
	
	@Before
	public void before() {
		user.setName("Bobby");
		user.setLastName("Ray");
		user.setEmail("bobby.ray@aol.com");
		user.getAreas().add(new FunctionalArea());
		errors = new WFErrors();
	}
	
	@Test
	public void validUserTest() {
		UserValidator.validate(errors, user);
		Assert.assertEquals(0,errors.getErrorCount());
	}
	
	@Test
	public void emptyNameUserTest() {
		user.setName("");
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullLastNameUserTest() {
		user.setLastName(null);
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void emptyFunctionalAreaListUserTest() {
		user.getAreas().clear();
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}

}
