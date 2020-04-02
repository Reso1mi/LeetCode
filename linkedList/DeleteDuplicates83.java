public class DeleteDuplicates83{
    public static void main(String[] args) {

    }

    //递归
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode node=deleteDuplicates(head.next);
        if(head.val==node.val) {
            head.next=node.next;
        }
        return head;
    }

    //迭代
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null){
            if (temp.next == null){
                break;
            }
            if (temp.next.val == temp.val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }

        }
        return head;
    }
}