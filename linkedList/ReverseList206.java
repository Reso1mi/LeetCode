public class ReverseList206{
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
        ListNode node5=new ListNode(6);
        ListNode node6=new ListNode(7);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=null;
        printList(head);
        printList(reverseList(head));
    }

    //递归版本
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        //翻转相邻的两个节点
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //三指针迭代
    public static ListNode reverseList2(ListNode head) {
        if(head==null)return head;
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode temp;
        while(cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        head.next=null; 
        return pre; 
    }

    public static void printList(ListNode l){
        while(l!=null){
            System.out.print(l.val+" , ");
            l=l.next;
        }
        System.out.println();
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}