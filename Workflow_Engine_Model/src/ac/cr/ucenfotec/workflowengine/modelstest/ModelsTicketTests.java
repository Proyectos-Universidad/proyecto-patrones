package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;

public class ModelsTicketTests {

	Ticket ticketI = new Ticket();
	Ticket ticketII = new Ticket();
	
	@Test
	public void testTicketEqualsTrue() {
		
		ticketI.setId(1);
		ticketII.setId(1);
		
		//Same Id value should always be true
		assertEquals(true, ticketI.equals(ticketII));
		
	}

	@Test
	public void testTicketEqualsFalse() {

		ticketI.setId(1);
		ticketII.setId(2);
		
		//Different values should be false
		assertEquals(false, ticketI.equals(ticketII));		
	}

}
