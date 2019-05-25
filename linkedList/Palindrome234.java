/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
	可以用栈但是题目要求空间复杂度为O(1) 所以就额直接反转,反转的时候如果直接全部反转需要额外的空间来保存原来的链表
	所以可以只反转一半，也就是反转后半部分，然后对比。
*/
public class Palindrome {
	
	public static void main(String[] args) {
		
	}

       public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        // 利用快慢指正找到中点
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null) {
			fast = fast.next.next == null ? fast.next : fast.next.next;
			slow = slow.next;
		}
		// slow如果是偶数就是后面的那个 奇数就是正中间的
		// fast是结尾 1 1 1 1 1 1
		resverList(slow);
		// check
		while (fast != null && head != null) {
			if (fast.val != head.val) {
				return false;
			}
			fast = fast.next;
			head = head.next;
		}
		return true;
        
    }
    
    public static void resverList(ListNode node) {
		ListNode cur = node;
		ListNode pre = null;
		ListNode next = node;
		while (cur != null) {
			next = next.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
	}
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}