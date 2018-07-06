package ac.cr.ucenfotec.workflowengine.businesslogictest;

import org.junit.Assert;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.businesslogic.FunctionalAreaService;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class FunctionalAreaServiceTest {

	@Test
	public void createFunctionalAreaTest() {
		FunctionalAreaService fas = new FunctionalAreaService();
		FunctionalArea functionalArea = new FunctionalArea();

		WFErrors errors = new WFErrors();
		
		functionalArea.setName("Marketing");
		
		fas.create(errors, functionalArea);
		
		Assert.assertNotNull(fas.get(functionalArea));
	}

}
