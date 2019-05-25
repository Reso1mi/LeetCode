public class SortList148{
	public static void main(String[] args) {
		ListNode head=new ListNode(3);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(7);
		ListNode node4=new ListNode(23);
		ListNode node5=new ListNode(3);
		ListNode node6=new ListNode(-1);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		printList(head);
		printList(sortList2(head));
	}


	//归并排法
	public static  ListNode sortList(ListNode head) {
		if(head==null||head.next==null)return null;
		return mergeSort(head);
	}

	public static ListNode mergeSort(ListNode head){
		if(head.next==null){
			return head;
		}
		ListNode fast=head;
		ListNode slow=head;
		ListNode pre=head;
		while(fast!=null&&fast.next!=null){
			pre=slow;
			fast=fast.next.next;
			slow=slow.next;
		}
		pre.next=null; //这里要注意断开两条链表不然后面不方便找中点
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(slow);
		return merge2list(left,right);
	}


	public static ListNode merge2list(ListNode headA,ListNode headB){
		if(headA==null)return headB;
		if(headB==null)return headA;
		ListNode dummyNode=new ListNode(-1);
		dummyNode.next=headA;
		ListNode temp=dummyNode;
		while(headA!=null&&headB!=null){
			if(headA.val>headB.val){
				temp.next=headB;
				headB=headB.next;
			}else{
				temp.next=headA;
				headA=headA.next;
			}
			temp=temp.next;
		}
		temp.next=headA==null?headB:headA;
		return dummyNode.next;
	}


	public static ListNode sortList2(ListNode head){
		if(head==null||head.next==null)return head;
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next=head;
		partion(dummyNode,null);
		return head;
	}

	//快排实现
	/*public static void sortList2(ListNode head,ListNode tail) {
		if(tail==head){
			return;
		}
		//确定枢纽元素
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next=head;
		ListNode []base=partion(dummyNode,tail);
		printList(dummyNode);
		sortList2(dummyNode,base[0]);
		sortList2(base[1],tail);
	}*/

	//看了下别人的博客也学到了一种快排的新思路
	//慢指针左边都是小于base枢纽元素的，快指针和慢指针中间都是大于等于base枢纽元素的，慢指针后面的都是未知区域
	public static void partion(ListNode head,ListNode tail){
		if(head.next==null||head.next.next==null||head.next==tail||head.next.next==tail){
			return;
		}
		int base=head.next.val;
		ListNode fast=head.next.next;
		ListNode slow=head; 	//切分点(等于区左分界线)
		ListNode equal=head.next; 		//等于区右分界线
		// 3 | 2  4  5 3  1  3  2  5
		ListNode fastPre=head;
		while(fast.next!=tail){ //左开右开
			if(fast.next.val<base){
				ListNode fastNext=fast.next.next;
				ListNode slowNext=slow.next;
				//切分点后插入节点
				slow.next=fast.next;
				fast.next.next=slowNext;
				fast.next=fastNext;
				slow=slow.next;
				//上面那一步fast已经向后走了
				//fast=fastNext;
			}else if(fast.next.val==base){
				if(equal==fast){
					equal=fast.next;
					fast=fast.next;
				}else{
					ListNode fastNext=fast.next.next;
					ListNode equalNext=equal.next;
					//等于区点后插入节点
					equal.next=fast.next;
					fast.next.next=equalNext;
					fast.next=fastNext;
					equal=equal.next;
				}
			}else{
				fast=fast.next;
			}
		}
		partion(fast,slow.next);
		partion(equal,tail);
	}


	//我自己写的快排
	public static ListNode sortList4(ListNode head){
		if(head==null||head.next==null)return head;
		 sortList(head,null);
		 return head;
	}

	//快排实现
	public static void sortList(ListNode head,ListNode tail) {
		if(tail==head){
			return;
		}
		//确定枢纽元素
		ListNode base=partion(head,tail);
		sortList(head,base);
		sortList(base.next,tail);
	}

	//看了下别人的博客也学到了一种快排的新思路
	//慢指针左边都是小于base枢纽元素的，快指针和慢指针中间都是大于等于base枢纽元素的，慢指针后面的都是未知区域
	public static ListNode partion(ListNode head,ListNode tail){
		ListNode base=head;
		ListNode fast=head.next;
		ListNode slow=head;
		// 3  1  3  2  5  -1 0
		//    s  f
		while(fast!=tail){
			if(fast.val<=base.val){
				//交换两个节点的值
				swap(fast,slow.next);
				slow=slow.next;
			}
			fast=fast.next;
		}
		//归位
		swap(head,slow);
		//应该可以试试返回区间
		return slow;
	}
    
    public static void swap(ListNode a,ListNode b){
		int temp=a.val;
		a.val=b.val;
		b.val=temp;
	}


	
    //3 1 2 5 4 6 9 7 10 8
    // (from,to)左开,右开区间
    //二分法 
    //观摩下是什么神仙写的
    //三向切分的快排，厉害
	public static ListNode sortList3(ListNode head) {
		ListNode node = new ListNode(0);
		node.next = head;
		sort(node, null);
		return node.next;
	}

	private  static void sort(ListNode from, ListNode to) {
		if (from == null || from == to || from.next == to || from.next.next == to) return;
        int v = from.next.val; //基准元素
        ListNode mid = from;   //切分点
        ListNode equal = from.next; //等于区域
        ListNode node = from.next;	//遍历用的指针
        while (node.next != to) { //node不到头
            if (node.next.val < v) {//小于基准位置元素
            	//保存当前节点的下一个元素，用于插入节点
            	//小于基准元素的节点
            	ListNode currentNext = node.next.next;
                //保存切分点的下一个元素，作用同上
            	ListNode midNext = mid.next;
                //交换node.next和mid
                //纸上画一下就了解了
            	mid.next = node.next;
            	node.next.next = midNext;
            	node.next = currentNext;
                //切分点后移
            	mid = mid.next;
            } else if (node.next.val == v) {
            	//node的下一个等于基准元素
            	//3 1 2 3 4 5 6
            	if (equal == node) {
                	//等于区域和node.next==val相邻了，直接跳过
            		equal = node.next;
            		node = node.next;
            	} else {
                	//交换node.next和equal
                	//然后equal向后移动
                	//和上面的类似
            		ListNode nodeNext = node.next.next;
            		ListNode equalNext = equal.next;
            		equal.next = node.next;
            		node.next.next = equalNext;
            		node.next = nodeNext;
            		equal = equal.next;

            	}
            } else {
            	//大于直接跳过
            	node = node.next;
            }
        }
        sort(from, mid.next);
        sort(equal, to);
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