package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<>();
        try{
        	int i=0;
            while(i<10){
             int temp=sc.nextInt();
                if(temp>=0&&temp<=Integer.MAX_VALUE){
                  list.add(temp);
                    
                }
                else{
                  System.out.println("failure");
                  return; 
                }
            i++;
            }
            
            printIndice(list);
        }
        catch(Exception e){
            System.out.println("failure");
        }
    }
    public static void printIndice(ArrayList<Integer> list){
       
        if(list==null||list.size()==0){
            System.out.println("failure");
            return;
        }
        int length=list.size();
        int [] dp= new int[length+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        int reach=0;
        out:
        for(int i=0;i<list.size();i++){
            int temp=list.get(i);
            if(dp[i]==Integer.MAX_VALUE){
                System.out.println("failure");
                return;
              }
            for(int j=reach+1;j<=i+temp;j++){
                dp[j]=Math.min(dp[j],i);
                if(j>=length){
                    print(dp);
                   break out; 
                }
            }
        }
        
    }
    public static void print(int [] dp){
        int l=dp.length;
        ArrayList<Integer> res= new ArrayList<>();
        int i=l-1;
        while(i>0){
            res.add(0,dp[i]);
            i=dp[i];
        }
        for(int ele :res){
            System.out.print(ele+", ");
        }
        System.out.println("out");
    }
}