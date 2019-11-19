public class LinkedListMap<K,V> implements Map<K,V>{
    private class Node{

        public K key;
        public V value;
        public Node next;

        public Node(K key,V value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString()+" : "+value.toString();
        }
    }

    private Node dummyNode;

    private int size;

    public LinkedListMap(){
        dummyNode=new Node();
        size=0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    private Node getNode(K key){
        Node cur=dummyNode.next;
        while(cur!=null){
            if (cur.key.equals(key)) {
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key){
        return getNode(key)==null;
    }

    @Override
    public V get(K key){
        Node node=getNode(key);
        return node==null?null:node.value;
    }

    @Override
    public void put(K key,V value){
        Node node = getNode(key);
        if(node==null){
            dummyNode.next=new Node(key,value,dummyNode.next);
            size++;
        }else{
            node.value=value;
        }
    }

    @Override
    public void set(K key,V value){
        Node node = getNode(key);
        if(contains(key)){
            node.value=value;
        }else{
            throw new IllegalArgumentException(key +" doesn't exist!");
        }
    }

    @Override
    public V remove(K key){
        Node prev=dummyNode;
        while(prev.next!=null){
            if (prev.next.key.equals(key)) {
                break;
            }
            prev=prev.next;
        }
        if (prev.next==null) {
            //其实可以和上面一样抛一个异常
            return null;
        }
        Node deleNode=prev.next;
        prev.next=deleNode.next;
        deleNode.next=null;
        size--;
        return deleNode.value;
    }
}