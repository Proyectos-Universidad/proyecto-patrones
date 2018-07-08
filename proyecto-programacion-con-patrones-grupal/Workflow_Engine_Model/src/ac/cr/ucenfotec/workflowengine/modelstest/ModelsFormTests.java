package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.form.Form;

public class ModelsFormTests {

	Form formI = new Form();
	Form formII = new Form();
	
	@Test
	public void testFormEqualsTrue() {
		
		formI.setId(1);
		formII.setId(1);
		
		//Same Id value should always be true
		assertEquals(true, formI.equals(formII));
		
	}

	@Test
	public void testFormEqualsFalse() {

		formI.setId(1);
		formII.setId(2);
		
		//Different values should be false
		assertEquals(false, formI.equals(formII));
		
	}

}
