package test;

import java.util.LinkedList;
import java.util.Queue;





class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val=val;
		
	}
	
}
public class RightView {

	public static void main(String[] args) {
		RightView rw= new RightView();
		int [] aa={2,3,7,1,4,8,0,2,4,7,2,8};
		System.out.println(rw.maxPro(aa));
		
		String st="hikjsdxhikjsdxhihiahinsmdhi";
		System.out.println(rw.countHi(st));
		
		TreeNode node=new TreeNode(0);
		node.left=new TreeNode(1);
		node.left=new TreeNode(2);
		
		node.left.left=new TreeNode(3);
		node.left.right=new TreeNode(4);
		
		rw.printRightView(node);

	}
	public void printRightView(TreeNode node){
		if(node==null){
			return;
		}
		Queue<TreeNode> q= new LinkedList<>();
		q.offer(node);
		q.offer(null);
		TreeNode pre=node;
		while(!q.isEmpty()){
			TreeNode temp=q.poll();
			if(temp!=null){
				
				if(temp.left!=null){
					q.offer(temp.left);
				}
				if(temp.right!=null){
					q.offer(temp.right);
				}
			}
			else{
				System.out.println(pre.val);
				if(q.isEmpty()){
					break;
				}
				q.offer(null);
				
			
			}
			pre=temp;
		}
		
	}
	public int maxPro(int [] stock){
		if(stock==null||stock.length<2){
			return 0;
		}
		int min=stock[0];
		
		int profit=0;
		for(int i=1;i<stock.length;i++){
			int temp=stock[i]-min;
			profit=Math.max(profit,temp);
			min=Math.min(min,stock[i]);
		}
		return profit;
	}
	public int countHi(String st){
		if(st==null||st.length()<2){
			return 0;
		}
		if(st.startsWith("xhi")){
			return countHi(st.substring(3));
		}
		if(st.startsWith("hi")){
			return 1+countHi(st.substring(2));
			
		}
		else{
			return countHi(st.substring(1));
		}
	}
}
