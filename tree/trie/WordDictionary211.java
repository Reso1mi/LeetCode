class WordDictionary211 {

    private class Node{
        public boolean isWord; //是否找到了一个单词
        public Node[] next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new Node[26];
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWord(root,word,0);
    }

    public void addWord(Node cur,String word,int index) {
        if (index == word.length()) {
            cur.isWord=true;
            return;
        }
        char c=word.charAt(index);
        if (cur.next[c-'a']==null) {
            cur.next[c-'a']= new Node();
        }
        addWord(cur.next[c-'a'],word,index+1);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root,word,0);
    }

    public boolean search(Node cur,String word,int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c=word.charAt(index);
        if (c=='.') {
            for (int i=0;i<cur.next.length;i++) {
                if(cur.next[i]!=null && search(cur.next[i],word,index+1)){
                    return true;
                }
            }
            return false;
        }
        return cur.next[c-'a']!=null && search(cur.next[c-'a'],word,index+1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */