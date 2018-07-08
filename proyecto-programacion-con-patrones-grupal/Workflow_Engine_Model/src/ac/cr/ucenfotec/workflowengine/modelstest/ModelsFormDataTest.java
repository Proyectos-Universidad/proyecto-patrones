package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.form.FormData;

public class ModelsFormDataTest {

	FormData formI = new FormData();
	FormData formII = new FormData();
	
	@Test
	public void testFormDataEqualsTrue() {
		
		formI.setId(1);
		formII.setId(1);
		
		//Same Id value should always be true
		assertEquals(true, formI.equals(formII));
		
	}

	@Test
	public void testFormDataEqualsFalse() {

		formI.setId(1);
		formII.setId(2);
		
		//Different values should be false
		assertEquals(false, formI.equals(formII));
		
	}

}
