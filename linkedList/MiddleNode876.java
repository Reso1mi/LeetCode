public class MiddleNode876{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		printList(head);
		System.out.println(hasCycle(head));
	}

	public static ListNode middleNode(ListNode head) {
		if(head==null||head.next==null)return head;
        ListNode fast=head;
        ListNode slow=head;
        // 1 2 3 4 5 6 7
        while(fast!=null&&fast.next!=null){
        	fast=fast.next.next;
        	slow=slow.next;
        }
        return slow;
    }

    //print链表
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