/*
	反转链表2
*/
public class ReverseLinkedList92{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		ListNode node2=new ListNode(3);
		ListNode node3=new ListNode(4);
		ListNode node4=new ListNode(5);
		ListNode node5=new ListNode(6);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=null;
		printList(head);
		printList(reverseBetween(head,2,6));
	}

	public static void printList(ListNode l){
		while(l!=null){
			System.out.print(l.val+" , ");
			l=l.next;
		}
		System.out.println();
	}


	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n){
			return head;
		}
		//用来遍历
		ListNode pre=head;
		ListNode mid=head.next;
		ListNode rear=null;

		//在遍历的中间连接这个表 时间复杂厚度O(N)
		//所以需要先保存 m前的节点用于后面到n的时候连接n和前面的部分 preM
		//还要保存m节点，在后面遍历到n的时候将M节点和后面的部分连接
		//中间段的前后节点 
  		ListNode preM =null;
  		ListNode valM=head;				
  		//ListNode nNext=null;
  		int count =1;
  		while(count <=n-1){
  			//count的位置实际上是指的pre的位置因为只有pre是从head开始走的
  			//尾指针后移
  			rear=mid.next;
  			if(count==m-1){
  				//保存M点前面的节点和M节点
  				preM=pre;
  				valM=mid;
  				//System.out.println("preM :"+preM.val);
  			}
  			if(count==n-1){
  				//连接n后面节点的值
  				valM.next=rear;
  				//在这里判断下m前有没有元素
  				if(m==1){
  					head=mid;
  				}else{
  					preM.next=mid;	
  				}
  			}
  			if(count >= m && count <=n-1){
  				//只有mid的位置大于m小于等于n才会将节点next域反转
  				mid.next=pre;
  			}
  			//其他两个指针也向后移动
  			pre=mid;
  			mid=rear;
  			count++;
  		}
  		return head;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}