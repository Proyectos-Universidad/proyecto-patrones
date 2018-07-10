package ac.cr.ucenfotec.workflowengine.validation;

import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.validation.error.ErrorMessages;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class FunctionalAreaValidator {
	
	public static void validate(WFErrors errors, FunctionalArea area) {
		
		if(ValUtil.isNullOrBlank(area.getName())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Name");
		}
		if(!ValUtil.isOfValidLength(area.getName())) {
			errors.addError("Name" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
	}
	
}
