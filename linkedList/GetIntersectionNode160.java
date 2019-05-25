/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class GetIntersectionNode160 {

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(1);
		ListNode node4=new ListNode(1);
		ListNode node5=new ListNode(1);
		ListNode node6=new ListNode(1);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;

		ListNode head2=new ListNode(2);
		head2.next=node2;

		ListNode res= getIntersectionNode2(head,head2);
		printList(res);
		ListNode temp=head;
	}

	//方法一
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	ListNode pA=headA;
    	ListNode pB=headB;
    	//计算两个链表长度然后计算差距然后向后对齐
    	int lenA=0;
    	int lenB=0;
    	while(pA!=null){
    		pA=pA.next;
    		lenA++;
    	}
    	while(pB!=null){
    		pB=pB.next;
    		lenB++;
    	}
    	int dis=lenB>lenA?lenB-lenA:lenA-lenB;
    	if(lenB>lenA){
    		while(dis-->0){
    			headB=headB.next;
    		}
    	}else{
    		while(dis-->0){
    			headA=headA.next;
    		}
    	}
    	//不相等就一直向后移
    	while(headA!=headB){
    		//如果有一条为空说明没有交点
    		if(headA.next==null){
    			return null;
    		}
    		headA=headA.next;
    		headB=headB.next;
    	}
    	return headA;
    }

    //方法二 
     public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
     	//当一个指针到结尾时转到另一个链表头再向后移动 ，这样做的目的和就是可以直接消除链表之间的长度差，向后对齐，方法还是很巧妙的。
     	ListNode pA=headA;
     	ListNode pB=headB;
     	if(headB==null || headA==null)
     		return null;
     	//while(pA!=null && pB!=null ){
     	while(pA!=pB){
     		//要保证两个==null的时候都只能执行一次不然如果没有交点就会死循环
     		//改变while的条件
     		//改变pA，pB跳转的条件
     		//这样就可以保证最后没交点的时候 第二遍循环pA和pB最后会同时等于null会有出口不会死循环
     		pA=pA==null?headB:pA.next;
     		pB=pB==null?headA:pB.next;
     	}
     	return pA;
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