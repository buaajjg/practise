package practice;

import java.util.*;

class Vote{
	 public long timestamp;
	 public String name;
	 public Vote(long time, String name){
		 this.timestamp=time;
		 this.name=name;
	 }
}

public class FindTopVote {
	
	public static void main(String []args){
		
		Vote v1=new Vote((long)1,"def");
		Vote v2=new Vote((long)2,"abc");
		Vote v3=new Vote((long)3,"abc");
		Vote v0=new Vote((long)0,"abc");
		Vote v4=new Vote((long)4,"def");
		Vote v5=new Vote((long)5,"xyz");
		Vote v7=new Vote((long)7,"def");
		Vote v8=new Vote((long)7,"tuy");
		
		List<Vote> votes= new ArrayList<>();
		votes.add(v0);
		votes.add(v1);
		votes.add(v2);
		votes.add(v3);
		votes.add(v4);
		votes.add(v5);
		votes.add(v7);
		votes.add(v8);
		FindTopVote fd= new FindTopVote();
		for(long i=0;i<9;i++){
		
		System.out.println(i+"   "+fd.findTopVotes(votes, i));
		}
	}
	
 List<Vote> votes;
 public String findTopVotes(Collection <Vote> votes,long timeStamp){
	 List<Vote> vs=(List<Vote>)votes;
	 Collections.sort(vs, new Comparator<Vote>(){
		public int compare(Vote v1,Vote v2) {
		 return (int)v1.timestamp-(int)v2.timestamp;	
		}
	 });
	 
	 HashMap<Long, ArrayList<String>> map= new HashMap<>();
	 ArrayList<String> aa= new ArrayList<>();
	 for(Vote v:votes){
		 if(!map.containsKey(v.timestamp)){
			
			 map.put(v.timestamp,new ArrayList<String>(aa));
			
		 }
		 aa.add(v.name);
		map.get(v.timestamp).add(v.name); 
		
	 }
	 if(!map.containsKey(timeStamp)){
		 return "";
	 }
	 ArrayList<String> temp=map.get(timeStamp);
	 
	 HashMap<String,Integer> count= new HashMap<>();
	 System.out.println("temp"+temp);
	 for(String st:temp){
		 if(!count.containsKey(st)){
			 count.put(st,0);
		 }
		 count.put(st, count.get(st)+1);
	 }
	 int max=0;
	 for(Map.Entry<String, Integer> entry: count.entrySet()){
		 if(entry.getValue()>max){
			 max=entry.getValue();
		 }
	 }
	 System.out.println("map: "+count);
	 String res="";
	 for(Map.Entry<String, Integer> entry: count.entrySet()){
		 if(entry.getValue()==max){
			 res+=","+entry.getKey();
		 }
	 }
	 return res.substring(1);
 }
}
