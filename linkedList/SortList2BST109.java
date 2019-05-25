public class SortList2BST109{
	public static void main(String[] args) {
		
	}

	public TreeNode sortedListToBST(ListNode head) {
		return build(head,null);
	}

	public static TreeNode build(ListNode head,ListNode tail){
		if(head==tail){return null;}
    	//快慢指针找中点
		ListNode fast=head,slow=head;
        while(fast!=tail&&fast.next!=tail){ //左闭右开
        	fast=fast.next.next;
        	slow=slow.next;
        }
        //slow为中点或中点后一个
        //1 2 3 4
        TreeNode root=new TreeNode(slow.val);
        root.left=build(head,slow);
        root.right=build(slow.next,tail);
        return root;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}