package practice;

public class WordDictionary {
	public static void main(String []args){
		WordDictionary wd= new WordDictionary();
		wd.addWord("abc");
		System.out.println(wd.search("ab."));
	}
    class TrieNode{
        private int num;
        private TrieNode [] son;
        private char val;
        private boolean isEnd;
        public TrieNode(){
            num=1;
            son=new TrieNode[26];
            isEnd=false;
        }
    }
    
    TrieNode root =new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word==null||word.length()==0){
            return;
        }
        TrieNode node=root;
        char [] st=word.toCharArray();
        for(int i=0;i<st.length;i++){
            int index=st[i]-'a';
            if(node.son[index]==null){
                node.son[index]=new TrieNode();
                node.son[index].val=st[i];
            }
            node.son[index].num++;
            node=node.son[index];
        }
        node.isEnd=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word==null||word.length()==0){
            return false;
        }
        TrieNode node=root;
        return searchHelper(node,word);
      
    }
    public boolean searchHelper(TrieNode node,String word){
        if(word.length()==0){
            return node.isEnd;
        }
        char temp=word.charAt(0);
        if(temp=='.'){
            boolean res=false;
            for(int i=0;i<26;i++){
            	if(node.son[i]==null){
            		continue;
            	}
                res=res||searchHelper(node.son[i],word.substring(1));
            }
            return res;
        }
        else{
            if(node.son[temp-'a']==null){
                return false;
            }
            else{
                return searchHelper(node.son[temp-'a'],word.substring(1));
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");