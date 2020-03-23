public class AddTwoNumbers2{
    public static void main(String[] args) {

    }
    
    //比较推荐的写法，简洁一点，在lc上提交区别不大
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode=new ListNode(-1);
        ListNode temp=dummyNode;
        dummyNode.next=temp;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum= (l1!=null?l1.val:0) + (l2!=null?l2.val:0)+ carry;
            temp.next=new ListNode(sum%10);
            temp=temp.next;
            carry=sum/10;
            l1=l1!=null?l1.next:null;
            l2=l2!=null?l2.next:null;
        }
        if(carry!=0) temp.next=new ListNode(1);
        return dummyNode.next;
    }

    //这个解法有点偏了,为了不new节点直接在原链表上修改的
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=l1;
        int carry=0;
        ListNode last=l1;
        while(l1!=null && l2!=null){
            int sum= l1.val + l2.val+ carry;
            l1.val=sum%10;
            carry=sum/10;
            last=l1;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null && carry!=0){
            int sum = l1.val + carry;
            l1.val=sum%10;
            carry=sum/10;
            last=l1;
            l1=l1.next;
        }
        if(l2!=null){
            last.next=l2;
            while(l2!=null && carry!=0){
                int sum = l2.val + carry;
                l2.val=sum%10;
                carry=sum/10;
                last=l2;
                l2=l2.next;
            }
        }
        if(carry!=0) last.next=new ListNode(1);
        return dummyNode.next;
    }
}