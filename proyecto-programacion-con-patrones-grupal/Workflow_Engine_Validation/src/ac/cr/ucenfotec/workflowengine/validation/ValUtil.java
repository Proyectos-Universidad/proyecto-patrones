package ac.cr.ucenfotec.workflowengine.validation;

public class ValUtil {
	public static boolean isNullOrBlank(String param) { 
	    return param == null || param.trim().length() == 0;
	}
}
