package practice;

import java.util.ArrayList;

public class BstPreToPost {

	public static void main(String[] args) {
		ArrayList<Integer> pre= new ArrayList<>();
		pre.add(7);
		pre.add(4);
		pre.add(3);
		pre.add(5);
		pre.add(6);
		pre.add(10);
		pre.add(8);
		pre.add(12);
		pre.add(13);
		BstPreToPost tt=new BstPreToPost();
		
		System.out.println(tt.transfer(pre));

	}
	public ArrayList<Integer> transfer(ArrayList<Integer> pre){
		if(pre==null||pre.size()==0){
			return null;
		}
		if(pre.size()==1){
			return pre;
		}
		ArrayList<Integer> post= new ArrayList<>();
		ArrayList<Integer> left= new ArrayList<>();
		ArrayList<Integer> right= new ArrayList<>();
		int i=1;
		int node=pre.get(0);
		while(i<pre.size()){
			if(pre.get(i)<node){
				left.add(pre.get(i));
			}
			if(pre.get(i)>node){
				right.add(pre.get(i));
			}
			i++;
		}
		if(left.size()>0){
			post.addAll(transfer(left));
		}
		if(right.size()>0){
			post.addAll(transfer(right));
		}
		post.add(node);
		return post;
	}

}
