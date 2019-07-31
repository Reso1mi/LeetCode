import java.util.*;

/**
 * 下一个最大值
 */
public class NextLargerNodes1019{


	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode node1=new ListNode(7);
		ListNode node2=new ListNode(5);
		ListNode node3=new ListNode(1);
		ListNode node4=new ListNode(9);
		ListNode node5=new ListNode(2);
		ListNode node6=new ListNode(5);
		head.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=null;
		int []res=nextLargerNodes7(head);
		for (int i=0;i<res.length;i++) {
			System.out.print(res[i]);
		}
		
	}
    /*
    输入：[1,7,5,1,9,2,5,1]
    输出：[7,9,9,9,0,5,0,0]
     */
    public static int[] nextLargerNodes5(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        int [] stack=new int[10000];
        int stackIndex=-1;
        int [] res=new int[10000];
        for (int i=0;i<list.size();i++) {
            while(stackIndex!=-1 && list.get(i)>list.get(stack[stackIndex])){
                res[stack[stackIndex--]]=list.get(i);
            }
            //维护一个递减的栈
            stack[++stackIndex]=i;
        }
        return  Arrays.copyOf(res, list.size());
    }

    //再优化，一遍循环
    public static int[] nextLargerNodes6(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        int [] stack=new int[10000];
        int stackIndex=-1;
        int [] res=new int[10000];

        for (int i=0;temp!=null;i++) {
            list.add(temp.val);
            while(stackIndex!=-1 && list.get(i)>list.get(stack[stackIndex])){
                res[stack[stackIndex--]]=list.get(i);
            }
            //维护一个递减的栈
            stack[++stackIndex]=i;
            temp=temp.next;
        }
        return  Arrays.copyOf(res, list.size());
    }

    //再优化，一遍循环 , 数组模拟list
    public static int[] nextLargerNodes7(ListNode head) {
        int [] list=new int[10000];
        ListNode temp=head;
        int [] stack=new int[10000];
        int stackIndex=-1;
        int [] res=new int[10000];

        int i;
        for ( i=0;temp!=null;i++) {
            list[i]=temp.val;
            while(stackIndex!=-1 && list[i]>list[stack[stackIndex]]){
                res[stack[stackIndex--]]=list[i];
            }
            //维护一个递减的栈
            stack[++stackIndex]=i;
            temp=temp.next;
        }
        return  Arrays.copyOf(res, i);
    }

    /*
    输入：[1,7,5,1,9,2,5,1]
    输出：[7,9,9,9,0,5,0,0]
    */
    public static int[] nextLargerNodes(ListNode head) {
		//list里面存元素
        ArrayList<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);
        int[] res = new int[A.size()];
        //栈里面存索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
            	//回溯
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }
        return res;
    }


    public static int[] nextLargerNodes2(ListNode head) {
        int [] res=new int[10000];
        int [] nums=new int[10000];
		//索引栈
        int [] index=new int[10000];
        ListNode temp=head;
        int i=0,top=-1;
        while(temp!=null){
            while(top!=-1 && nums[index[top]]<temp.val){
                res[index[top--]]=temp.val;
            }
			//递减序列
            index[++top]=i;
            nums[i++]=temp.val;
            temp=temp.next;
        }
        return Arrays.copyOf(res, i);
    }

	//我最开始的思路也擦不多是这样的,但是没想到在栈里面存索引
	//和上面的方法差不多,但这个更快，上面那个跑了两遍
    public static int[] nextLargerNodes3(ListNode head) {
        int[] stack = new int[10000];
        int[] res = new int[10000];
        int[] temp = new int[10000];
        int top = -1, i = 0;
        ListNode node = head;
        while (node != null) {
            while (top != -1 && temp[stack[top]] < node.val)
                res[stack[top--]] = node.val;
            stack[++top] = i;
            temp[i++] = node.val;
            node = node.next;
        }
        return Arrays.copyOf(res, i);
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}