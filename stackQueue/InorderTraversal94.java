import java.util.*;
public class InorderTraversal94{
    public static void main(String[] args) {

    }

    //递归方式
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null)return list;
        recurInorder(list,root);
        return list;
    }

    public void recurInorder(List<Integer> res,TreeNode node){
        if (node==null) return;
        recurInorder(res,node.left);
        res.add(node.val);
        recurInorder(res,node.right);
    }

    //经典的非递归实现方式
    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }
            //没有左子树了
            cur=stack.pop();
            //将当前节点添加到res中
            res.add(cur.val);
            //切换为右子树
            cur=cur.right;
        }
        return res;
    }



    //非递归,模拟递归栈的方式
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null)return list;
        Stack<Command> stack=new Stack<>();
        stack.push(new Command(true,root));
        while(!stack.isEmpty()){
            Command com=stack.pop();
            TreeNode tree=com.node;
            if (!com.isGo) {
                list.add(tree.val);
            }else{
                if (tree.right!=null) {
                    stack.push(new Command(true,tree.right));
                }
                stack.push(new Command(false,tree));
                if (tree.left!=null) {
                    stack.push(new Command(true,tree.left));    
                }
            }
        }
        return list;
    }
    
    static class Command{
        private boolean isGo;
        private TreeNode node;

        public Command(boolean isGo,TreeNode node){
            this.isGo=isGo;
            this.node=node;
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

