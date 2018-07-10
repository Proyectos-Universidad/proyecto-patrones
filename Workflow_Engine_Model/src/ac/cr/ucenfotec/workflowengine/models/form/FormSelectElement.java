package ac.cr.ucenfotec.workflowengine.models.form;

import java.util.List;

public class FormSelectElement extends FormElement{
	
	private List<FormElementListValue> options;

	public List<FormElementListValue> getOptions() {
		return options;
	}

	public void setOptions(List<FormElementListValue> options) {
		this.options = options;
	}
	
	
}
