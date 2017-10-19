package practice;

public class MostFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int [] nums={2, 2, 3, 4, 3, 3, 2, 2, 1,1,2,5,4,3,6,8,9};
			MostFrequent mf=new MostFrequent();
			System.out.println(mf.getPeak(nums));
			
	}
	public int getPeak(int [] nums){
		if(nums.length<=1){
			return nums.length;
			
		}
		int res=1;
		int key=0;
		int i=1;
		while(i<nums.length){
			while(i<nums.length&&nums[i]>nums[i-1]){
				if(key!=1){
					res++;
					key=1;
				}
				i++;
			}
			while(i<nums.length&&nums[i]<nums[i-1]){
				if(key!=-1){
					res++;
					key=-1;
				}
				i++;
				
			}
			
			if(i<nums.length&&nums[i]==nums[i-1]){
				i++;
			}
		}
		return res;
	}
}
