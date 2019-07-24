package mapperController;

import java.text.DecimalFormat;

public class mapper{
	
	//천단위 콤마 찍기
	public String intnumberChange(int number) {

		String transStr = String.format("%,d", number);
		//System.out.println(transStr);

	return transStr;
	}
	
	public String stringnumberChange(String number) {

		int convert = Integer.parseInt(number);
	    DecimalFormat df = new DecimalFormat("#,###");
	    
	    String formatNum=(String)df.format(convert);
	   // System.out.println(formatNum);
	    return formatNum;
	    
	}

} 