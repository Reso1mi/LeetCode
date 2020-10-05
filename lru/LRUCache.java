class LRUCache {
    
    HashMap<Integer, Node> map = null;
        
    int capacity = 0;
    
    Node head = null;
    
    Node tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        insert2head(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            insert2head(node);
            map.put(key, node);
        } else {
            removeNode(node);
            node.val = value;
            insert2head(node);
        }
        if (map.size() > capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
    }
    
    public void insert2head(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    //移除Node节点
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
    
    class Node {
        Node prev, next;
        int key, val;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */