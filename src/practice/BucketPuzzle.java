package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class BucketPuzzle {

	public static void main(String[] args) {
		BucketPuzzle bp=new BucketPuzzle();
		int [] buckets={3,7,10,13,17};
		ArrayList<Integer> list=new ArrayList<>();
		list.add(0);
		list.add(2);
		list.add(0);
		list.add(0);
		list.add(0);
		
		//System.out.println(bp.excute(list, buckets));
		int [] res=bp.getMinStep(buckets);
		for(int ele:res){
			System.out.println(ele);
		}

	}
	
	HashSet<ArrayList<Integer>> set= new HashSet<>();
	
	public int [] getMinStep(int [] buckets){
		Arrays.sort(buckets);
		if(buckets.length<=0||buckets.length>5||buckets[buckets.length-1]>20){
			return null;
		}
		int [] res= new int[buckets[buckets.length-1]+1];
		res[0]=-1;
		ArrayList<ArrayList<ArrayList<Integer>>> root= new ArrayList<>();
		ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
		ArrayList<Integer> init= new ArrayList<>();
		for(int i=0;i<buckets.length;i++){
			init.add(0);
		}
		pre.add(init);
		root.add(pre);
		set.add(init);
		
		int count=0;
		int sum=0;
		
		out:
		while(!root.isEmpty()){
			count++;
			
			ArrayList<ArrayList<Integer>> sec = new ArrayList<>();
			pre = root.remove(0);
			for(int i=0;i<pre.size();i++){
				ArrayList<Integer> temp=pre.get(i);
				ArrayList<ArrayList<Integer>> output=excute(temp,buckets);
				for(int m=0;m<output.size();m++){
					ArrayList<Integer> element=output.get(m);
					for(int n=0;n<buckets.length;n++){
						int ele=element.get(n);
						if(res[ele]==0){
							res[ele]=count;
							sum++;
							if(sum==res.length-1){
								break out;
							}
						}
					}
				}
				sec.addAll(output);
			}
			if(root.isEmpty()){
				ArrayList<ArrayList<ArrayList<Integer>>> top= new ArrayList<>();
				top.add(sec);
				root=new ArrayList<>();
				root.addAll(top);
			}
		}
		
		return res;
	}
	public ArrayList<ArrayList<Integer>> excute(ArrayList<Integer> list,int [] buckets){
		ArrayList<ArrayList<Integer>> sec= new ArrayList<>();
		for(int i=0;i<list.size();i++){
			for(int k=0;k<buckets.length;k++){
				ArrayList<Integer> temp= new ArrayList<>(list);
				if(k==i){
					if(temp.get(i)==0){
						temp.set(k, buckets[k]);
					}
					else{
						temp.set(k, 0);
					}
				}
				else{
					int from=temp.get(i);
					int to=temp.get(k);
					if(from+to>buckets[k]){
						int diff=buckets[k]-to;
						to=buckets[k];
						from=from-diff;
					}
					else{
						to=from+to;
						from=0;
					}
					temp.set(i, from);
					temp.set(k, to);
				}
				if(!set.contains(temp)){
					sec.add(temp);
					set.add(temp);
				}
				
			}
			
			
		}
		
		
		return sec;
	}

}
