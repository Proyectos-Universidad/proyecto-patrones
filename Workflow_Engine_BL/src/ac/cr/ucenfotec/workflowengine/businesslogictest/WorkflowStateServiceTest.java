package ac.cr.ucenfotec.workflowengine.businesslogictest;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.businesslogic.FunctionalAreaService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowStateService;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowStateServiceTest {

	public static WFErrors errors;
	
	@Before
	public void cleanErrors() {
		errors = new WFErrors();
	}
	
	@Test
	public void createWorkflowStateTest() {
		WorkflowStateService workflowStateService = new WorkflowStateService();
		WorkflowState workflowState = new WorkflowState();
		
		workflowState.setWorkflow(new WorkflowService().getAll().get(0));
		workflowState.setArea(new FunctionalAreaService().getAll().get(0));
		workflowState.setName("Test state");
		workflowState.setDescription("Test description");
		workflowState.setNextStateMessage("Test next state message");
		
		workflowStateService.createOrUpdate(errors, Arrays.asList(new WorkflowState[]{workflowState}));
		Assert.assertFalse(errors.hasErrors());
		
		workflowState = workflowStateService.get(workflowState);
		Assert.assertNotNull(workflowState);
		Assert.assertNotNull(workflowState.getCreated());
		Assert.assertNotNull(workflowState.getLastModified());
	
	}
	
	@Test
	public void updateWorkflowStateTest() {
		WorkflowStateService workflowStateService = new WorkflowStateService();
		WorkflowState workflowState = workflowStateService.getAll().get(0);
		LocalDateTime lastModified;
		String newName = "New name", 
			   newDescription = "new Description", 
			   newNextStateMessage = "new Message";
		
		lastModified = workflowState.getLastModified();
		workflowState.setName(newName);
		workflowState.setDescription(newDescription);
		workflowState.setNextStateMessage(newNextStateMessage);
		
		workflowStateService.createOrUpdate(errors, Arrays.asList(new WorkflowState[]{workflowState}));
		Assert.assertFalse(errors.hasErrors());
		
		workflowState = workflowStateService.get(workflowState);
		Assert.assertNotNull(workflowState);
		Assert.assertNotEquals(lastModified, workflowState.getLastModified());
		Assert.assertEquals(newName, workflowState.getName());
		Assert.assertEquals(newDescription, workflowState.getDescription());
		Assert.assertEquals(newNextStateMessage, workflowState.getNextStateMessage());
	
	}

}
