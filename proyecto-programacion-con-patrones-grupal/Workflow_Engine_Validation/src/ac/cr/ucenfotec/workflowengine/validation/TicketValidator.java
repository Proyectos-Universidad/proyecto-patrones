package ac.cr.ucenfotec.workflowengine.validation;

import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.validation.error.ErrorMessages;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class TicketValidator {
	public static void validate(WFErrors errors, Ticket ticket) {
		if(ValUtil.isNullOrBlank(ticket.getSummary())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Summary");
		}
		
		if(ValUtil.isNullOrBlank(ticket.getDescription())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Description");
		}
		
		if(!ValUtil.isOfValidLength(ticket.getDescription())) {
			errors.addError("Description" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		if(!ValUtil.isOfValidLength(ticket.getSummary())) {
			errors.addError("Summary" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
	}
}
