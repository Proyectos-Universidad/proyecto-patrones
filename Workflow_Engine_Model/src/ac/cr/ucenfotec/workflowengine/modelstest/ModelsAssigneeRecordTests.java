package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.AssigneeRecord;

public class ModelsAssigneeRecordTests {

	AssigneeRecord formDataI = new AssigneeRecord();
	AssigneeRecord formDataII = new AssigneeRecord();
	
	@Test
	public void testAssigneeRecordEqualsTrue() {
		
		formDataI.setId(1);
		formDataII.setId(1);
		
		//Same Id value should always be true
		assertTrue(formDataI.equals(formDataII));
	}

	@Test
	public void testAssigneeRecordEqualsFalse() {

		formDataI.setId(1);
		formDataII.setId(2);
		
		//Different values should be false
		assertFalse(formDataI.equals(formDataII));
		
	}

}
