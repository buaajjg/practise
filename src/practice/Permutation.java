package practice;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		Permutation per= new Permutation();
		System.out.println(per.PermuSequence(3, 4));
		long a=1232131231;
		long b=23123;
		//int index=(int) (a/b);

	}
	public String PermuSequence(int n,int m){
		String res="";
		int times=0;
		int fac=1;
		ArrayList<Integer> list= new ArrayList<>();
		while(times<n){
			list.add(times);
			times++;
			fac=fac*times;
		}
		System.out.println(list);
		if(m>fac||n<0||n>20||m<0){
			return res;
		}
		m--;
		fac=fac/n;
		times=times-1;
		while(times>=0){
			int index=m/fac;
			res+=list.get(index);
			list.remove(index);
			m=m%fac;
			if(times>0){
				fac=fac/times;
			}
			times--;
		}
		return res;
	}
}
