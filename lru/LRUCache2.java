import java.util.*;
public class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.value=value;
            this.key=key;
        }
    }

    HashMap<Integer,Node> map=new HashMap<>();

    Node head=null;

    Node tail=null;

    int capacity=0;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        //初始化头尾节点,注意这两个节点只是个哨兵节点,并不会存入map中
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node=map.get(key);
            //移动到链表头
            move2Head(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node newHead=new Node(key,value);
        if (map.containsKey(key)) {
            Node node=map.get(key);
            //设置节点值为新value
            node.value=value;
            //移动到链表头
            move2Head(node);
            return;
        }
        //满了,先剔除tail再插入
        if (map.size()==capacity) {
            map.remove(popTail().key);
        }
        addFirst(newHead);
        map.put(key,newHead);
    }

    //弹出tail
    private Node popTail(){
        Node newTail=tail.pre;
        removeNode(newTail);
        return newTail;
    }

    //移除节点
    private void removeNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    //从头添加
    private void addFirst(Node node){
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
        node.pre=head;
    }

    //移动节点到head
    private void move2Head(Node node){
        //删除原链表中对应位置的node
        removeNode(node);
        //从头再添加一遍
        addFirst(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */