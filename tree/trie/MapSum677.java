public class MapSum677 {

    private class Node{
        public boolean isWord; //是否找到了一个单词
        public Node[] next;
        public int value;

        public Node(boolean isWord,int value){
            this.isWord = isWord;
            this.value=value;
            next = new Node[26];
        }

        public Node(int value){
            this(false,value);
        }
    }
    
    private Node root;

    public MapSum() {
        root=new Node(0);
    }
    
    public void insert(String key, int val) {
        insert(root,key,val,0);
    }

    //a p p l e
    public void insert(Node cur,String key, int val,int index) {
        if (index==key.length()) {
            cur.isWord=true;
            cur.value=val;
            return;
        }
        char c=key.charAt(index);
        if (cur.next[c-'a']==null) {
            cur.next[c-'a']=new Node(0);
        }
        insert(cur.next[c-'a'],key,val,index+1);
    }
    
    public int sum(String prefix) {
        return sum(root,prefix,0);
    }

    public int sum(Node cur,String prefix,int index) {
        if (index == prefix.length()) {
            return tireSum(cur);
        }
        char c=prefix.charAt(index);
        if (cur.next[c-'a']==null) {
            return 0;
        }
        return sum(cur.next[c-'a'],prefix,index+1);
    }

    public int tireSum(Node cur){
        int sum=0;
        if (cur.isWord) {
            sum+=cur.value;
        }
        for (int i=0;i<26;i++) {
            sum+=cur.next[i]!=null?tireSum(cur.next[i]):0;
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */