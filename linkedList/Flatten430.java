/*
	
*/
public class Flatten430{
	public static void main(String[] args) {
		Node head=new Node(1);
		Node node1=new Node(2);
		Node node2=new Node(3);
		Node node3=new Node(4);
		Node node4=new Node(5);
		Node node5=new Node(6);
		Node node6=new Node(7);

		Node node7=new Node(111);
		Node node8=new Node(222);
		Node node9=new Node(333);
		Node node10=new Node(444);
		
		node7.next=node8;
		node8.prev=node7;

		node8.next=node9;
		node9.prev=node8;

		
		head.next=node1;
		node1.prev=head;
		head.child=node7;

		node1.next=node2;
		node2.prev=node1;

		node2.next=node3;
		node3.prev=node2;
		node2.child=node10;

		node3.next=node4;
		node4.prev=node3;

		node4.next=node5;
		node5.prev=node4;

		node5.next=node6;
		node6.prev=node5;
		node6.next=null;
		printList(head);
		Node res=flatten2(head);  //改进后的  循环执行了11次
		//Node res=flatten3(head);  没改进的  循环执行了15次
		printList(res);
	}

	/*
		这种解法思路还是比较清晰的
		
		每次有子链的时候就直接把子链遍历到尾 然后添加到链表中形成新主链 把子链的入口节点child指定为null
			
		然后主链继续向后遍历所以整个遍历的次数就是整个链表元素的个数 O(M)
	*/
	public static Node flatten1(Node head) {
		if(head==null || head.next==null&&head.child==null){
            return head;
        }
        Node cur=head;
        Node nNext;
        Node child;
        while(cur!=null){
            if(cur.child!=null){
            	//有子链表
                child=cur.child; //孩子链头
                nNext=cur.next; //主链的下一节点

                //连接前半部分
                cur.next=child; //主链的下一节点为孩子
                child.prev=cur; //新的下一节点的前驱绑定主链前一节点
                //已经拼接到主链，孩子链置为空 （这部还比较关键我开始一直没置为null）
                cur.child=null;
                if(nNext==null){
                	//遍历到主链最后一个了
                	//所以没有下一个节点，后面的步骤不用继续但是也不能Break 因为最后一个节点有可能还有子链表
                    continue;
                }
                while(child.next!=null){//找到新主链的下一节点 (子链的最后一个)
                    child=child.next;
                }
                child.next=nNext;//连接以前的主链
                nNext.prev=child;
            }
            //主链表向后移动
            cur=cur.next;
        }
        return head;
    }

    //标准的DFS
    public static Node flatten2(Node node) {
       if(node==null){
            return node;
        }
        Node head = node;
        while (head!=null){
        	System.out.println(1);
        	//我感觉这样会快一些
        	 Node next = head.next;
            if(head.child!=null){
                next = head.next;
                //子链表扁平化 返回头节点
                Node nextLayer = flatten2(head.child); //子链表的头节点
                //连接子链表头和主链
                head.next = nextLayer;
                nextLayer.prev = head;
                //然后子链表置为null
				head.child = null;

				//遍历到子链表的结尾
                while (nextLayer.next!=null){
                    nextLayer = nextLayer.next;
                }
                //连接子链表的尾部
                nextLayer.next = next;
                if(next!=null){
                    next.prev = nextLayer;
                }
            }
            //这里就直接跳过子链表 之前的是head=head.next; 但是因为之前的子链表已经加到主链表中所以会浪费一些时间（子链表肯定是已经扁平化的肯定都没有子链表）
            head = next;
        }
        return node;
    }


    public static Node flatten3(Node node) {
    	if(node==null){
            return node;
        }
        Node head = node;
        while (head!=null){
        	System.out.println(1);
            if(head.child!=null){
                Node next = head.next;
                Node nextLayer = flatten3(head.child);
                head.next = nextLayer;
                nextLayer.prev = head;
                head.child = null;
                while (nextLayer.next!=null){
                    nextLayer = nextLayer.next;
                }
                nextLayer.next = next;
                if(next!=null){
                    next.prev = nextLayer;
                }
            }
            head = head.next;
        }
        return node;
    }


    public static void printList(Node l){
		while(l!=null){
			System.out.print(l.val+" , ");
			l=l.next;
		}
		System.out.println();
	}

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int val) {
    	this.val=val;
    }

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};