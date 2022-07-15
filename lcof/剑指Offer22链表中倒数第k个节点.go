/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getKthFromEnd(head *ListNode, k int) *ListNode {
    fast := head
    slow := head

    for k > 0 && fast != nil {
        fast = fast.Next
        k--
    }

    for fast != nil && slow != nil {
        fast = fast.Next
        slow = slow.Next
    }
    return slow
}