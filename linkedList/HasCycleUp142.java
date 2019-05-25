public class HasCycleUp142{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		printList(head);
		System.out.println(hasCycle(head));
	}

	public static ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null){
			return null;
		}
		ListNode fast=head;
		ListNode slow=head;
		boolean isMeet=false;
		//快指针没有到尽头
		while(fast!=null&&fast.next!=null){
			fast=isMeet?fast.next:fast.next.next;
			slow=slow.next;
			if(fast==slow){
				if(!isMeet){
					//第一次相遇
					//我这种写法开始没考虑到这种情况,入环节点就是头节点就不能继续走了
					if(fast==head)return;
					fast=head;
					isMeet=true;
				}else{
					return fast;
				}
			}
		}
		return null;
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