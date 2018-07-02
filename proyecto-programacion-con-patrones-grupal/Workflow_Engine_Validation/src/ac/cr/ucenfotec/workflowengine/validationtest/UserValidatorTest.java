package ac.cr.ucenfotec.workflowengine.validationtest;

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
	public void emptyNameTest() {
		user.setName("");
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullLastNameTest() {
		user.setLastName(null);
		UserValidator.validate(errors, user);
		Assert.assertEquals(2,errors.getErrorCount());
	}
	
	@Test
	public void emptyFunctionalAreaListTest() {
		user.getAreas().clear();
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}
		
	@Test
	public void outOfBoundsNameTest() {
		user.setName(ValidationTestData.OUT_OF_BOUNDS_STRING);
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void outOfBoundsLastNameTest() {
		user.setLastName(ValidationTestData.OUT_OF_BOUNDS_STRING);
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void outOfBoundsEmailTest() {
		user.setEmail(ValidationTestData.OUT_OF_BOUNDS_STRING);
		UserValidator.validate(errors, user);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
}
