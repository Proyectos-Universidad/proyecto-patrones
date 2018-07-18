package ac.cr.ucenfotec.workflowengine.businesslogictest;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowService;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowServiceTest {

	public static WFErrors errors;
	
	@Before
	public void cleanErrors() {
		errors = new WFErrors();
	}
	
	@Test
	public void createWorkflowTest() {
		Workflow workflow = new Workflow();
		WorkflowService workflowService = new WorkflowService();

		workflow.setName("Loan request");
		workflow.setDescription("This is the workflow for a loan request");
		workflow.setIdPrefix("LOAN");

		workflowService.create(errors, workflow);
		Assert.assertNotNull(workflow.getCreated());
		Assert.assertNotNull(workflow.getLastModified());
		Assert.assertFalse(errors.hasErrors());
		Assert.assertNotNull(workflowService.get(workflow));
	}
	
	@Test
	public void updateWorkflowTest() {
		WorkflowService workflowService = new WorkflowService();
		Workflow workflow = workflowService.getAll().get(0);
		String newName = "New name";
		String newDescription = "New description";
		String newIdPrefix = "NEW-PREFIX";
		LocalDateTime lastModified;
		
		lastModified = workflow.getLastModified();
		workflow.setName(newName);
		workflow.setDescription(newDescription);
		workflow.setIdPrefix(newIdPrefix);

		workflowService.update(errors, workflow);
		workflow = workflowService.get(workflow);
		
		Assert.assertNotNull(workflowService.get(workflow));
		Assert.assertFalse(errors.hasErrors());
		Assert.assertNotEquals(lastModified, workflow.getLastModified());
		
	}

}
