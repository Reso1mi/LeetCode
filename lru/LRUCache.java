import java.util.*;
public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.value=value;
        }
    }

    private HashMap<Integer,Node> map=new HashMap<>();

    private Node head=null;

    private Node tail=null;

    private int capacity=0;

    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node=map.get(key);
            //添加到链表头
            addFirst(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node newHead=new Node(key,value);
        if (map.containsKey(key)) {
            Node node=map.get(key);
            node.value=newHead.value;
            //添加到链表头
            addFirst(node);
            return;
        }

        if (map.size()==capacity) {
            tail=tail.pre;
            tail.next.pre=null;
            tail.next=null;
            map.remove(tail.key);
        }
        if (map.size()==0) {
            head=newHead;
        }else{
            addFirst(newHead);
        }
        map.put(key,newHead);
    }

    public void addFirst(Node newHead){
        if (newHead.next!=null) {
            newHead.next.pre=newHead.pre;   
        }
        if (newHead.pre!=null) {
            newHead.pre.next=newHead.next;
        }
        newHead.next=head;
        newHead.pre=null;
        head.pre=newHead;
        head=newHead;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */