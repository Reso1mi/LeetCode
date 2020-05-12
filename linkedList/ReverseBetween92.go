/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
//头插法
func reverseBetween(head *ListNode, m int, n int) *ListNode {
    dummyNode := &ListNode{
        Val:  -1,
        Next: head,
    }
    mpre := dummyNode //m节点前的节点
    for i := m; i > 1; i-- {
        mpre = mpre.Next
    }
    cur := mpre.Next
    //1 |2 3 4| 5
    for i := m; i < n; i++ {
        //除非m=n=len不然next肯定不为空,但是已经被循环的条件过滤了
        next := cur.Next
        cur.Next = next.Next
        next.Next = mpre.Next
        mpre.Next = next
    }
    return dummyNode.Next
}

//比较不容易出错的解法
func reverseBetween2(head *ListNode, m int, n int) *ListNode {
    dummyNode := &ListNode{
        Val:  -1,
        Next: head,
    }
    mpre := dummyNode //m节点前的节点
    for i := m; i > 1; i-- {
        mpre = mpre.Next
    }
    pre := mpre
    cur := mpre.Next
    //  2   4
    //1 2 3 4 5
    for i := m; i <= n; i++ {
        next := cur.Next
        cur.Next = pre
        pre = cur
        cur = next
    }
    mpre.Next.Next = cur //2.next=5
    mpre.Next = pre      //1.next=4
    return dummyNode.Next
}
