public class SwapPairs24{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		System.out.println();
	}

	//非递归	
	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)return head;
		ListNode dummyNode=new ListNode(-1);
		dummyNode.next=head;
		ListNode fast=head.next;
		ListNode slow=head;
		ListNode slowPre=dummyNode;
		// 1 2 3 4
		while(fast!=null){
			slowPre.next=fast;
			slow.next=fast.next;
			fast.next=slow;
			slowPre=slow;
			//这里要判断下
			if(slow.next==null){
				return dummyNode.next;
			}
			slow=fast.next.next;
			fast=slowPre.next.next;

		}
		return dummyNode.next;
	}

	//递归版本
	public ListNode swapPairs2(ListNode head){
		 if(head==null||head.next==null){
		 	return head;
		 }
		 ListNode next=head.next;
		 head.next=swapPairs2(next.next);
		 next.next=head;
		 return next;
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