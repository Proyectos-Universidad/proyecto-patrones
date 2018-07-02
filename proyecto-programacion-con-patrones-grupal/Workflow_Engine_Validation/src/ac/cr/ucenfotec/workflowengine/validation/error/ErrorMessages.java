package ac.cr.ucenfotec.workflowengine.validation.error;

public enum ErrorMessages {
	
	
	EMPTY_FIELD("Empty field: ");
	
    private final String message;

    private ErrorMessages(final String message) {
    	this.message = message;
    }
	
    public String getMessage() {
    	return message;
    }
}
