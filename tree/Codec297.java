import java.util.*;
public class Codec297{
    public static void main(String[] args) {
        Codec297 c=new Codec297();
        TreeNode node1=new TreeNode(1);
        node1.left=new TreeNode(2);
        node1.right=new TreeNode(3);
        System.out.println(c.serialize(node1));
    }

    //层序遍历的方式
    public String serialize(TreeNode root) {
        if (root==null) {
            return "";
        }
        //BFS
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if (cur!=null) {
                sb.append(cur.val+",");
                queue.add(cur.left);
                queue.add(cur.right);
            }else{
                sb.append("null,"); //会多很多null,不过影响不大
            }
        }
        return sb.toString();
    }

    //按照题目意思写代码就ok
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] treeData=data.split(",");
        int index=0;
        TreeNode root=node(treeData[index]);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            cur.left=node(treeData[++index]);
            if (cur.left!=null) {
                queue.add(cur.left);
            }
            cur.right=node(treeData[++index]);
            if (cur.right!=null) {
                queue.add(cur.right);
            }
        }
        return root;
    }

    public TreeNode node(String str){
        if (!"null".equals(str)) {
            return new TreeNode(Integer.valueOf(str));
        }
        return null;
    }

    public String serialize(TreeNode root) {
        if (root==null) {
            return "null";
        }
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] dataTree=data.split(",");
        Queue<String> queue=new LinkedList<>(Arrays.asList(dataTree));
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue){
        String val=queue.poll();
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root=node(val);
        root.left=deserialize(queue);
        root.right=deserialize(queue);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}