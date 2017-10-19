package practice;

public class Pali {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isRotatePali(String s){
		return false;
	}
	public String getLargestPali(String s){
		if(s.length()<=1){
			return s;
		}
		String res="";
		for(int i=0;i<s.length();i++){
			for(int j=s.length();j>=i;j--){
				if(isPali(s.substring(i,j))){
					if(s.substring(i,j).length()>res.length()){
						res=s.substring(i,j);
					}
				}
			}
		}
		return res;
	}
	public boolean isPali(String s){
		if(s.length()<=1){
			return true;
		}
		int i=0;
		int j=s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}
		}
		return true;
	}

}
