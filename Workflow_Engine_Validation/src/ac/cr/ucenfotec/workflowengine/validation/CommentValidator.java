package ac.cr.ucenfotec.workflowengine.validation;

import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;
import ac.cr.ucenfotec.workflowengine.validation.error.ErrorMessages;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class CommentValidator {
	public static void validate(WFErrors errors, Comment comment) {
		
		if(ValUtil.isNullOrBlank(comment.getText())) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Text");
		}
		if(!ValUtil.isOfValidLength(comment.getText())) {
			errors.addError("Text" + ErrorMessages.OUT_OF_BOUNDS_FIELD.getMessage());
		}
		
		//TODO
		//Uncomment when the author stuff is implemented
		/*if(comment.getAuthor() == null) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Author");
		}*/
		
		if(comment.getTicket() == null) {
			errors.addError(ErrorMessages.EMPTY_FIELD.getMessage() + "Ticket");
		}
	}
	
}
