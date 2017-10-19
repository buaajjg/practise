package practice;



public class John {

	public static void main(String[] args) {
		John j=new John();
		System.out.println(j.getIndex(40,3));
		
	}
	public  int getIndex(int length,int kill){
		 boolean [] man=new boolean[length];
		 int i=0;
		 int count=1;
		 int sum=length;
		
		 while(true){
			 if(man[i]==true){
				 i++;
				 if(i==length){
					 i=0;
				 }
				 continue;
			 }
			 if(count==kill){
				 man[i]=true;
				 sum--;
				 if(sum==2){
					 break;
				 }
				count=0;
			 }
			 
			 i++;
			 count++;
			 if(i==length){
				 i=0;
			 }
			 System.out.println("i+count+ sum"+i+" "+count+" "+sum);
		 }
		 
		 for(int k=0;k<man.length;k++){
			 System.out.println(k+"  "+man[k]);
			 if(man[k]==false){
				 
				// return k;
			 }
		 }
		 return -1;
	}

}
