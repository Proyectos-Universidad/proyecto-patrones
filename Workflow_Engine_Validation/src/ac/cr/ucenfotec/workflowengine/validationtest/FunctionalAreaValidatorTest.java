package ac.cr.ucenfotec.workflowengine.validationtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.validation.FunctionalAreaValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class FunctionalAreaValidatorTest {

	public static FunctionalArea area;
	public static WFErrors errors;
	
	@BeforeClass
	public static void init() {
		area = new FunctionalArea();
	}
	
	@Before
	public void before() {
		area.setName("Accounting");
		errors = new WFErrors();
	}
	
	@Test
	public void validAreaTest() {
		FunctionalAreaValidator.validate(errors, area);
		Assert.assertEquals(0,errors.getErrorCount());
	}
	
	@Test
	public void emptyNameTest() {
		area.setName("");
		FunctionalAreaValidator.validate(errors, area);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullNameTest() {
		area.setName(null);
		FunctionalAreaValidator.validate(errors, area);
		Assert.assertEquals(2,errors.getErrorCount());
	}
		
	@Test
	public void outOfBoundsNameTest() {
		area.setName(ValidationTestData.OUT_OF_BOUNDS_STRING);
		FunctionalAreaValidator.validate(errors, area);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	

}
