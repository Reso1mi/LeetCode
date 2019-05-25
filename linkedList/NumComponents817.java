public class NumComponents817{
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(2);
		head.next=node1;
		System.out.println();
	}

	//组件必须是链表里面连续的最长子链 G[]
	//在纸上画了画，有了一个简单的思路 只要将链表和 G一一对应然后看还剩下。。。不对链表是无序的
	//新思路 就直接暴力点，遍历链表遇到==G的元素就向后走走一个就在G中删一个（会更耗时）
	//91ms 19% 。。。。着实有点慢了
	//瞄了一眼最快的，看见了一个boolean的数组貌似是记录节点在不在G中？有了这个数组就不用每次都判断了
	//但是这个数组怎么生成呢？链表也是无序的。
	public int numComponents(ListNode head, int[] G) {
		ListNode temp=head;
		int res=0;
		while(temp!=null){
			if(isInG(temp.val,G)){
				while(temp!=null&&isInG(temp.val,G)){
					temp=temp.next;
				}
				res++;
				if(temp==null){
					return res;
				}
			}
			temp=temp.next;
		}
		return res;
	}

	public int numComponents2(ListNode head, int[] G) {
		ListNode temp=head;
		int res=0;
		boolean [] isInG=new boolean[10000];
		int j=0;
		while(temp!=null){
			for(int i=0;i<G.length;i++){
				if(G[i]==temp.val){
					isInG[j]=true;
					break;
				}
			}
			j++;
			temp=temp.next;
		}
		temp=head;
		for(int i=0;temp!=null;temp=temp.next,i++){
			if(isInG[i]){
				while(temp!=null&&isInG[i]){
					temp=temp.next;
					i++;
				}
				res++;
				if(temp==null){
					return res;
				}
			}
		}
		return res;
	}

	//再优化
	public int numComponents3(ListNode head, int[] G) {
		ListNode temp=head;
		int res=0;
		boolean [] isInG=new boolean[10000];
		int j=0;
		//换一种方式 以node.val作为数组的下标
		for(int i:G){
			isInG[i]=true;
		}
		while(temp!=null){
			if(isInG[temp.val]){
				while(temp!=null&&isInG[temp.val]){
					temp=temp.next;
				}
				res++;
				if(temp==null){
					return res;
				}
			}
			temp = temp.next;
		}
		return res;
	}

	public static boolean isInG(int val,int[] G){
		for(int i=0;i<G.length;i++){
			if(G[i]==val){
				return true;
			}
		}
		return false;
	}
    //print链表
	public static void printBoolean(boolean []l){
		for(int i=0;i<l.length;i++){
			System.out.println(l[i]);
		}
	}
}
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}