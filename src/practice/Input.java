package practice;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int line=5;
		String ss=sc.nextLine();
		System.out.println(ss);
		for(int i=0;i<line;i++){	
			String l=sc.nextLine();
			String [] array=l.split(" ");
			int [] nums=new int[3];
			nums[0]=Integer.parseInt(array[0]);
			nums[1]=Integer.parseInt(array[1]);
			nums[2]=Integer.parseInt(array[2]);
			for(int num:nums){
				System.out.print(num+"\t");
			}
			
		}
	}
	

}
