public class MergeKLists23{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		System.out.println();
	}

	//非递归	 合并K路链表 最先想到的就是两个两个的归并一直归并下去直到归并完所有的链表
	//先试试 巨慢
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length==0)return null;
		ListNode temp=lists[0];
		for(int i=0;i<lists.length-1;i++){
			temp=merge2List(temp,lists[i+1]);
		}
		return temp;
	}


	//利用归并分冶思想 ---递归版本
	public ListNode mergeKLists2(ListNode[] lists) {
		if(lists.length==0)return null;
		return divide(lists,0,lists.length-1);
	}

	//非递归版本，方向不一样
	public ListNode mergeKLists3(ListNode [] lists){
		if (lists.length == 0) {
			return null;
		}
		int k = lists.length;
		while (k > 1) {
			for (int i = 0; i < k / 2; i++) {
                //两两合并
				lists[i] = merge2Lists(lists[i], lists[i + (k + 1) / 2]);
			}
			k = (k + 1) / 2;
		}
		return lists[0];
	}


	public static ListNode divide(ListNode[] lists,int left,int right){
		if(left>=right)return lists[left];
		int mid=left+((right-left)>>1);
		ListNode l = divide(lists,left,mid);
		ListNode r = divide(lists,mid+1,right);
		return merge2List(l,r);
	}



	public static ListNode merge2List(ListNode headA,ListNode headB){
		if(headA==null)return headB;
		if(headB==null)return headA;
		ListNode dummyNode=new ListNode(-1);
		ListNode res=dummyNode;
		ListNode tempA=headA;
		ListNode tempB=headB;
		while(tempB!=null&&tempA!=null){
			if(tempB.val>tempA.val){
				res.next=tempA;
				tempA=tempA.next;
			}else{
				res.next=tempB;
				tempB=tempB.next;
			}
			res=res.next;
		}
		res.next=tempA==null?tempB:tempA;
		return dummyNode.next;
	}


	//小根堆的方法
	public ListNode mergeKLists4(ListNode[] lists) {
        //利用一个按节点值最小次序排列的优先队列, 每次取最小的节点加入返回链表中, 
        //并将最小节点的下一个节点再加入队列中, 注意非null判断, 复杂度O(NKlogK)
		if(lists.length < 1) return null;
		Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));  
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for(ListNode p : lists){
			if(p != null)
				pq.offer(p);
		}
		while(!pq.isEmpty()) {
			cur.next = pq.poll();
			cur = cur.next;
			if(cur.next != null)
				pq.offer(cur.next);
		}
		return head.next;
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