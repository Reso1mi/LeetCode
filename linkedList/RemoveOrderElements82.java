/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveOrderElements82 {

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(4);
		ListNode node4=new ListNode(5);
		ListNode node5=new ListNode(6);
		ListNode node6=new ListNode(6);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		printList(head);
		ListNode res=deleteDuplicates(head);
		printList(res);

	}


    public  static ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        //首先想到的思路是3指针，然后遍历的过程中后面的指针遇到==val的情况就让后面的指针一直后移走到！=val
        //先添加个哑节点
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode cur=head;
        ListNode next=head.next;
        ListNode pre=dummyNode;
        while(next!=null){
            while(next.val==cur.val){
                next=next.next;
                if(next==null){
                    pre.next=null;
                    return dummyNode.next;
                }
                if(next.val!=cur.val){
                    pre.next=next;
                    //cur跟上
                    cur=next;
                   break;
                }
            }
            //关键就是pre移动这里有坑
            pre=cur.next!=null&&cur.val==cur.next.val?pre:cur;
            cur=next;
            next=next.next;
        }
        return dummyNode.next;
    }

    //递归
    public static ListNode removeElements2(ListNode head, int val){
    	 if (head == null)
    		 return null;
    		//一直向后移动从头开始 , 如果==val就看return里面的 直接返回下一个作为头节点忽略==val的
 			head.next = removeElements2(head.next, val);
 		return head.val == val ? head.next : head;
    }

    public static void deleNode(ListNode cur,ListNode next){
    	cur.val=next.val;
    	cur.next=next.next;
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