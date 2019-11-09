import java.util.*;
public class PreorderTraversal144{
    public static void main(String[] args) {

    }

    private List<Integer> res=new ArrayList<>();
    
    public List<Integer> preorderTraversal2(TreeNode root) {
        if(root!=null){
            res.add(root.val);
            preorderTraversal2(root.left);
            preorderTraversal2(root.right);
        }
        return res;
    }
    
    //经典的非递归实现方式
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top=stack.pop();
            if (top.right!=null) {
                stack.push(top.right);
            }
            if (top.left!=null) {
                stack.push(top.left);
            }
            res.add(top.val);
        }
        return res;
    }


    //经典的非递归实现方式
    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null) {
                res.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            //没有左子树了
            cur=stack.pop();
            //切换为右子树
            cur=cur.right;
            
        }
        return res;
    }

    //模拟栈的方式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<Command> stack=new Stack<>();
        stack.push(new Command(true,root));
        while(!stack.isEmpty()){
            Command command=stack.pop();
            if (!command.isGo) {
                res.add(command.node.val);
            }else{
                TreeNode node=command.node;
                if (node.right!=null) {
                    stack.push(new Command(true,node.right));
                }
                if (node.left!=null) {
                    stack.push(new Command(true,node.left));
                }    
                stack.push(new Command(false,node));
            }
        }
        return res;
    }

    static class Command{
        boolean  isGo;
        TreeNode node;
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