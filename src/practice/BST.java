package practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;



import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BST {
	public static TreeMap<Integer, Integer> map = new TreeMap<>();
	TreeNode root;
	public BST(){
		root=null;
	}
	public void add(int val){
		TreeNode node = new TreeNode(val);
        if (root == null)
        {
            root = node;
            return;
        }
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null)
        {
            parent = current;
            if (current.val > val)
                current = current.left;
            else
                current = current.right;
        }

        if (parent.val > val)
            parent.left = node;
        else
            parent.right = node;

	}
	public TreeNode findMin(TreeNode node){
		if(node==null||node.left==null){
			return node;
		}
		else{
			return findMin(node.left);
		}
	}
	private TreeNode FindMinIter(TreeNode node)
    {
        if (node == null)
            return null;
        TreeNode curr = root;
        while (curr.left != null)
            curr = curr.left;
        return curr;
    }

	public void remove(int val){
		remove(root, null,val );
	}
	private void remove(TreeNode node,TreeNode par, int data){
		if(node==null){
			return;
		}
		if(node.val>data){
			remove(node.left,node,data);
		}
		else if(node.val<data){
			remove(node.right,node,data);
		}
		else{
			if(node.left==null&&node.right==null){
				if(par.left==node){
					par.left=null;
				}
				else if(par.right==node){
					par.right=null;
				}
				node=null;
				return;
			}
			if(node.left==null){
				if(par.left==node){
					par.left=node.right;
				}
				if(par.right==node){
					par.right=node.right;
				}
				return;
			}
			if(node.right==null){
				if(par.left==node){
					par.left=node.left;
				}
				if(par.right==node){
					par.right=node.left;
				}
				return;
			}
			else{
				node.val = findMin(node.right).val;
                remove(node.right, node, node.val);

			}
		}
	}
	public void preOrder(){
		preOrder(root);
		System.out.println();
	}
	private void preOrder(TreeNode node){
		if(node==null){
			return;
		}
		System.out.print(node.val+"\t");
		preOrder(node.left);
		preOrder(node.right);
	}
	public void inOrder(){
		inOrder(root);
		System.out.println();
	}
	private void inOrder(TreeNode node){
		if(node==null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.val+"\t");
		inOrder(node.right);
	}
	public int getHeight(){
		return getHeight(root);
		
	}
	private int getHeight(TreeNode node){
		if(node==null){
			return 0;
		}
		return 1+Math.max(getHeight(node.left), getHeight(node.right));
	}
	public int size(){
		return size(root);
		
	}
	private int size(TreeNode node){
		if(node==null){
			return 0;
		}
		return 1+size(node.left)+size(node.right);
	}
	public boolean isBST(){
		return isBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
		
	}
	private boolean isBST(TreeNode node, int max, int min){
		if(node==null){
			return true;
		}
		if(node.val>max||node.val<min){
			return false;
		}
		return isBST(node.left,node.val,min)&&isBST(node.right,max,node.val);
	}
	public void printLevelOrder(){
		printLevelOrder(root);
		System.out.println();
	}
	private void printLevelOrder(TreeNode node){
		if(node==null){
			return;
		}
		Queue<TreeNode> q= new LinkedList<>();
		q.offer(node);
		q.offer(null);
		while(!q.isEmpty()){
			TreeNode temp=q.poll();
			if(temp!=null){
				System.out.print(temp.val+"\t");
				if(temp.left!=null){
					q.offer(temp.left);
				}
				if(temp.right!=null){
					q.offer(temp.right);
				}
			}
			else{
				if(q.isEmpty()){
					break;
				}
				q.offer(null);
				System.out.println();
			}
			
		}
	}
	public void printZigZag(){
		printZigZag(root);
		System.out.println();
	}
	private void printZigZag(TreeNode node){
		if(node==null){
			return;
		}
		Queue <TreeNode>q= new LinkedList<>();
		boolean flag=true;
		Stack <TreeNode> stack= new Stack<>();
		q.offer(node);
		q.offer(null);
		while(!q.isEmpty()){
			TreeNode temp=q.poll();
			if(temp!=null){
				if(temp.left!=null){
					q.offer(temp.left);
				}
				if(temp.right!=null){
					q.offer(temp.right);
				}
				if(flag){
					System.out.print(temp.val+"\t");
				}
				else{
					stack.push(temp);
				}
			}
			else{
				if(q.isEmpty()){
					break;
				}
				q.offer(null);
				while(!stack.isEmpty()){
					System.out.print(stack.pop().val+"\t");
				}
				flag=!flag;
				System.out.println();
			}
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().val+"\t");
		}
		
	}
	public void printPerimeter(){
		printPerimeter(root,0,0);
		System.out.print(root.val);
	}
	private void printPerimeter(TreeNode node, int left, int right){
		if (node != null)
        {
            int l = left;
            int r = right;
            if (right == 0 && left != 0)
               System.out.print(node.val +"\t");
            else if (left == 0 && right != 0)
            	System.out.print(node.val + ",");
            else if (node.left == null && node.right == null)
            	System.out.print(node.val + "\t");
             l = l +1;
            printPerimeter(node.left, l, r);
            r = r + 1;
            printPerimeter(node.right, l, r);
        
        }

	}
	public void printButtomView(){
		 if (root == null)
	            return;
 
	        int hd = 0;

	        Map<Integer, Integer> map = new TreeMap<>();

	        Queue<TreeNode> queue = new LinkedList<TreeNode>();

	        root.hd = hd;
	        queue.add(root);

	        while (!queue.isEmpty())
	        {
	            TreeNode temp = queue.remove();
	            hd = temp.hd;
	            map.put(hd, temp.val);
	            if (temp.left != null)
	            {
	                temp.left.hd = hd-1;
	                queue.add(temp.left);
	            }   
	            if (temp.right != null)
	            {
	                temp.right.hd = hd+1;
	                queue.add(temp.right);
	            }
	        }

	        Set<Entry<Integer, Integer>> set = map.entrySet();
	        Iterator<Entry<Integer, Integer>> iterator = set.iterator();

	        while (iterator.hasNext())
	        {
	            Map.Entry<Integer, Integer> me = iterator.next();
	            System.out.print(me.getValue()+"\t");
	        }
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
				if(q.isEmpty()){
					break;
				}
				q.offer(null);
				System.out.print(pre.val+"\t");
			
			}
			pre=temp;
		}
		
	}
	
	
	public static void main(String[] args) {
		BST bst= new BST();
		Random rand= new Random();
		bst.add(20);
		HashSet <Integer> set=new HashSet<>();
		for(int i=0;i<40;i++){
			set.add(rand.nextInt(40));
		}
		for(int i:set){
			bst.add(i);
		}
		
		bst.inOrder();
		bst.preOrder();
		System.out.println("Height:  "+bst.getHeight());
		System.out.println("Size:  "+bst.size());
		System.out.println("isBST:  "+bst.isBST());
		bst.printLevelOrder();
		bst.printZigZag();
		bst.printPerimeter();
		bst.printButtomView();
		
		 
	}

}

class TreeNode{
	int val;
	int hd;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val){
		this.val=val;
		left=null;
		right=null;
	}
}
class QueuePack {
	int level;
	TreeNode tnode;

	public QueuePack(int level, TreeNode tnode) {
		this.level = level;
		this.tnode = tnode;
	}
}
/*
Create a Class for nodes and BST trees as discussed in the class. 
You can refer to the code in the Course material. 
Make class for BST in Java with all the functions we discussed in class. 
in addition to this add a function of printing "Bottom View" for the tree. 

Bottom View Function:
You can use the BFS code for traversing and then add the nodes in a Hash Map and then print values. 
*/