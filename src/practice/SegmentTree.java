package practice;

public class SegmentTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SegmentTree st= new SegmentTree();
		st.buildTree(0,0,0);
	}
	STreeNode [] tree=new STreeNode[40];
	public void buildTree(int index, int left, int right){
		tree[index].left=left;
		tree[index].right=right;
		tree[index].max=0;
		
		if(left==right){
			return;
		}
		int mid=(left+right)>>1;
		buildTree((index<<1)+1,left,mid);
		buildTree((index<<1)+2,mid+1,right);
	}
	public void insert(int index, int left,int right, int k){
		int mid=(tree[index].left+tree[index].right)/2;
		if(tree[index].left==tree[index].right){
			tree[index].max=k;
			return;
		}
		if(right<=mid){
			if(tree[index].max<=k)
				tree[index].max=k;
			insert((index<<1)+1,left,right,k);
			return;
		}
		else{
			if(left>mid){
				if(tree[index].max<=k){
					tree[index].max=k;
				}
				insert((index<<1)+2,left,right,k);
			}
		}
	}
	public int query(int index, int left, int right){
		int mid=(tree[index].left+tree[index].right)/2;
		if(tree[index].left==tree[index].right){
			return tree[index].max;
		}
		if(right<=mid){
			return query((index<<1)+2,left,right);
		}
		else{
			if(left>mid){
				return query((index<<1)+2,left,right);
			}
			else{
				return Math.max(query((index<<1)+1,left,mid), query((index<<1)+2,mid+1,right));
			}
		}
	}
}
class STreeNode{
	int left;
	int right;
	int max;
	
}