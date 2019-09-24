package codemodules;

public class LocatorCode 
{
		
	public static String getLocatorData(String uifield)
	{
		String output="private final By "+uifield+"= By.xpath("+"\""+"\""+");";
		return output;
	}

}
