//UPDATE：2020.9.7 实行重写所有链表题的计划
// A-->B-->C-->D   B为入环点，D为相遇点，相遇时slow = AD, fast = AD+DB+BD
// fast = 2*slow ==> AD = DB + BD ==> AB+BD = DB+BD ==> AB = DB
func detectCycle(head *ListNode) *ListNode {
    var fast, slow = head, head
    for fast!=nil && fast.Next!=nil {
        fast = fast.Next.Next
        slow = slow.Next
        if fast == nil { //无环
            return nil
        }
        if fast == slow { //有环，next一定不为null
            for head!=fast {
                head = head.Next
                fast = fast.Next
            }
            return head
        }
    }
    return nil
}