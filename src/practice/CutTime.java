package practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class CutTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CutTime ct=new CutTime();
		String s="abc";
		String t="abc";
		System.out.println(getCutTimes(s,t));
				
	}
	public static int getCutTimes(String s, String t){
		if(s==null||s.length()==0||t==null||t.length()==0||s.length()<t.length()){
			return 0;
		}
		PriorityQueue <Integer> q= new PriorityQueue<>(Collections.reverseOrder());
		//q.offer(1);
		
		getCut(s,t,0,q);
		System.out.println(q);
		return q.peek();
	}
	
	private static void getCut(String s, String t, int time, PriorityQueue <Integer> q){
		q.offer(time);
		if(s.length()==0||t.length()>s.length()){
			return;
		}
		int sL=s.length();
		int tL=t.length();
		for(int i=0;i<=sL-tL;i++){
			String temp=s.substring(i, i+tL);
			System.out.println("temp:"+temp);
			if(temp.equals(t)){
				String relic=s.substring(0,i)+s.substring(i+tL);
				System.out.println("relic:"+relic);
				time++;
				
				getCut(relic,t,time,q);
				time--;
			}
			
		}
		
	}
}
