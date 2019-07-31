package mapperController;

import java.text.DecimalFormat;

public class mapper{
	
	//천단위 콤마 찍기 int
	public String intnumberChange(int number) {

		String convert = String.format("%,d", number);
		//System.out.println(transStr);

	return convert;
	}
	
	//천단위 콤마 찍기 String
	public String stringnumberChange(String number) {

		int convert = Integer.parseInt(number);
	    DecimalFormat df = new DecimalFormat("#,###");
	    
	    String formatNum=(String)df.format(convert);
	   // System.out.println(formatNum);
	    return formatNum;
	    
	}
	
	public String Stringsum(String number) {
		int convert = Integer.parseInt(number); 
		String result = "";
		
		
		return result;
	}
	
	/*
	 * //콤바 뒤로 제거 public String removecoma(String number){
	 * 
	 * String convert = number;
	 * 
	 * int search = convert.indexOf("."); String trans = convert.substring(0,
	 * search);
	 * 
	 * 
	 * System.out.println("transNumber : "+trans);
	 * 
	 * return trans; }
	 */
} 