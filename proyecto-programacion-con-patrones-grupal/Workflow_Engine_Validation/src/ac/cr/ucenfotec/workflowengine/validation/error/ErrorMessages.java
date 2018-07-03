package ac.cr.ucenfotec.workflowengine.validation.error;

import ac.cr.ucenfotec.workflowengine.validation.ValUtil;

public enum ErrorMessages {
	
	
	EMPTY_FIELD("Empty field: "),
	OUT_OF_BOUNDS_FIELD(String.format(" Is out of bounds, max length is: %s",ValUtil.MAX_LENGTH));
	
    private final String message;

    private ErrorMessages(final String message) {
    	this.message = message;
    }
	
    public String getMessage() {
    	return message;
    }
}
