package practice;

import java.util.HashSet;
import java.util.*;

public class test {

	public static void main(String[] args) throws InterruptedException {
		/*
		char a='Z';
		int i=0;
		while(i<26){
		char [] aa=Character.toChars(a-i);
		
		System.out.println(aa[0]);
		i++;
		}
		
		String st="1.23.33";
		String ss="2";
		String [] t=st.split("\\.");
		String [] s=ss.split("\\.");
		String dot=".";
		CharSequence c= dot.subSequence(0, 1);
		System.out.println(s[0]);
		System.out.println(st.contains(c));
		*/
		//test te=new test();
		//List list=te.getRow(1);
		//System.out.println(list);
		
	Integer a=5000000;
	System.out.println(a.byteValue());
	}
	 public int divide(int dividend, int divisor) {
	        if(divisor==0){
	            return Integer.MAX_VALUE;
	        }
	        if(divisor==1){
	            return dividend;
	        }
	        if(dividend==0){
	            return dividend;
	        }
	        /* 下面这个方法也能算出来，但是太慢了
	        boolean pos=(dividend>0&&divisor>0);
	        int count=0;
	        dividend=Math.abs(dividend);
	        divisor=Math.abs(divisor);
	        while(dividend>=divisor){
	            dividend-=divisor;
	            count++;
	            if(count==Integer.MAX_VALUE){
	                return Integer.MAX_VALUE;
	            }
	        }
	        if(pos)
	        return count;
	        else
	        return -count;
	        */
	        boolean pos=(dividend>0&&divisor>0);
	        int res=0;
	        int init=1;
	        
	        dividend=Math.abs(dividend);
	        divisor=Math.abs(divisor);
	        int divi=divisor;
	        //System.out.println(dividend);
	        while(dividend>=divisor){
	            int i=0;
	            while(dividend>=(divi<<1)&&divi>Integer.MAX_VALUE-2){
	                divi=(divi<<1);
	                i++;
	                
	            }
	            if(i>0){
	            dividend-=divi;
	            res+=(init<<i);
	            
	            }
	            
	            if(i==0){
	            dividend-=divisor;
	            res+=1;  
	            }
	          
	        }
	        if(pos)
	        return res;
	        else
	        return -res;
	    }
	public int countDigitOne(int n) {
        if(n<=0){
            return 0;
        }
        // 这个方法还是慢 慢 慢
        /*
        String st="";
        int res=0;
        for(int i=1;i<=n;i++){
          st=""+i;
          for(int k=0;k<st.length();k++){
              if(st.charAt(k)=='1'){
                  res++;
              }
          }
        }
        */
        //每循环一次就只计算这一位有多少1，对于每一位的前所有位，分为大于等于2，等于1，等于0
        /*
        int res=0;
        if(n<10){
            return 1;
        }
        int left=1;
        int right=1;
        int len=1;
        while(n>=len){
           left=n/len;
           right=n%len;
           if(left%10>=2){
               res+=(left/10+1)*len;
           }
           if(left%10==1){
               res+=(left/10)*len+right+1;
           }
           if(left%10==0){
               res+=(left/10)*len;
           }
           
           len=len*10; 
        }
        */
     
     int res=0;
     if(n<=9){
         return 1;
     }
     int i=9;
     while((i*10+9)<n){
         i=i*10+9;
     }
     //java.lang.StackOverflowError n大于1410065408的时候，不知道为什么,Eclipes 运行并没有错误,死循环本身是不会StackOverflow的，只有无限递归的时候会出现。原则上循环嵌套次数本身是没有限制的，限制的是占用的栈空间，如果你的函数里定义了很多很多变量，栈空间就会用完得比较快。
     int first=getFirst(n);
     if(first>=2){
         return first*get(i)+i+1+countDigitOne(n%(i+1));
     }
     if(first==1){
         return get(i)+n%(i+1)+1+countDigitOne(n%(i+1));
     }
     else{
         return countDigitOne(n%(i+1));
     }
    }
   public int get(int n){
       
        int i=9;
        int res=1;
        while(i<n){
          res=res*10+i+1;
          i=i*10+9;
        }
        
        
        return res;  
   }
   public int getFirst(int x){
	
	   if(x/100000000>0) x/=100000000;
	   if(x/10000>0) x/=10000;
	   if(x/100>0) x/=100;
	   if(x/10>0) x/=10;
	   return x; 
   }
	
	public int compareVersion(String version1, String version2) {
	      
	        String [] v1=version1.split("\\.");
	        String [] v2=version2.split("\\.");
	        System.out.println(v1[0]+v1[1]);
	        System.out.println(v2[0]+v2[1]);
	        int length=Math.min(v1.length,v2.length);
	        for(int i=0;i<length;i++){
	            if(Integer.parseInt(v1[i])>Integer.parseInt(v2[i])){
	                return 1;
	            }
	            if(Integer.parseInt(v1[i])<Integer.parseInt(v2[i])){
	                return -1;
	            }
	        }
	        
	        if(v1.length>v2.length){
	            return 1;
	        }
	        if(v1.length<v2.length){
	            return -1;
	        }
	        else{
	            return 0;
	        }
	    }
	
	 public List<Integer> getRow(int rowIndex) {
	        List<Integer> res= new LinkedList<Integer>();
	        if(rowIndex<0){
	            return res;
	        }
	        for(int i=0;i<=rowIndex;i++){
	            List<Integer> temp= new LinkedList<Integer>();
	            System.out.println("i de zhi  chushi temp->"+i+"  "+temp);
	            for(int j=0;j<=rowIndex;j++){
	                if(j==0){
	                    temp.add(1);
	                    continue;
	                }
	                if(j==rowIndex){
	                    temp.add(1);
	                    continue;
	                }
	                else{
	                    int ele=res.get(j-1)+res.get(j);
	                    temp.add(ele);
	                }
	            }
	            System.out.println("i de zhi->"+i+"  "+temp);
	            res=temp;
	           
	        }
	        return res;
	    }

}
