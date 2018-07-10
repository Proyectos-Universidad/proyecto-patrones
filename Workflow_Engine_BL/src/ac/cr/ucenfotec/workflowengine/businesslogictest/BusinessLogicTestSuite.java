package ac.cr.ucenfotec.workflowengine.businesslogictest;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ac.cr.ucenfotec.workflowengine.dao.HUtil;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	FunctionalAreaServiceTest.class,
	UserServiceTest.class
})

public class BusinessLogicTestSuite {
    @BeforeClass
    public static void setUp() {
		HUtil.setConfigFilePath("hibernate_test.cfg.xml");
    }
}
