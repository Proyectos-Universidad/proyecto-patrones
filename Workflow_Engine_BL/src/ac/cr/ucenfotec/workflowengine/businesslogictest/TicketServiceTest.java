package ac.cr.ucenfotec.workflowengine.businesslogictest;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.businesslogic.FunctionalAreaService;
import ac.cr.ucenfotec.workflowengine.businesslogic.TicketService;
import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowService;
import ac.cr.ucenfotec.workflowengine.businesslogic.WorkflowStateService;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class TicketServiceTest {

	public static WFErrors errors;
	
	@Before
	public void cleanErrors() {
		errors = new WFErrors();
	}
	
	@Test
	public void createTicketTest() {
		TicketService ticketService = new TicketService();
		Ticket ticket = new Ticket();
		
		ticket.setAuthor(new UserService().getAll().get(0));
		ticket.setWorkflow(new WorkflowService().getAll().get(0));
		ticket.setSummary("Test summary");
		ticket.setDescription("Test description");
		ticket.setStatus("Open");
		
		ticketService.create(errors, ticket);
		Assert.assertFalse(errors.hasErrors());
		ticket = ticketService.get(ticket);
		
		Assert.assertNotNull(ticket.getCreated());
		Assert.assertNotEquals(0, ticket.getProgress().size());
	}
	
	@Test
	public void nextStateTest() {
		TicketService ticketService = new TicketService();
		Ticket ticket = ticketService.get(ticketService.getAll().get(0));
		int wsrSize = ticket.getProgress().size();
		ticketService.nextState(errors, ticket);
		Assert.assertFalse(errors.hasErrors());
		ticket = ticketService.get(ticket);
		Assert.assertNotEquals(wsrSize,ticket.getProgress().size());
		
	}

}
