package ac.cr.ucenfotec.workflowengine.modelstest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import ac.cr.ucenfotec.workflowengine.models.form.Form;
import ac.cr.ucenfotec.workflowengine.models.form.FormData;
import ac.cr.ucenfotec.workflowengine.models.form.FormElementListValue;
import ac.cr.ucenfotec.workflowengine.models.form.FormElementType;
import ac.cr.ucenfotec.workflowengine.models.workflow.AssigneeRecord;
import ac.cr.ucenfotec.workflowengine.models.workflow.Comment;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.Ticket;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.models.workflow.Workflow;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowState;
import ac.cr.ucenfotec.workflowengine.models.workflow.WorkflowStateRecord;

@RunWith(Parameterized.class)

public class ModelsEqualsTest {
	
	@Parameter
	public Object model;
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 
        		 {new AssigneeRecord()},
        		 {new Comment()},
        		 {new FormData()},
                 {new FormElementListValue()},
                 {new FormElementType()},
        		 {new Form()},
        		 {new FunctionalArea()},
        		 {new Ticket()},
                 {new User()},
                 {new Workflow()},
                 {new WorkflowState()},
                 {new WorkflowStateRecord()}
           });
    }
	
    
    @Test
    public void sameInstanceTest() {
    	assertTrue(model.equals(model));
    }
    
    @Test
    public void nullTest() {
    	assertFalse(model.equals(null));
    }
    
    @Test
    public void differentClassTest() {
    	assertFalse(model.equals(new Object()));
    }
}
