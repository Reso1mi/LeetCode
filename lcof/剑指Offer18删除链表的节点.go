/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
// func deleteNode(head *ListNode, val int) *ListNode {
//     dummyNode := &ListNode{Next: head}
//     temp := head
//     pre := dummyNode
//     for temp != nil {
//         if temp.Val == val {
//             pre.Next = temp.Next
//             break
//         }
//         pre = temp
//         temp = temp.Next
//     }
//     return dummyNode.Next
// }

func deleteNode(head *ListNode, val int) *ListNode {
    if head == nil {
        return nil
    }
    if head.Val == val {
        return head.Next
    }
    head.Next = deleteNode(head.Next, val)
    return head
}