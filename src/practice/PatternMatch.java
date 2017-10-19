package practice;

public class PatternMatch {

	public static void main(String[] args) {
		
		PatternMatch p= new PatternMatch();
		
		String s="";
		String t="";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="";
		t="?";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="";
		t="*";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="a";
		t="?";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="a";
		t="*";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="a";
		t="a*";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="a";
		t="a?";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="ab";
		t="a?";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="ab";
		t="a*";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="ab";
		t="a*b";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="ab";
		t="a?b";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="ab??ef";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="ab??e";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="ab??*";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="ab??**";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="**";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="***";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="*?";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="???";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="??????";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="abcdef";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="abcdef";
		t="abceef";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
		
		s="a";
		t="b*";
		System.out.println("IS '"+s+"' and '"+t+"' match?-->"+p.isMatch(s, t));
	}
	public boolean isMatch(String s, String t){
		if(s==null&&t==null){
			return true;
		}
		if(s==null||t==null){
			return false;
		}
		int x=s.length();
		int y=t.length();
		boolean [][] matrix= new boolean[x+1][y+1];
		matrix[0][0]=true;
		for(int i=1;i<=y;i++){
			char c=t.charAt(i-1);
			if(c=='*'){
				matrix[0][i]=matrix[0][i-1];
			}
			else{
				matrix[0][i]=false;
			}
		}
		
		for(int i=1;i<=x;i++){
			for(int j=1;j<=y;j++){
				char ss=s.charAt(i-1);
				char tt=t.charAt(j-1);
				if(ss==tt||tt=='?'){
					matrix[i][j]=matrix[i-1][j-1];
					
				}
				
				else if(tt=='*'){
					matrix[i][j]=matrix[i-1][j]||matrix[i][j-1];
				}
				else{
					matrix[i][j]=false;
				}
			}
		}
		return matrix[x][y];
		
	}
	

}
