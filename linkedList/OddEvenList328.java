public class OddEvenList328{
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
		printList(oddEvenList(head));
	}

	//奇偶链表
	public static ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null||head.next.next==null)return head;
		// 1 2 3 4 5 6 7
		// 1 2 3 4 5 6
		ListNode pOdd=head;
		ListNode pEven=head.next;
		ListNode temp=pEven;
		while(pEven!=null&&pEven.next!=null){
			pOdd.next=pEven.next;
			//奇数先走
			pOdd=pOdd.next;
			pEven.next=pOdd.next;
			pEven=pEven.next;
		}
		pOdd.next=temp;
		return head;
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