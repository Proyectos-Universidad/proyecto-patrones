package ac.cr.ucenfotec.workflowengine.validation;

public class ValUtil {
	
	public final static int MAX_LENGTH = 255;
	
	public static boolean isNullOrBlank(String param) { 
	    return param == null || param.trim().length() == 0;
	}
	
	public static boolean isOfValidLength(String param) { 
	    return isOfValidLength(param,MAX_LENGTH);
	}
	
	public static boolean isOfValidLength(String param,int length) { 
	    return param != null && param.length() <= length;
	}
}
