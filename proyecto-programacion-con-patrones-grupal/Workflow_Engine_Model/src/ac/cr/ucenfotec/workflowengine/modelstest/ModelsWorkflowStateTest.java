package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;

public class ModelsWorkflowStateTest {

	WorkflowState stateI = new WorkflowState();
	WorkflowState stateII = new WorkflowState();
	
	@Test
	public void testWorkflowStateEqualsTrue() {
		
		stateI.setId(1);
		stateII.setId(1);
		
		//Same Id value should always be true
		assertTrue(stateI.equals(stateII));
	}

	@Test
	public void testWorkflowStateEqualsFalse() {

		stateI.setId(1);
		stateII.setId(2);
		
		//Different values should be false
		assertFalse(stateI.equals(stateII));
		
	}

}
