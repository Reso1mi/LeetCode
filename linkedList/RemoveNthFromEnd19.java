public class RemoveNthFromEnd19{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		printList(head);
		System.out.println(hasCycle(head));
	}

	//一趟扫描
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null&&head.next==null) return null;
		//双指针 主要是头和尾的删除需要抠一下边界
		//  -1 | 1 2 3 4 5 6
		ListNode fast=head;
		ListNode dummyNode=new ListNode(-1);
		dummyNode.next=head;
		ListNode slow=dummyNode;
		//加了哑节点，直接先加1
		int count=1;
		while(fast!=null){
			fast=fast.next;
			slow=count<n?slow:slow.next;
			count++;
			if(fast.next==null){
				//slow到达需要删除的位置的前一个
				slow.next=slow.next.next;
				return dummyNode.next;
			}
		}
		return dummyNode.next;
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