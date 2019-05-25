public class SplitListNode725{
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
		System.out.println("-------------------------------");
		ListNode []result=splitListToParts(head,3);
		for (int i=0;i<result.length;i++) {
			 printList(result[i]);
			 System.out.println("---------");
		}
	}

	//切割链表
	public static ListNode[] splitListToParts(ListNode root, int k) {
		//感觉先要获取下链表的长度
		ListNode temp=root;
		ListNode next=root;
		ListNode [] result=new ListNode[k];
		int count=0;
		while(temp!=null){
			temp=temp.next;
			count++;
		}
		temp=root;
		//任意两部分差距不能大于1，大的在前，小的在后面
		//其实就是对count进行分配
		//注意: 有null的情况一定是 k>count 直接按 1 切分就完事了
		//k<count的情况只要在 count/k 的前几个元素上加上 count/k 的余数就行了
		int size=count/k;
		int num=count%k;
		result[0]=root;
		int index=1;
		 if(k<=count){
		    for(int i=1;temp!=null && index < k;i++){
		    	next=temp.next;
		    	if(i<=(size+1)*num && i%(size+1)==0){
		    		//前几个res的分割点
		    		result[index++]=next;
		    		//切断
		    		temp.next=null;
		    	}else if(i>(size+1)*num && (i-num)%size==0){
		    		result[index++]=next;
		    		temp.next=null;
		    	}
				temp=next;
			}
		}else{
		   //剩下的情况就是后面要补null的情况
			// 这里两种情况应该是可以合并的，但是k>count num>0 懒得去抠边界
		   for(int i=1;i<k;i++){
		   		if(temp==null){
		   			//这个if其实没必要
		   			result[i]=null;
		   		}else{
		   			next=temp.next;
		   			result[i]=next;
		   			temp.next=null;
		   			temp=next;
		   		}
		   }
		}
		return result;
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