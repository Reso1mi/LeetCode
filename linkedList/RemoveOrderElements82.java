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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        if(head.val==head.next.val){
            while(head!=null && head.next!=null && head.val==head.next.val){
                head=head.next;
            }
            return deleteDuplicates(head.next); //去重
        }
        head.next=deleteDuplicates(head.next);
        return head;
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