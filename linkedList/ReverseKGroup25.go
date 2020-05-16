func reverseKGroup(head *ListNode, k int) *ListNode {
    dummyNode := &ListNode{
        Next: head,
        Val:  -1,
    }
    pre := dummyNode
    cur := head
    //-1 | 1 2 3 4 5
    for cur != nil {
        for i := 0; i < k-1 && cur != nil; i++ {
            cur = cur.Next
        }
        if cur == nil { //不足k个
            break
        }
        next := cur.Next
        cur.Next = nil 
        start := pre.Next
        pre.Next = reverse(start)
        start.Next = next
        //这里要注意pre=start
        pre = start
        cur = next
    }
    return dummyNode.Next
}

func reverse(head *ListNode) *ListNode {
    var pre *ListNode
    var cur = head
    for cur != nil {
        next := cur.Next
        cur.Next = pre
        pre = cur
        cur = next
    }
    return pre
}
