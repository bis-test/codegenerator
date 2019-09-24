package codemodules;

public class ActionCode{
	
	public static String getActionName(String fieldNm, String fieldType)
	{
		String output  = Character.toUpperCase(fieldNm.charAt(0)) + fieldNm.substring(1);
		output=output.replaceAll("\\s+","");

		switch(fieldType)
		{
		case "TextBox": output= "enter".concat(output);break;
		case "DropDown": output="select".concat(output);break;
		case "CheckBox": output="select".concat(output);break;
		case "RadioButton":output="select".concat(output);break;
		case "Label":output="click".concat(output);break;
		case "Button":output="click".concat(output);break;
		case "Table":output="click".concat(output);break;
		case "Image":output="click".concat(output);break;
		case "Link":output="click".concat(output);break;
		case "Frame":output="switchTo".concat(output);break;
		case "Tab":output="moveTo".concat(output);break;
		}
		
		return output;
	}

}
