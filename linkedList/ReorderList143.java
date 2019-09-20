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
        ListNode right = head;
        ListNode slow = head;
        // 1 1 1 1 1 1 1
        while (right.next != null) {
            right = right.next.next != null ? right.next.next : right.next;
            slow = slow.next;
        }
        // 从slow开始翻转
        res(slow);
        //左半部分
        ListNode left = head;
        //下一个节点
        ListNode rnext = right;
        ListNode lnext = left;
        // 1 2 3 4 5 6 7 8 
        // 1 8 2 7 3 6 4 5
        while (right != null && left != null) {
            // 要保存right的下一个节点 , left也需要,不然无法导航到下一个节点
            lnext = lnext.next;
            rnext = rnext.next;
            // 偶数个数节点,如果遍历到right链表的最后一个节点
            // 偶数的话right链表会短一点 最后连接的时候
            // left: 1->2->3->4->5 right: 8->7->6->5   
            // 像这样会将5加到left的4和5之间,但是明显只有一个5这样添加就是有问题的
            if(right.next==null){
                //所以这里吧lnext赋值为null,后面就不会重复连接5这个节点
                lnext=null;
            }
            //奇数个数的时候这样连接没问题
            // 1 2 3 4 5 
            // 9 8 7 6 5
            //5.next=5
            left.next = right;
            //如果奇数个数到最后这一步 right和left是同一个节点都为值是5的节点
            //所以这里下面的直接覆盖了上面的
            //5.next=null
            right.next = lnext;
            left = lnext;
            right = rnext;
        }
    }
    
    //反转
    public static void res(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        ListNode nex = node;
        while (cur != null) {
            nex = nex.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
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