package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.form.Form;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;

public class ModelsFunctionalAreaTests {

	FunctionalArea areaI = new FunctionalArea();
	FunctionalArea areaII = new FunctionalArea();
	
	@Test
	public void testFormEqualsTrue() {
		
		areaI.setId(1);
		areaII.setId(1);
		
		//Same Id value should always be true
		assertEquals(true, areaI.equals(areaII));
		
	}

	@Test
	public void testFormEqualsFalse() {

		areaI.setId(1);
		areaII.setId(2);
		
		//Different values should be false
		assertEquals(false, areaI.equals(areaII));
		
	}

}
