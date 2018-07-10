package ac.cr.ucenfotec.workflowengine.validationtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.validation.CommentValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class CommentValidatorTest {

	public static Comment comment;
	public static WFErrors errors;
	
	@BeforeClass
	public static void init() {
		comment = new Comment();
	}
	
	@Before
	public void before() {
		comment.setAuthor(new User());
		comment.setTicket(new Ticket());
		comment.setText("stuff");
		errors = new WFErrors();
	}
	
	@Test
	public void validCommentTest() {
		CommentValidator.validate(errors, comment);
		Assert.assertEquals(0,errors.getErrorCount());
	}
	
	@Test
	public void emptyTextTest() {
		comment.setText("");
		CommentValidator.validate(errors, comment);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullTextTest() {
		comment.setText(null);
		CommentValidator.validate(errors, comment);
		Assert.assertEquals(2,errors.getErrorCount());
	}
	
	@Test
	public void outOfBoundsTextTest() {
		comment.setText(ValidationTestData.OUT_OF_BOUNDS_STRING);
		CommentValidator.validate(errors, comment);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullAuthorTest() {
		comment.setAuthor(null);
		CommentValidator.validate(errors, comment);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullTicketTest() {
		comment.setTicket(null);
		CommentValidator.validate(errors, comment);
		Assert.assertEquals(1,errors.getErrorCount());
	}
}
