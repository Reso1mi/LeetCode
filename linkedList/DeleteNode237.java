public class DeleteNode237{
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
		ListNode temp=node3;
		node3=node2;
		node2=temp;
		System.out.println(node2.val+","+node2.next.val);
		printList(head);
	}


	//愚蠢的做法
	//怎么这么蠢？？？？
	public  static void deleteNodelow(ListNode node) {
        //思路就是和node后面的元素一直交换，就像冒泡排序一样
        ListNode next;
        ListNode temp=new ListNode(0);
        ListNode pre=temp;
        while(node.next!=null){
        	next=node.next;
        	if(node.next.next==null){
        		pre=node;
        	}
        	//先保存最后一个节点前的节点
        	//交换当前节点和后一个节点
        	temp.val=node.val;
        	node.val=next.val;
        	next.val=temp.val;
        	node=next;
        }
        pre.next=null;
    }

    //哎。。。。。。。。。。。。。。。。。。。。。。
    public  static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
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