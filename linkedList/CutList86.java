public class CutList86{
	public static void main(String[] args) {
	
	}

	public ListNode partition(ListNode head, int x) {
        //先在头部加一个dummy节点统一操作
		ListNode dummyNode=new ListNode(-1);
		dummyNode.next=head;
		//分割点
		ListNode pre=cutNode=dummyNode;
		ListNode cur=head;
		int cut=0;
		while(cur!=null){
			if(cur.val>=x&&cut==0){
				//只会执行一次在找到第一个val>=x的节点的时候---保存分割点
				cutNode=pre;
				cut=1;
			}else if(cur.val<x && cut==1){
				//找到分割点后 遍历到val<x的节点的情况---将cur连接到cutNode的后面 处理好cur相邻的两个节点
				//先处理好cur相邻的节点
				pre.next=cur.next;
				//连接cutNode
				cur.next=cutNode.next;
				cutNode.next=cur;
				//cutNode后移
				cutNode=cur;
			}
			pre=cur;
			cur=cur.next;
		}
		return dummyNode.next
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}