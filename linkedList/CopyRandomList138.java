import java.util.HashMap;
import java.util.Map;
public class CopyRandomList138{
    public static void main(String[] args) {
        Node head=new Node(1,null,null);
        Node node1=new Node(2,null,null);
        head.next=node1;
        System.out.println(head.next.val);
        mapTest(head);
        System.out.println(head.next.val);
    }

    public static  Node mapTest(Node head){
        Map<Integer,Node> copNode =new HashMap<>();
        copNode.put(1,head);
        copNode.get(1).next=null;
        return head;
    }
    //深克隆
    //方法一: 利用map
    public static Node copyRandomList(Node head) {
        Map<Node,Node> copNode =new HashMap<>();
        Node temp=head;
        while(temp!=null){
            //建立对应关系
            copNode.put(temp,new Node(temp.val,null,null));
            temp=temp.next;
        }
        //再循环一次复制next和Radom节点
        temp=head;
        while(temp!=null){
            copNode.get(temp).next=copNode.get(temp.next);
            copNode.get(temp).random=copNode.get(temp.random);
            temp=temp.next;
        }
        return copNode.get(head);
    }

    //方法2:在原链表中复制节点再分离节点
    public static Node copyRandomList2(Node head) {
        if(head==null)return head;
        Node temp=head;
        //链表  奥义 - 影分身
        while(temp!=null){
            //这里直接将next域传入构造器完成和后面元素的连接
            temp.next=new Node(temp.val,temp.next,null);
            temp=temp.next.next;
        }
        temp=head;
        //连接random域
        while(temp!=null){
            if(temp.random!=null){
                temp.next.random=temp.random.next;
            }
            temp=temp.next.next;
        }
        temp=head;
        // 分离
        Node newHead=head.next;
        Node next=null;
        while(temp!=null){
            next=temp.next;
            if(next!=null){
                temp.next=next.next;
            }
            temp=next;
        }
        return newHead;
    }

    //方法3 错的
    public Node copyRandomList3(Node head) {
        Node dummyHead = new Node(0,null,null);
        Node cur = head;
        Node  newHead = dummyHead;
        while(cur!=null){
            newHead.next = copyNode(cur);
            newHead = newHead.next;
            cur = cur.next;
        }
        return dummyHead.next;
    }
    public Node copyNode(Node cur){
        Node node = new Node(cur.val,null,null);
        if(cur.random!=null){
            node.random = new Node(cur.random.val,null,null);
        }
        return node;
    }
}
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};