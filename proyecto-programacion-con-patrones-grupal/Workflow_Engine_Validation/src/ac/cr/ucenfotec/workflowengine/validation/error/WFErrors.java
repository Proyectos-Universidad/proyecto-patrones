package ac.cr.ucenfotec.workflowengine.validation.error;

import java.util.ArrayList;
import java.util.List;

public class WFErrors {
	
	private List<String> errors;
	private char del;
	
	public WFErrors() {
		errors = new ArrayList<String>();
		del = '\n';
	}
	
	public WFErrors(char del) {
		this();
		this.del = del;
	}
	
	public void addError(String error) {
		errors.add(error);
	}
	
	public String getMessage() {
		
		if(errors.isEmpty()) {
			return "Operation was completed sucessfully";
		}
		
		StringBuilder sb = new StringBuilder("Errors found:");
		
		for(String e : errors) {
			sb.append(e);
			sb.append(del);
		}
		
		return sb.toString();
	}
	
	public boolean hasErrors() {
		return !errors.isEmpty();
	}
	
}
