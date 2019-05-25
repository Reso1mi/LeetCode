public class HasCycle141{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		printList(head);
		System.out.println(hasCycle(head));
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
              return false;
	   //快慢指针 相遇的时候快指针回到头部step改为1 再次相遇的时候就是环的pos
	   //这题只是判断有没有环所以只要相遇就有环
		ListNode slow=head;
		ListNode fast=head.next;
		while(slow!=fast){
			//有环是不会走到尽头的
			if(fast.next==null || fast.next.next==null){				
				return false;
			}
			fast=fast.next.next;
			slow=slow.next;
		}
		return true;
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