package codegenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import org.testng.annotations.Test;

import codemodules.ActionCode;
import codemodules.DataCode;
import codemodules.DataFieldCode;
import codemodules.LocatorCode;
import codemodules.PageMethodCode;
import codemodules.UICode;
import excelreader.ExcelWorkbook;
import excelreader.ReadFromExcel;

public class CodeGenerator 
{
	Object[][] fieldval;
	String workbookName="FieldInventory";

	String fieldName;
	String fieldType;
	String uifieldName;
	String fielActiondName;
	String dataFieldName;
	String pageCode="";

	String locatorString="";
	String dataDeclString="";
	String dataString="";

	String str="";
	String dataFlag;
	boolean pageCodehasData=false;
	String dataCode="";

	
	public void generateCode(String worksheetName)
	{
		fieldval=ReadFromExcel.getSheet(workbookName, worksheetName);

		//Check the row count
		int row=fieldval.length;

		for(int i=0;i<row;i++)
		{
			fieldName=(String) fieldval[i][0];
			fieldType=(String) fieldval[i][1];
			dataFlag=(String) fieldval[i][2];

			uifieldName=UICode.getUIfieldName(fieldName, fieldType);
			dataFieldName=DataFieldCode.getDataFieldName(fieldName);
			fielActiondName=ActionCode.getActionName(fieldName, fieldType);

			str=PageMethodCode.getPageMethodCode(fieldType, fieldName, dataFieldName, uifieldName, fielActiondName);
			pageCode= pageCode.concat("\n").concat(str);

			str=LocatorCode.getLocatorData(uifieldName);
			locatorString= locatorString.concat("\n").concat(str);

			if(dataFlag.equals("Y"))
			{
				str=DataCode.getDataStringDeclaration(dataFieldName);
				dataDeclString= dataDeclString.concat("\n").concat(str);

				str=DataCode.getDataStringActual(worksheetName,dataFieldName, fieldName);
				dataString=dataString.concat("\n").concat("\t").concat(str);
				
				pageCodehasData=true;
			}	
		}
		
		if(pageCodehasData)
		dataCode=DataCode.getDataCode(dataString);	
	}
	
	
    public void saveCode(String worksheetName)
    {
		String filePath="./code/"+worksheetName+".txt";
		
		try
		{
			FileWriter writer = new FileWriter(filePath);
			BufferedWriter bw = new BufferedWriter(writer);
			
			
			//Write locator string to the file.
			locatorString=locatorString.replace("\n", System.getProperty("line.separator"));
			bw.write(locatorString);
			bw.append(System.getProperty("line.separator"));

			
			//Write data variable declaration to file
			dataDeclString=dataDeclString.replace("\n", System.getProperty("line.separator"));
			bw.write(dataDeclString);
			bw.append(System.getProperty("line.separator"));
			
			
			//Write data code to file
			dataCode=dataCode.replace("\n", System.getProperty("line.separator"));
			bw.write(dataCode);
			bw.append(System.getProperty("line.separator"));
			
			
			//Write the page code to file.
			pageCode=pageCode.replace("\n", System.getProperty("line.separator"));
			bw.append(pageCode);
			
            
			//close the file object
	    	bw.close();
	    	System.out.println("File Saved..");
		}
		catch(Exception e)
		{
			System.out.println("Error in writing to file: "+e.getMessage());
		}
		
    }
	
    @Test(enabled=false)
	public void displayData()
	{
		System.out.println(locatorString);
    	System.out.println(dataDeclString);
    	System.out.println(DataCode.getDataCode(dataString));
    	System.out.println(pageCode);
	}

    public void flushCode()
    {
    	fieldName="";
    	fieldType="";
    	uifieldName="";
    	fielActiondName="";
    	dataFieldName="";
    	pageCode="";

    	locatorString="";
    	dataDeclString="";
    	dataString="";

    	str="";
    	dataFlag="";
    	pageCodehasData=false;
    	dataCode="";
    }
    
    @Test
    public void generatePageCode()
    {
    	List<String> worksheets = ExcelWorkbook.getWorksheets(workbookName);
    	for(int i=0;i<worksheets.size();i++)
    	{
    		generateCode(worksheets.get(i));
    		saveCode(worksheets.get(i));
    		flushCode();	
    	}
		
    }

}
