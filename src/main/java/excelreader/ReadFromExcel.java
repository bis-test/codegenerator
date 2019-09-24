package excelreader;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	static int rowCount;
	static int columnCount;
	
	public static Object[][] getSheet(String workBookName, String dataSheetName) 
	{		

		Object[][] data = null ;

		try 
		{			
			XSSFWorkbook workbook = new XSSFWorkbook("./data/"+workBookName+".xlsx");
			XSSFSheet sheet = workbook.getSheet(dataSheetName);

			// get the number of rows
			rowCount = sheet.getLastRowNum();

			// get the number of columns
			columnCount = sheet.getRow(0).getLastCellNum();

			data = new String[rowCount][columnCount];

			// loop through the rows
			for(int i=1; i <rowCount+1; i++)
			{
				try 
				{
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++)
					{ // loop through the columns
						try 
						{
							String cellValue = "";
							try
							{
								cellValue = row.getCell(j).getStringCellValue();
							}
							catch(Exception e)
							{
								System.out.println("Excel cell value is null: "+e.getMessage());
							}
							data[i-1][j]  = cellValue; // add to the data array
						} 
						catch (Exception e) 
						{
							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
			workbook.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occurred: "+e.getMessage());
		}

		return data;
	}
	
}


