import java.util.Stack;
import java.math.BigInteger;
public class AddTwoNumbers445{
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
		//System.out.println(list2num(head));
		printList(addTwoNumbers(head,head));
	}


	/*
		偷懒一下 和第一题其实差不多（进阶的意思可能就是用栈，也就是抠边界的过程）   评论里面大多是反转链表或者利用栈
	*/
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		BigInteger b1 = new BigInteger(list2num(l1));
        BigInteger b2 = new BigInteger(list2num(l2));
    	String resStr=b1.add(b2).toString();
		//再变成字符串存到连表里面
    	ListNode res=new ListNode(1);
    	ListNode real=res;
    	for (int i=0;i<resStr.length();i++) {
    		real.next=new ListNode(Integer.valueOf(resStr.charAt(i)-48));
    		real=real.next;
    	}
		return res.next;
    }

    public static String  list2num(ListNode l){
    	String num="";
    	while(l!=null){
    		num=num+l.val;
    		l=l.next;
    	}
    	return num;
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