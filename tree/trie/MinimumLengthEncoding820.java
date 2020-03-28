public class MinimumLengthEncoding820{
    public static void main(String[] args) {

    }

    //["time", "me", "bell"]
    //["time", "ti", "bell"]
    
    public int res=0;

    private Node root;

    public int minimumLengthEncoding(String[] words) {
        root=new Node();
        //纠结了半天要不要排序
        Arrays.sort(words,(a,b)->b.length()-a.length());
        for (int i=0;i<words.length;i++) {
            if(!hasPrefix(words[i])){
                add(words[i]);
                res+=(words[i].length()+1);
            }
        }
        return res;
    }

    private class Node{
        
        public Node[] next;
        
        public Node(){
            next = new Node[26];
        }
    }

    //递归的添加
    public void add(String word){
        //后缀树
        add(root,word,word.length()-1);
    }

    public void add(Node cur,String word,int index){
        if (index==-1) {
            return;
        }
        char c=word.charAt(index);
        if (cur.next[c-'a']==null) {
            cur.next[c-'a']=new Node();
        }
        add(cur.next[c-'a'],word,index-1); //尾递归
    }

    public boolean hasPrefix(String word){
        return hasPrefix(root,word,word.length()-1);
    }

    public boolean hasPrefix(Node cur,String word,int index){
        if(index==-1){
            return true;
        }
        char c=word.charAt(index);
        return cur.next[c-'a']!=null && hasPrefix(cur.next[c-'a'],word,index-1);
    }
}