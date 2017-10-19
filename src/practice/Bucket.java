package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Bucket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Bucket bb=new Bucket();
			int [] b={3,5};
			int [] res=bb.getMin(b);
			for(int ele:res){
				System.out.println(ele);
			}
			System.out.println(bb.excute(3, 3, 0));
			
	}
	public int [] getMin(int [] bucket){
		Arrays.sort(bucket);
		if(bucket.length<=0||bucket.length>5||bucket[bucket.length-1]>20){
			return null;
		}
		int [] res= new int[bucket[bucket.length-1]+1];
		res[0]=-1;
		ArrayList<ArrayList<ArrayList<Integer>>> root= new ArrayList<>();
		ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
		ArrayList<Integer> init= new ArrayList<>();
		init.add(0);
		init.add(0);
		pre.add(init);
		root.add(pre);
		int count=0;
		int sum=0;
		int bucket3=0;
		int  bucket5=0;
		HashSet<ArrayList<Integer>> set= new HashSet<>();
		
		out:
		while(!root.isEmpty()){
			count++;
			ArrayList<ArrayList<ArrayList<Integer>>> top= new ArrayList<>();
			ArrayList<ArrayList<Integer>> sec = new ArrayList<>();
			pre = root.remove(0);
			for(int k=0;k<pre.size();k++){
			
			ArrayList<Integer> temp=pre.get(k);
			int PreBucket3=temp.get(0);
			int PreBucket5=temp.get(1);
			
			//System.out.println("3+5  "+bucket3+"  "+bucket5);
			for(int i=1;i<=6;i++){
				//1轮count可能有几个新配对
				ArrayList<Integer> after=excute(i,PreBucket3,PreBucket5);
				bucket3=after.get(0);
				bucket5=after.get(1);
				//if(i==6) break;
				System.out.println("pre?i "+pre+"  "+i+"  "+count+" "+temp+"  "+after);
				
				if(!set.contains(after)){
					set.add(after);
					sec.add(after);
				}
				
				if(res[bucket3]==0){
					res[bucket3]=count;
					sum++;
				}
				if(res[bucket5]==0){
					res[bucket5]=count;
					sum++;
				}
				if(sum==res.length-1){
					break out;
				}
			}
			
			}
			top.add(sec);
			root= new ArrayList<>();
			root.addAll(top);
			System.out.println("root"+root);
			
		}
		return res;
	}
	public ArrayList<Integer> excute(int flag,int bucket3,int bucket5){
		ArrayList<Integer> temp=new ArrayList<>();
		if(flag==1){
			bucket3=0;
		}
		if(flag==2){
			bucket3=3;
		}
		if(flag==3){
			if(bucket5+bucket3<=5){
				bucket5=bucket5+bucket3;
				bucket3=0;
				
			}
			if(bucket5+bucket3>5){
				int diff=5-bucket5;
				bucket3=bucket3-diff;
				bucket5=5;
			}
		}
		if(flag==4){
			bucket5=0;
		}
		if(flag==5){
			bucket5=5;
		}
		if(flag==6){
			if(bucket5+bucket3<=3){
				bucket3=bucket5+bucket3;
				bucket5=0;
				
			}
			if(bucket5+bucket3>3){
				int diff=3-bucket3;
				bucket5=bucket5-diff;
				bucket3=3;
			}
		}
		temp.add(bucket3);
		temp.add(bucket5);
		//System.out.println("-----"+temp);
		return temp;
	}
}
