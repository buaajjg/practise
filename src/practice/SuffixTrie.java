package practice;
//Add functions to suffix Trie so that we can find out how many times a substring is repeated in a string. 
 
import java.util.ArrayList;

public class SuffixTrie {
	public static void main(String [] args){
		SuffixTrie st= new SuffixTrie();
		System.out.println("does exit abc-->"+st.doseExist("abc"));
		System.out.println("how many abc-->"+st.getCount("abc"));
		st.insert("abc");
		System.out.println("does exit abc-->"+st.doseExist("abc"));
		System.out.println("how many abc-->"+st.getCount("abc"));
		st.insert("acc");
		System.out.println("how many abc-->"+st.getCount("abc"));
		st.insert("abc");
		System.out.println("how many abc-->"+st.getCount("abc"));
		st.insert("abc");
		System.out.println("how many abc-->"+st.getCount("abc"));
	}
	Node root;
	public SuffixTrie(){
		root= new Node('0');
		}
	private void insert(String st){
		char [] arr= st.toCharArray();
		Node cur=root;
		for(int i=0;i<arr.length;i++){
			Node child=findNext(cur, arr[i]);
			if(child==null){
				child= new Node(arr[i]);
				cur.next.add(child);
			}
			cur=child;
			if(i==arr.length-1){
				cur.countEnd++;
				cur.isEnd=true;
			}
		}
	}
	private Node findNext(Node node, char val){
		for(int i=0;i<node.next.size();i++){
			if(val==node.next.get(i).val){
				return node.next.get(i);
			}
		}
		return null;
	}
	public boolean doseExist(String st){
		char [] arr=st.toCharArray();
		Node cur=root;
		for(int i=0;i<arr.length;i++){
			Node child=findNext(cur,arr[i]);
			if(child==null){
				return false;
			}
			cur=child;
		}
		return true;
	}
	public int getCount(String st){
		char [] arr=st.toCharArray();
		Node cur=root;
		for(int i=0;i<arr.length;i++){
			Node child=findNext(cur,arr[i]);
			if(child==null){
				return 0;
			}
			cur=child;
		}
		return cur.countEnd;
	}
	
}
class Node{
	public char val;
	public boolean isEnd;
	public int countEnd;
	public ArrayList<Node> next;
	private Node(){}
	public Node (char val){
		this.val=val;
		this.isEnd=false;
		this.countEnd=0;
		next=new ArrayList<Node>();
	}
}

