package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.models.workflow.AssigneeRecord;
import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;

public class ModelsCommentTest {

	Comment commentI = new Comment();
	Comment commentII = new Comment();
	
	@Test
	public void testAssigneeRecordEqualsTrue() {
		
		commentI.setId(1);
		commentII.setId(1);
		
		//Same Id value should always be true
		assertTrue(commentI.equals(commentII));
	}

	@Test
	public void testAssigneeRecordEqualsFalse() {

		commentI.setId(1);
		commentII.setId(2);
		
		//Different values should be false
		assertFalse(commentI.equals(commentII));
		
	}

}
