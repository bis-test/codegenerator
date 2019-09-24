package codemodules;

public class DataCode {


	public static String getDataStringDeclaration(String datafield)
	{
		String output="private String "+datafield+";";
		return output;
	}

	public static String getDataStringActual(String sheetName,String datafield, String fieldnm)
	{
		String output=datafield+"= dataTable.getData("+"\""+sheetName+"\""+","+"\""+fieldnm+"\""+");";
		return output;
	}

	public static String getDataCode(String datacode)
	{
		String str= "\nprivate void initializeData()"
				+"\n {"
				+"\n    try"
				+"\n    {"
				+         datacode
				+"\n      report.updateTestLog(pageName,"+"\""+"Data is loaded from data table successfully"+"\""+", Status.DONE);"
				+"\n    }"
				+"\n    catch(Exception e)"
				+"\n    {"
				+"\n       report.updateTestLog(pageName,"+"\""+"Error in reading data from data table: "+"\""+"+e.getMessage()"+",Status.FAIL);"
				+"\n    }"
				+"\n }";

		return str;

	}

}
