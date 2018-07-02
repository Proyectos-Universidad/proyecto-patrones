package ac.cr.ucenfotec.workflowengine.validationtest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ac.cr.ucenfotec.workflowengine.validation.ValUtil;

public class ValUtilTest {

	
	@Test
	public void testValidString() {
		Assert.assertFalse(ValUtil.isNullOrBlank("Valid String"));
	}
	
	@Test
	public void testEmptyString() {
		Assert.assertTrue(ValUtil.isNullOrBlank(""));
	}
	
	@Test
	public void testNullString() {
		Assert.assertTrue(ValUtil.isNullOrBlank(null));
	}
	
	@Test
	public void testBlankString() {
		Assert.assertTrue(ValUtil.isNullOrBlank("       "));
	}

}
