func removeDuplicateNodes(head *ListNode) *ListNode {
    var set = make([]bool, 20001)
    var dummyNode = &ListNode{Next: head}
    var pre = dummyNode
    for head != nil {
        if !set[head.Val] {
            set[head.Val] = true
            pre = head
        } else {
            pre.Next = head.Next
        }
        head = head.Next
    }
    return dummyNode.Next
}
