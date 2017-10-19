package practice;
import java.util.regex.*;
public class Ragular {
	public static void main(String [] args){
		
		Pattern p = Pattern.compile("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d");
		Matcher m= p.matcher("206-693-0766");
		boolean b=m.matches();
		System.out.println(b);
		
		
	}
	
}
