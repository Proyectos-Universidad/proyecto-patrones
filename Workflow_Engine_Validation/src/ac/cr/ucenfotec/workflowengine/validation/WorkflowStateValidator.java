package ac.cr.ucenfotec.workflowengine.validation;

import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.validation.error.ErrorMessages;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowStateValidator {
	public static void validate(WFErrors errors, WorkflowState workflowState) {
		if(ValUtil.isNullOrBlank(workflowState.getName())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Name");
		}
		
		if(ValUtil.isNullOrBlank(workflowState.getDescription())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Description");
		}
		
		if(ValUtil.isNullOrBlank(workflowState.getNextStateMessage())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Next state message");
		}
		
		if(workflowState.getArea() == null) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Functional area");
		}
		
		if(!ValUtil.isOfValidLength(workflowState.getName())) {
			errors.addError("Name" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		if(!ValUtil.isOfValidLength(workflowState.getDescription())) {
			errors.addError("Description" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		if(!ValUtil.isOfValidLength(workflowState.getNextStateMessage())) {
			errors.addError("Next state message" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
	}
}
