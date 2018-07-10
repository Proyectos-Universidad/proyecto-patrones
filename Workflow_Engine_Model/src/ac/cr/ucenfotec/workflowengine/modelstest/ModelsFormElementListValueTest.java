package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.form.FormElementListValue;

public class ModelsFormElementListValueTest {

	FormElementListValue formDataI = new FormElementListValue();
	FormElementListValue formDataII = new FormElementListValue();
	
	@Test
	public void testFormElementListValueEqualsTrue() {
		
		formDataI.setId(1);
		formDataII.setId(1);
		
		//Same Id value should always be true
		assertTrue(formDataI.equals(formDataII));
	}

	@Test
	public void testFormElementListValueEqualsFalse() {

		formDataI.setId(1);
		formDataII.setId(2);
		
		//Different values should be false
		assertFalse(formDataI.equals(formDataII));
		
	}

}
