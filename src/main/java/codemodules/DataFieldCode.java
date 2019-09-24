package codemodules;

public class DataFieldCode {
	
	public static String getDataFieldName(String fieldNm)
	{
		String output  = Character.toLowerCase(fieldNm.charAt(0)) + fieldNm.substring(1);
		output=output.replaceAll("\\s+","");
		
		return output;
	}

}
