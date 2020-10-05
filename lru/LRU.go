type LRUCache struct {
    capacity int
    cache map[int]*Node
    head *Node
    tail *Node
}

type Node struct {
    prev *Node
    next *Node
    key int
    val int
}


func Constructor(capacity int) LRUCache {
    head := &Node{key : -1, val : -1}
    tail := &Node{key : -1, val : -1}
    head.next = tail
    tail.next = head
    return LRUCache{
        capacity : capacity,
        cache : make(map[int]*Node),
        head : head,
        tail : tail,
    }
}


func (this *LRUCache) Get(key int) int {
    if v, ok := this.cache[key]; ok {
        this.removeNode(v)
        this.insert2Head(v)
        return v.val
    }
    return -1
}


func (this *LRUCache) Put(key int, value int)  {
    if v, ok := this.cache[key]; ok {
        this.removeNode(v)
        v.val = value
        this.insert2Head(v)
    } else {
        newNode := &Node{key : key, val : value}
        this.cache[key] = newNode
        this.insert2Head(newNode)
    }
    if len(this.cache) > this.capacity {
        delete(this.cache, this.tail.prev.key)
        this.removeNode(this.tail.prev)
    }
}

func (this *LRUCache) removeNode (node *Node) {
    node.next.prev = node.prev
    node.prev.next = node.next
    node.prev = nil
    node.next = nil
}

func (this *LRUCache) insert2Head (node *Node) {
    node.prev = this.head
    node.next = this.head.next
    this.head.next.prev = node
    this.head.next = node
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */