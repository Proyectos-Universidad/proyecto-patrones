package ac.cr.ucenfotec.workflowengine.validationtest;

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
	
	@Test
	public void testValidLengthString() {
		Assert.assertTrue(ValUtil.isOfValidLength("Hello", 5));
	}
	
	@Test
	public void testUnderValidLengthString() {
		Assert.assertTrue(ValUtil.isOfValidLength("Hi", 5));
	}
	
	@Test
	public void testInvalidLengthString() {
		Assert.assertFalse(ValUtil.isOfValidLength("Sup?",2));
	}

}
