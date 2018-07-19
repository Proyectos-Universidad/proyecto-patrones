package ac.cr.ucenfotec.workflowengine.businesslogictest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.businesslogic.CommentService;
import ac.cr.ucenfotec.workflowengine.businesslogic.TicketService;
import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;
import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class CommentServiceTest {

	public static WFErrors errors;
	
	@Before
	public void cleanErrors() {
		errors = new WFErrors();
	}
	
	@Test
	public void createCommentTest() {
		CommentService commentService = new CommentService();
		TicketService ticketService = new TicketService();
		User user = new UserService().getAll().get(0);
		Ticket ticket = ticketService.get(ticketService.getAll().get(0));
		Comment comment = new Comment();
		
		comment.setAuthor(user);
		comment.setText("Test comment");
		comment.setTicket(ticket);
		
		ticket.getComments().add(comment);
		
		commentService.create(errors, comment);
		Assert.assertFalse(errors.hasErrors());
		
		
		//ticketService.up
	}

}
