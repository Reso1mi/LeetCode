public class RotateRight61{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		printList(head);
		System.out.println(rotateRight(head));
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if(head==null||head.next==null){
			return head;
		}
        //先获取下链表的长度
		ListNode temp=head;
		ListNode tail=head;
		int length=0;
		while(temp!=null){
			length++;
			if(temp.next==null){
				tail=temp;
				break;
			}
			temp=temp.next;
			
		}
        //将K化简
		k=k%length;
        //System.out.println(k);
		if(k==0) return head;
		temp=head;
		int count=0;
        //然后再遍历一遍链表在 length-k 的地方断开
		while(temp!=null){
			if(count==(length-k-1)){
				tail.next=head;
				head=temp.next;
				temp.next=null;
				return head;
			}
			count++;
			temp=temp.next;
		}
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