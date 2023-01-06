package Dummy2;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.math.BigInteger;
import java.text.ParseException;
import com.ibm.icu.text.SimpleDateFormat;
import com.softwareag.util.IDataMap;
// --- <<IS-END-IMPORTS>> ---

public final class javaServices

{
	// ---( internal utility methods )---

	final static javaServices _instance = new javaServices();

	static javaServices _newInstance() { return new javaServices(); }

	static javaServices _cast(Object o) { return (javaServices)o; }

	// ---( server methods )---




	public static final void isInputANumber (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(isInputANumber)>> ---
		// @sigtype java 3.5
		// [i] field:0:required input
		// [o] field:0:required output
		IDataMap pipelineMap = new IDataMap(pipeline);
		String input = pipelineMap.getAsString("input"); 
		String output = "false";
		
		try {
			new BigInteger(input);
			output = "true";
		} catch (NumberFormatException nfe) {
			output = "false";
		}
		
		pipelineMap.put("output", output);
		// --- <<IS-END>> ---

                
	}



	public static final void isValidDateTimePattern (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(isValidDateTimePattern)>> ---
		// @sigtype java 3.5
		// [i] field:0:required pattern
		// [i] field:0:required dateTime
		// [o] field:0:required matches
		IDataMap pipelineMap = new IDataMap(pipeline);
		String datePattern = pipelineMap.getAsString("pattern");
		String dateTime = pipelineMap.getAsString("dateTime");
		
		String matches = "false";
		
		if (datePattern != null && !datePattern.trim().equals("") 
				&& dateTime != null && !dateTime.trim().equals("")) {
			
			SimpleDateFormat format = new SimpleDateFormat(datePattern);
			format.setLenient(false);
			
			try {
				format.parse(dateTime);
				matches = "true";
			} catch (ParseException pex) {
				matches = "false";
			}
		}
		pipelineMap.put("matches", matches);
		// --- <<IS-END>> ---

                
	}



	public static final void replaceAllFromString (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(replaceAllFromString)>> ---
		// @sigtype java 3.5
		// [i] field:0:required inputString
		// [i] field:0:required regex
		// [i] field:0:required stringToReplace
		// [o] field:0:required outputString
		IDataMap pipelineMap = new IDataMap(pipeline);
		String inputString = pipelineMap.getAsString("inputString");
		String regex = pipelineMap.getAsString("regex");
		String stringToReplace = pipelineMap.getAsString("stringToReplace");
		
		if (stringToReplace == null) {
			stringToReplace = "";
		}
		
		String outputString = null;
		
		if (inputString != null && !"".equals(inputString.trim()) && regex != null && !"".equals(regex.trim())) {
			outputString = inputString.replaceAll(regex, stringToReplace);
		}
		
		pipelineMap.put("outputString", outputString);
			
		// --- <<IS-END>> ---

                
	}
}

