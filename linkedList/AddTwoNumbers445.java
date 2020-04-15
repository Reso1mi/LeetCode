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

    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //用数组的话不知道有多长,需要多遍历两遍
        Deque<Integer> stack1=new ArrayDeque<>();
        Deque<Integer> stack2=new ArrayDeque<>();
        ListNode res=new ListNode(-1);
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        int carry=0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry>0){
            int temp=(stack1.isEmpty()?0:stack1.pop())+(stack2.isEmpty()?0:stack2.pop())+carry;
            ListNode next=res.next;
            ListNode newNode=new ListNode(temp%10);
            res.next=newNode;
            newNode.next=next;
            carry=temp/10;
        }
        return res.next;
    }

    int carry=0;

    //算了，打扰了，递归的太丑了，不写了
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1,len1=0,temp2=l2,len2=0;
        //寻找第一个交点类似的思想
        int count=0;
        while(temp1!=null && temp2!=null){
            temp1=temp1.next;
            if(temp1==null){
                temp1=l2;
                count++;   
            }
            temp2=temp2.next;
            if(temp2==null){
                temp2=l1;
                count++;
            }
            if(count==2) break;
        }
        ListNode head=
    }

    //1 2 3
    //2 9 1
    public ListNode add(ListNode l1, ListNode l2,int carry) {
        if(l1==null && l2==null){
            return 0;
        }
        int temp=l1.val+l2.val+carry;
        ListNode cur=new ListNode(temp%10);
        cur.next=add(l1.next,l2.next,temp/10);
        return cur;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}