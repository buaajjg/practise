package practice;

public class Stock {
	public static void main(String [] args){
		int [] price1= {39, 20, 45, 51, 36, 23, 54, 69};
		int [] price2={};
		int [] price3={1,2};
		int [] price4={2,1};
		int [] price5={3,5,4};
		int [] price6={1,2,5,2,4,5,12,3,51,23,1234,1,213,1,1231,123,31,123};
		int [] price7={9,8,7,6,5,4,3,2,1};
		Stock s= new Stock();
		System.out.println("price1:");
		s.getInterval(price1);
		
		System.out.println("price2:");
		s.getInterval(price2);
		
		System.out.println("price3:");
		s.getInterval(price3);
		
		System.out.println("price4:");
		s.getInterval(price4);
		
		System.out.println("price5:");
		s.getInterval(price5);
		
		System.out.println("price6:");
		s.getInterval(price6);
		
		System.out.println("price7:");
		s.getInterval(price7);
	}
	
	/*    the output of the console
	 		price1:
			20--51
			23--69
			price2:
			price3:
			1--2
			price4:
			price5:
			3--5
			price6:
			1--5
			2--12
			3--51
			23--1234
			1--213
			1--1231
			31--123
			price7:
	 */
	public void getInterval(int [] price){
		if(price==null||price.length<2){
			return;
		}
		int min=price[0];
		boolean flag=true;
		int i=1;
		int max=price[1];
		while(i<price.length){
			if(price[i]<=min&&flag){
				min=price[i];
			}
			if(price[i]<=max&&(!flag)){
				System.out.println(min+"--"+max);
				int [] relic= new int[price.length-i];
				System.arraycopy(price, i, relic, 0, price.length-i);
				getInterval(relic);
				break;
			}
			if(price[i]>min){
				max=price[i];
				flag=false;
			}
			if(i==price.length-1&&(price[i]>min)){
				System.out.println(min+"--"+price[i]);
			}
			i++;
		}
	}
	
}
