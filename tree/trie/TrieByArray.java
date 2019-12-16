import java.util.*;
public class TrieByArray{

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

    private int size;

    public TrieByArray(){
        root=new Node();
        size=0;
    }

    public int getSize(){
        return size;
    }

    //递归的添加
    public void add(String word){
        add(root,word,0);
    }

    public void add(Node cur,String word,int index){
        if (index==word.length()) {
            if (!cur.isWord) {
                size++;
                cur.isWord=true;
            }
            return;
        }
        char c=word.charAt(index);
        if (cur.next[c-'a']==null) {
            cur.next[c-'a']=new Node();
        }
        add(cur.next[c-'a'],word,index+1); //尾递归
    }

    //查询word是否在Trie中
    public boolean contains(String word){
        return contains(root,word,0);
    }

    public boolean contains(Node cur,String word,int index){
        if (index==word.length()) {
            return cur.isWord;
        }
        char c=word.charAt(index);
        return cur.next[c-'a']!=null&& contains(cur.next[c-'a'],word,index+1);
    }

    //循环
    public boolean containsLoop(String word){
        Node cur=root;
        for (int i=0;i<word.length();i++) {
            Character c=word.charAt(i);
            if (cur.next[c-'a']==null) {
                 return false;   
            }
            cur=cur.next[c-'a'];
        }
        return cur.isWord;
    }

    //是否有某个前缀
    public boolean hasPerfix(String perfix){
        return hasPerfix(root,perfix,0);
    }

    public boolean hasPerfix(Node cur,String perfix,int index){
        if (index==perfix.length()) {
            return true;
        }
        char c=perfix.charAt(index);
        return cur.next[c-'a']!=null && hasPerfix(cur.next[c='a'],perfix,index+1);
    }

    //懒得写循环了。。。
}