package ac.cr.ucenfotec.workflowengine.validationtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.validation.TicketValidator;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class TicketValidatorTest {

	public static Ticket ticket;
	public static WFErrors errors;
	
	@BeforeClass
	public static void init() {
		ticket = new Ticket();
	}
	
	@Before
	public void before() {
		ticket.setSummary("New requesst");
		ticket.setDescription("Need some stuff to be done.");
		errors = new WFErrors();
	}
	
	@Test
	public void validTicketTest() {
		TicketValidator.validate(errors, ticket);
		Assert.assertEquals(0,errors.getErrorCount());
	}
	
	@Test
	public void emptySummaryTest() {
		ticket.setSummary("");
		TicketValidator.validate(errors, ticket);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	@Test
	public void nullDescriptionTest() {
		ticket.setDescription(null);
		TicketValidator.validate(errors, ticket);
		Assert.assertEquals(2,errors.getErrorCount());
	}
	
		
	@Test
	public void outOfBoundsSummaryTest() {
		ticket.setSummary(ValidationTestData.OUT_OF_BOUNDS_STRING);
		TicketValidator.validate(errors, ticket);
		Assert.assertEquals(1,errors.getErrorCount());
	}
	
	
	@Test
	public void outOfBoundsDescriptionTest() {
		ticket.setDescription(ValidationTestData.OUT_OF_BOUNDS_STRING);
		TicketValidator.validate(errors, ticket);
		Assert.assertEquals(1,errors.getErrorCount());
	}

}
