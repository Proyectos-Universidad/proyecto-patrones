package ac.cr.ucenfotec.workflowengine.businesslogictest;

import static org.junit.Assert.*;

import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.businesslogic.FunctionalAreaService;
import ac.cr.ucenfotec.workflowengine.businesslogic.UserService;
import ac.cr.ucenfotec.workflowengine.dao.HUtil;
import ac.cr.ucenfotec.workflowengine.models.workflow.FunctionalArea;
import ac.cr.ucenfotec.workflowengine.models.workflow.User;
import ac.cr.ucenfotec.workflowengine.validation.error.WFErrors;

public class UserServiceTest {

	@Test
	public void test() {
		HUtil.setConfigFilePath("hibernate_test.cfg.xml");
		UserService us = new UserService();
		
		FunctionalArea a = new FunctionalArea();
		a.setName("Test area");
		
		new FunctionalAreaService().create(new WFErrors(), a);
		
		User u = new User();
		u.setEmail("Test man");
		u.setLastName("Test man");
		u.setName("Test man");
		u.getAreas().add(a);
		WFErrors e = new WFErrors();
		us.create(e, u);
		System.out.println(e.getMessage());
		System.out.println(us.getAll().get(0).getName());
	}

}
