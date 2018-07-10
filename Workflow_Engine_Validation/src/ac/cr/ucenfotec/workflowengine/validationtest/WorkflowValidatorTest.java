package ac.cr.ucenfotec.workflowengine.validationtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.validation.WorkflowValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowValidatorTest {

	public static Workflow workflow;
	public static WFErrors errors;
	
	@BeforeClass
	public static void init() {
		workflow = new Workflow();
	}
	
	@Before
	public void before() {
		workflow.setName("Test Workflow");
		workflow.setDescription("Test workflow description");
		workflow.setIdPrefix("TESTWF");
		errors = new WFErrors();
	}
	
	@Test
	public void validWorkflowTest() {
		WorkflowValidator.validate(errors, workflow);
		Assert.assertEquals(0,errors.getErrorCount());
	}
	
	@Test
	public void emptyNameTest() {
		workflow.setName("");
		WorkflowValidator.validate(errors, workflow);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullDescriptionTest() {
		workflow.setDescription(null);
		WorkflowValidator.validate(errors, workflow);
		Assert.assertEquals(2,errors.getErrorCount());
	}
			
	@Test
	public void outOfBoundsNameTest() {
		workflow.setName(ValidationTestData.OUT_OF_BOUNDS_STRING);
		WorkflowValidator.validate(errors, workflow);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void outOfBoundsDescriptionTest() {
		workflow.setDescription(ValidationTestData.OUT_OF_BOUNDS_STRING);
		WorkflowValidator.validate(errors, workflow);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void outOfBoundsIdPrefixTest() {
		workflow.setIdPrefix(ValidationTestData.OUT_OF_BOUNDS_STRING);
		WorkflowValidator.validate(errors, workflow);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
}
