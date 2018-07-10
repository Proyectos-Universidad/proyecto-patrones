package ac.cr.ucenfotec.workflowengine.validation;

import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.validation.error.ErrorMessages;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class UserValidator {
	
	public static void validate(WFErrors errors, User user) {
		if(ValUtil.isNullOrBlank(user.getName())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Name");
		}
		
		if(ValUtil.isNullOrBlank(user.getLastName())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Last name");
		}
		
		if(ValUtil.isNullOrBlank(user.getEmail())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Email");
		}
		
		if(user.getAreas().isEmpty()) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Functional areas");
		}
		
		if(!ValUtil.isOfValidLength(user.getName())) {
			errors.addError("Name" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		if(!ValUtil.isOfValidLength(user.getLastName())) {
			errors.addError("Last name" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		if(!ValUtil.isOfValidLength(user.getEmail())) {
			errors.addError("Email" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
	}
	
}
