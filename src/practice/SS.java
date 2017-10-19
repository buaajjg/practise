package practice;
public class SS{
	public static void main(String [] args){
		SS s= new SS();
		int[][] edges={{0,1},{0,1}};
		System.out.println(s.validTree(2, edges));
	}
public boolean validTree(int n, int[][] edges) {
    initUnionFind(n);
    for (int i = 0; i < edges.length; i++) {
        if (!union(edges[i][0], edges[i][1]))
            return false;
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (s[i] < 0) {
            count++;
        }
    }
    return count == 1;
}
private int[] s;
//private int count;
public void initUnionFind(int n) {
    s = new int[n];
    for (int i = 0; i < n; i++)
        s[i] = -1;
}
public int find(int p) {
    if (s[p] < 0)
        return p;
    else {
        s[p] = find(s[p]);
        return s[p];
    }
}
// union by rank
public boolean union(int p, int q) {
    int pRoot = find(p), qRoot = find(q);
    if (pRoot == qRoot)
        return false;
    if (s[pRoot] < s[qRoot]) {
        s[pRoot] = qRoot;
    } else {
        if (s[pRoot] == s[qRoot])
            s[pRoot]--;
        s[qRoot] = pRoot;
    }
    return true;
}
// union by size
public boolean union1(int p, int q) {
    int pRoot = find(p), qRoot = find(q);
    if (pRoot == qRoot)
        return false;
    if (s[pRoot] < s[qRoot]) {
        s[pRoot] += s[qRoot];
        s[qRoot] = pRoot;
    } else {
        s[qRoot] += s[pRoot];
        s[pRoot] = qRoot;
    }
    return true;
}
}
