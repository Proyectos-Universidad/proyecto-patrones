package ac.cr.ucenfotec.workflowengine.validationtest;

import java.util.Arrays;

public final class ValidationTestData {
	
	public static final String OUT_OF_BOUNDS_STRING;
	
	static{
		char[] chars = new char[270];
		Arrays.fill(chars, '*');
		OUT_OF_BOUNDS_STRING = new String(chars);
	}
}
