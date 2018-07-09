package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;

public class ModelsWorkflowStateRecordTest {

	WorkflowStateRecord stateI = new WorkflowStateRecord();
	WorkflowStateRecord stateII = new WorkflowStateRecord();
	
	@Test
	public void testWorkflowStateRecordEqualsTrue() {
		
		stateI.setId(1);
		stateII.setId(1);
		
		//Same Id value should always be true
		assertTrue(stateI.equals(stateII));
	}

	@Test
	public void testWorkflowStateRecordEqualsFalse() {

		stateI.setId(1);
		stateII.setId(2);
		
		//Different values should be false
		assertFalse(stateI.equals(stateII));
		
	}

}
