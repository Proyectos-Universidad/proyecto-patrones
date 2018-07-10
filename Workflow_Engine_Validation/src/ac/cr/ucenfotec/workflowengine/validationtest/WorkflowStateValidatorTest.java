package ac.cr.ucenfotec.workflowengine.validationtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.validation.WorkflowStateValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowStateValidatorTest {
	public static WorkflowState workflowState;
	public static WFErrors errors;
	
	@BeforeClass
	public static void init() {
		workflowState = new WorkflowState();
	}
	
	@Before
	public void before() {
		workflowState.setName("Accounting review");
		workflowState.setNextStateMessage("Done?");
		workflowState.setDescription("A accountant will review the request");
		workflowState.setArea(new FunctionalArea());
		errors = new WFErrors();
	}
	
	@Test
	public void validWorkflowStateTest() {
		WorkflowStateValidator.validate(errors, workflowState);
		Assert.assertEquals(0,errors.getErrorCount());
	}
	
	@Test
	public void emptyNameTest() {
		workflowState.setName("");
		WorkflowStateValidator.validate(errors, workflowState);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullNextStateMessageTest() {
		workflowState.setNextStateMessage(null);
		WorkflowStateValidator.validate(errors, workflowState);
		Assert.assertEquals(2,errors.getErrorCount());
	}
	
	@Test
	public void nullFunctionalAreaTest() {
		workflowState.setArea(null);
		WorkflowStateValidator.validate(errors, workflowState);
		Assert.assertEquals(1,errors.getErrorCount());
	}
		
	@Test
	public void outOfBoundsNameTest() {
		workflowState.setName(ValidationTestData.OUT_OF_BOUNDS_STRING);
		WorkflowStateValidator.validate(errors, workflowState);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void outOfBoundsNextStateMessageTest() {
		workflowState.setNextStateMessage(ValidationTestData.OUT_OF_BOUNDS_STRING);
		WorkflowStateValidator.validate(errors, workflowState);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void outOfBoundsDescriptionTest() {
		workflowState.setDescription(ValidationTestData.OUT_OF_BOUNDS_STRING);
		WorkflowStateValidator.validate(errors, workflowState);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
}
