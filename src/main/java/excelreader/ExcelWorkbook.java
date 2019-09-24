package excelreader;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWorkbook {
	
	public static List<String> getWorksheets(String workbookName)
	{
		List<String>sheetNames=new ArrayList<String>();
		try 
		{			
			XSSFWorkbook workbook = new XSSFWorkbook("./data/"+workbookName+".xlsx");
			int numberOfSheets = workbook.getNumberOfSheets();
			System.out.println(numberOfSheets);
			
			for(int i=0;i<numberOfSheets;i++)
			{
				sheetNames.add(workbook.getSheetName(i));
			}
			
			workbook.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred: "+e.getMessage());
		}
		
		return sheetNames;
	}
	
//	public static void main(String[] args)
//	{
//		List<String> worksheets = ExcelWorkbook.getWorksheets("FieldInventory");
//		System.out.println(worksheets.get(0));
//		System.out.println(worksheets.get(1));
//	}

}
