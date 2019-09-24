package codemodules;



public class PageMethodCode {

	static String methodCode;

	public static String getPageMethodCode(String fieldType,String fieldName, String datafield, String uifield, String action)
	{

		switch(fieldType)
		{
		case "TextBox": methodCode= getTextBoxMethodCode(fieldName,datafield,uifield,action);break;
		case "DropDown": methodCode= getDropDownMethodCode(fieldName,datafield,uifield,action);break;
		//		case "CheckBox": methodCode= getCheckBoxMethodCode();break;
		//		case "RadioButton":methodCode= getRadioButtonMethodCode();break;
		//		case "Label":methodCode= getLabelMethodCode();break;
		case "Button":methodCode= getButtonMethodCode(fieldName,uifield,action);break;
		//		case "Table":methodCode= getTableMethodCode();break;
		//		case "Image":methodCode= getImageMethodCode();break;
		case "Link":methodCode= getLinkMethodCode(fieldName,uifield,action);break;
		//		case "Frame":methodCode= getFrameMethodCode();break;
		//		case "Tab":methodCode= getTabMethodCode();break;
		}

		return methodCode;
	}

	public static String getTextBoxMethodCode(String fieldName, String datafield, String uifield, String action)
	{
		String str=  "private void "+action+"()"
				+"\n{"
				+"\n  if(!"+datafield+".isEmpty() && elementReady("+uifield+",waitTime))"
				+"\n  {"
				+"\n    try"
				+"\n    {"
				+"\n      enterText("+uifield+","+datafield+");"
				+"\n      report.updateTestLog(pageName,"+"\""+fieldName+" value is entered: "+"\""+"+"+datafield+", Status.DONE);"
				+"\n     }"
				+"\n    catch(Exception e)"
				+"\n    {"
				+"\n       report.updateTestLog(pageName,"+"\""+fieldName+" value is not entered: "+"\""+"+e.getMessage()"+",Status.FAIL);"
				+"\n    }"
				+"\n  else"
				+"\n  {"
				+"\n    if(!"+datafield+".isEmpty())"
				+"\n    report.updateTestLog(pageName,"+"\""+fieldName+" Field is not displayed"+"\""+", Status.FAIL);"
				+"\n  }"
				+"\n}";

		return str;
	}


	public static String getDropDownMethodCode(String fieldName, String datafield, String uifield, String action)
	{
		String str=  "private void "+action+"()"
				+"\n{"
				+"\n  if(!"+datafield+".isEmpty() && elementReady("+uifield+",waitTime))"
				+"\n  {"
				+"\n    try"
				+"\n    {"
				+"\n      enterText("+uifield+","+datafield+");"
				+"\n      selectdropdownValue("+uifield+","+datafield+");"
				+"\n      report.updateTestLog(pageName,"+"\""+fieldName+" value is not selected: "+"\""+"+"+datafield+", Status.DONE);"
				+"\n     }"
				+"\n    catch(Exception e)"
				+"\n    {"
				+"\n       report.updateTestLog(pageName,"+"\""+fieldName+" value is not selected: "+"\""+"+e.getMessage()"+",Status.FAIL);"
				+"\n    }"
				+"\n  else"
				+"\n  {"
				+"\n    if(!"+datafield+".isEmpty())"
				+"\n    report.updateTestLog(pageName,"+"\""+fieldName+" Field is not displayed"+"\""+", Status.FAIL);"
				+"\n  }"
				+"\n}";

		return str;
	}


	public static String getButtonMethodCode(String fieldName, String uifield, String action)
	{
		String str=  "private void "+action+"()"
				+"\n{"
				+"\n  if(elementReady("+uifield+",waitTime))"
				+"\n  {"
				+"\n    try"
				+"\n    {"
				+"\n      btnclick("+uifield+");"
				+"\n      report.updateTestLog(pageName,"+"\""+fieldName+" element is clicked: "+"\""+", Status.DONE);"
				+"\n     }"
				+"\n    catch(Exception e)"
				+"\n    {"
				+"\n       report.updateTestLog(pageName,"+"\""+fieldName+" element is not clicked: "+"\""+"+e.getMessage()"+",Status.FAIL);"
				+"\n    }"
				+"\n  }"
				+"\n  else"
				+"\n  {"
				+"\n    report.updateTestLog(pageName,"+"\""+fieldName+" Field is not displayed"+"\""+", Status.FAIL);"
				+"\n  }"
				+"\n}";

		return str;
	}


	public String getValidateTitleMethodCode(String fieldName, String datafield, String uifield, String action)
	{
		String str=  "private void "+action+"()"
				+"\n{"
				+"\n  if(elementReady("+uifield+",waitTime))"
				+"\n      report.updateTestLog(pageName,"+"\""+fieldName+" is loaded successfully "+"\""+"+"+datafield+", Status.PASS);"
				+"\n  else"
				+"\n    report.updateTestLog(pageName,"+"\""+fieldName+" is not loaded"+"\""+", Status.FAIL);"
				+"\n}";

		return str;
	}


	public String getCheckBoxMethodCode()
	{
		return null;

	}

	public String getRadioButtonMethodCode()
	{
		return null;
	}

	public String getLabelMethodCode()
	{
		return null;
	}


	public String getTableMethodCode()
	{
		return null;
	}

	public String getImageMethodCode()
	{
		return null;
	}

	public static String getLinkMethodCode(String fieldName, String uifield, String action)
	{
		String str=  "private void "+action+"()"
				+"\n{"
				+"\n  if(elementReady("+uifield+",waitTime))"
				+"\n  {"
				+"\n    try"
				+"\n    {"
				+"\n      btnclick("+uifield+");"
				+"\n      report.updateTestLog(pageName,"+"\""+fieldName+" element is clicked: "+"\""+", Status.DONE);"
				+"\n     }"
				+"\n    catch(Exception e)"
				+"\n    {"
				+"\n       report.updateTestLog(pageName,"+"\""+fieldName+" element is not clicked: "+"\""+"+e.getMessage()"+",Status.FAIL);"
				+"\n    }"
				+"\n  }"
				+"\n  else"
				+"\n  {"
				+"\n    report.updateTestLog(pageName,"+"\""+fieldName+" Field is not displayed"+"\""+", Status.FAIL);"
				+"\n  }"
				+"\n}";

		return str;
	}

	public String getFrameMethodCode()
	{
		return null;
	}

	public String getTabMethodCode()
	{
		return null;
	}


}
