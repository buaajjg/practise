package practice;

import java.util.Random;

public class Quicksort {

	public static void main(String[] args) {
		Random rand= new Random();
		int [] nums=new int [10];
		for(int i=0;i<10;i++){
			nums[i]=rand.nextInt(100);
			System.out.print(nums[i]+"\t");
		}
		Quicksort q= new Quicksort();
		System.out.println();
		q.sortPre(nums,0,9);
		for(int num:nums){
			System.out.print(num+"\t");
		}
	}
	public void sort(int [] nums, int start, int end){
		if(start>=end){
			return;
		}
		int mid=nums[end];
		int left=start;
		int right=end-1;
		while(left<right){
			while(nums[left]<mid&&left<right){
				left++;
			}
			while(nums[right]>=mid&&left<right){
				right--;
			}
			swap(nums,left,right);
			for(int num:nums){
				System.out.print(num+"\t");
			}
			System.out.println();
		}
		if(nums[left]>nums[end]){
			swap(nums,left,end);
			
		}
		else{
			left++;
		}
		sort(nums,start,left-1);
		sort(nums,left,end);
	}
	public void sortPre(int [] nums, int start, int end){
		if(start>=end){
			return;
		}
		int mid=nums[start];
		int left=start+1;
		int right=end;
		while(left<right){
			while(nums[left]<=mid&&left<right){
				left++;
			}
			while(nums[right]>mid&&left<right){
				right--;
			}
			swap(nums, left,right);
		}
		swap(nums,left-1,start);
		sortPre(nums,start,left-1);
		sortPre(nums,left,end);
		
	}
	public void swap(int [] nums, int x, int y){
		int temp=nums[x];
		nums[x]=nums[y];
		nums[y]=temp;
	}
}
