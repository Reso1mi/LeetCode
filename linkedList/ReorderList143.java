/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList143 {

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
		reorderList(head);
		printList(head);
	}

	public static void reorderList(ListNode head) {
		if(head==null){
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		// 1 1 1 1 1 1 1
		while (fast.next != null) {
			fast = fast.next.next != null ? fast.next.next : fast.next;
			slow = slow.next;
		}
		// 从slow开始翻转
		res(slow);
		ListNode temp = head;
		ListNode fnext = fast;
		ListNode tnext = temp;
		// 1 2 3 4 5 6 7 8 
		// 1 8 2 7 3 6 4 5
		
		//奇数个数的时候这样连接没问题
		// 1 2 3 4 5 
		// 9 8 7 6 5
		//最后是同一个元素就不用管了直接不考虑
		while (fast != null && temp != null) {
			// 要保存fast的下一个节点 , temp也需要 不然寻不到第二个节点
			tnext = tnext.next;
			fnext = fnext.next;
			// 偶数如果是fast链表的最后一个节点了
			// 偶数的话fast链表会短一点 由于最后连接的时候
			// temp: 1 2 3 4 5
			// fast: 8 7 6 5   像这样会将5加到temp 4和5之间就有问题了
			if(fast.next==null){
				tnext=null;
			}
			temp.next = fast;
			//如果奇数个数到最后这一步 fast和temp是同一个节点
			//所以这里下面的直接覆盖了上面的
			fast.next = tnext;
			temp = tnext;
			fast = fnext;
		}
	}
    
    //反转
    public static void res(ListNode node) {
		ListNode pre = null;
		ListNode cur = node;
		ListNode next = node;
		while (cur != null) {
			next = next.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
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