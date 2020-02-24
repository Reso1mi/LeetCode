public class ReverseKGroup25{
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
        printList(reverseKGroup(head,7));
    }

    //非递归    理一下思路： 记录每次翻转前后的节点 然后翻转返回头 将每 K 个元素当成一个整体
    public static ListNode reverseKGroup(ListNode head,int k) {
        if(head==null||head.next==null)return head;
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode pre=dummyNode;
        ListNode cur=head;
        ListNode next=head;

        ListNode temp;
        while(next!=null){
            //temp 保存 cur 方便后面连接  K+1位置的元素
            temp=cur;
            //k 个一组翻转
            int step=k;
            while(step>0 && next!=null){
                //next走到 K+1 位置节点
                next=next.next;
                step--;
                //小细节 k>链表长度时应该直接返回（我认为）等下提交了看看
                //所以直接应该直接返回 (掉了k的值判断 因为有可能刚好有k个元素)
                if(next==null&& step!=0){
                    return dummyNode.next;
                }
            }
            //翻转 cur--next.prev 返回头节点
            //连接 反转后的头节点
            pre.next=reverse(cur,k);
            temp.next=next;
            //pre temp向后移动
            pre=temp;
            cur=next;
        }
        return dummyNode.next;
    }
    
    // -1| 1 2 3 | 4 5 6 | 7 8
    //翻转链表并返回子链表
    public static ListNode reverse(ListNode node,int k){
        ListNode pre=null;
        ListNode cur=node;
        ListNode next=node;
        while(k>0&&next!=null){
            next=next.next;
            cur.next=pre;
            pre=cur;
            cur=next;
            k--;
        }
        //返回反转后的头节点
        System.out.println("头"+pre.val);
        return pre;
    }

    //递归
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        int canProceed = 0;
        int count = 0;
        // 检查链表长度是否满足翻转
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        // 满足条件，进行翻转
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) {
                // head 为链表翻转后的尾节点
                head.next = reverseKGroup(next, k);
            }
            // prev 为链表翻转后的头结点
            return prev;
        } else {
            // 不满住翻转条件，直接返回 head 即可
            return head;
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

    //时隔一年,回头自己写了一个递归的解法
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1) return head;
        int sum=0;
        ListNode temp=head;
        //预先计算链表的长度
        while(temp!=null){
            temp=temp.next;
            sum++;
        }
        return reverse(head,k,sum);
    }

    public ListNode reverse(ListNode head, int k,int remain) {
        if(remain<k) return head; //ramain不足k个return 
        if(head==null) return head;
        //正常的翻转操作
        ListNode cur=head,pre=null,last=head;
        int count=k;
        while(count-- >0){
            last=cur.next;
            cur.next=pre;
            pre=cur;
            cur=last;
        }
        //下一次从last开始翻转,remain-k
        head.next=reverse(last,k,remain-k);
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}