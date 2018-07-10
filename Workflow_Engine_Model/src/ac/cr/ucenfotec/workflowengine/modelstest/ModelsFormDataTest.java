package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.form.FormData;

public class ModelsFormDataTest {

	FormData formDataI = new FormData();
	FormData formDataII = new FormData();
	
	@Test
	public void testFormDataEqualsTrue() {
		
		formDataI.setId(1);
		formDataII.setId(1);
		
		//Same Id value should always be true
		assertTrue(formDataI.equals(formDataII));
	}

	@Test
	public void testFormDataEqualsFalse() {

		formDataI.setId(1);
		formDataII.setId(2);
		
		//Different values should be false
		assertFalse(formDataI.equals(formDataII));
		
	}

}
