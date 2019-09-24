package codemodules;

public class UICode {
	
	public static String getUIfieldName(String fieldNm, String fieldType)
	{
		String output  = Character.toUpperCase(fieldNm.charAt(0)) + fieldNm.substring(1);
		output=output.replaceAll("\\s+","");

		switch(fieldType)
		{
		case "TextBox": output= "txt".concat(output);break;
		case "DropDown": output="drp".concat(output);break;
		case "CheckBox": output="chkbox".concat(output);break;
		case "RadioButton":output="radio".concat(output);break;
		case "Label":output="lbl".concat(output);break;
		case "Button":output="btn".concat(output);break;
		case "Table":output="tbl".concat(output);break;
		case "Image":output="img".concat(output);break;
		case "Link":output="lnk".concat(output);break;
		case "Frame":output="frm".concat(output);break;
		case "Tab":output="tab".concat(output);break;
		}
		
		return output;
	}
	

}
