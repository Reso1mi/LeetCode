/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
	删除链表中等于给定值 val 的所有节点。
	示例:
	输入: 1->2->6->3->4->5->6, val = 6
	输出: 1->2->3->4->5
*/
public class RemoveElements203 {

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(1);
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
		printList(head);
		ListNode res=removeElements(head,1);
		printList(res);

	}


    public static ListNode removeElements(ListNode head, int val) {
 		//首先想到的是遍历，保存当前节点前后的节点然后连接
 		//但是类似下面的写法就欠缺了两种情况
 		//1.头节点为待删除的值 2.有连续的待删除的值总会留下一个（当前节点的下一个相同的值会保留2下来，其实只要再执行一次这个函数就可以了但是感觉不太好）
 		//----这题是有返回值的也就是说可以用一些奇怪的方法但是这肯定不是这题的愿意而且效率肯定比较低---
        

     // ############这个版本解决了第二个问题，每次直接把相同的那一串链表删除
       /* ListNode pre=head;
    	ListNode next=head;
    	ListNode cur=head;
    	while(cur!=null){
    		next=next.next;
    		while(cur.val==val){
    			if(cur.next.val!=val){
    				pre.next=cur.next;
    				break;
    			}
    			cur=cur.next;
    		}
    		pre=cur;
    		cur=next;
    	}
    	return head;*/


	// ##########突然想起来之前做的一道LeetCode 也是删除节点 -237  所以上面的问题1 就解决了 问题2仍然存在
    // 可以结合第一种的思路 delete链表 传递两个参数

    //发现了新的问题 ：最后一个也是==val
    	if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        //再头接待你之前加了新的节点
        dummyHead.next = head;
        ListNode pre = dummyHead, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
            	//不是相等的值就向后移动
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyHead.next;
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