package ac.cr.ucenfotec.workflowengine.validation;

import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.validation.error.ErrorMessages;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class WorkflowValidator {
	
	public static void validate(WFErrors errors, Workflow workflow) {
		if(ValUtil.isNullOrBlank(workflow.getName())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Name");
		}
		
		if(ValUtil.isNullOrBlank(workflow.getDescription())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Description");
		}
		
		if(ValUtil.isNullOrBlank(workflow.getIdPrefix())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Id prefix");
		}
		
		if(!ValUtil.isOfValidLength(workflow.getName())) {
			errors.addError("Name" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		if(!ValUtil.isOfValidLength(workflow.getDescription())) {
			errors.addError("Description" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		if(!ValUtil.isOfValidLength(workflow.getIdPrefix())) {
			errors.addError("Id prefix" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
	}
	
}
