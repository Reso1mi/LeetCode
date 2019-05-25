public class InsertSortList147{
	public static void main(String[] args) {
		ListNode head=new ListNode(-2147483647);
		ListNode node1=new ListNode(-2147483648);
		/*ListNode node2=new ListNode(6);
		ListNode node3=new ListNode(5);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(3);
		ListNode node6=new ListNode(2);*/
		head.next=node1;
		/*node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;*/
		printList(head);
		printList(insertionSortList(head));
	}

	//beat 70% 开始少写了一个if判断
	public static  ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null)return head;
    	//哑节点
		ListNode dummyNode=new ListNode(Integer.MIN_VALUE);
		System.out.println(dummyNode.val);
		dummyNode.next=head;
		ListNode tempNode=head;
		//外循环内的指针
		ListNode loopVariable=head.next;
		ListNode loopPre=head;
		//内循环的指针
		ListNode tempPre=dummyNode;
		while(loopVariable!=null){
			//头插法
			if(loopVariable.val<loopPre.val){				
				for(tempNode=dummyNode;tempNode!=loopVariable;tempNode=tempNode.next){
					if(tempNode.val>loopVariable.val){
						//System.out.println(loopVariable.val);
						//printList(dummyNode.next);
						//先处理好loopVariable的前后节点
						loopPre.next=loopVariable.next;
						//再处理tempNode前后的节点
						loopVariable.next=tempNode;
						tempPre.next=loopVariable;
						//loopVariable 归位
						loopVariable=loopPre;
						break;
					}
					tempPre=tempNode;
				}
			}
			loopPre=loopVariable;
			loopVariable=loopVariable.next;
		}
		return dummyNode.next;
	}

	//beat80%
	public ListNode insertionSortList2(ListNode head) {
		if(head==null || head.next==null){
			return head;
		}
		ListNode fake=new ListNode(-1);
		fake.next=head;
		ListNode pre=head;
		ListNode cur=head.next;
		while(cur!=null){
			ListNode next=cur.next;
			if(cur.val<pre.val){
				ListNode pre2=fake;
				ListNode cur2=fake.next;
				while(cur.val>cur2.val){
					pre2=cur2;
					cur2=cur2.next;
				}
				pre2.next=cur;
				cur.next=cur2;
				pre.next=next;
			}else{
				pre=cur;
			}
			cur=next;
		}
		return fake.next;
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