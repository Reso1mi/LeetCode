import java.util.*;
public class PostorderTraversal145{
    public static void main(String[] args) {

    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if (root==null)return list;
        recurPostorder(list,root);
        return list;
    }

    public void recurPostorder(List<Integer> res,TreeNode node){
        if (node==null) return;
        recurPostorder(res,node.left);
        recurPostorder(res,node.right);
        res.add(node.val);
    }

    //经典的非递归实现方式
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root,lastNode=null; //lastNode为上一次访问的节点
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null) {
                stack.push(cur);
                cur=cur.left;
            }
            //没有左子树了,把后一个左节点拿出来
            cur=stack.peek();
            //如果没有右节点,或者右节点访问过了
            if (cur.right==null||cur.right==lastNode) {
                //添加节点
                res.add(cur.val);
                //记录当前节点为lastNode
                lastNode=cur;
                //将他pop出去
                stack.pop();
                //节点已经弹出
                //指向null,不然就死循环了
                cur=null;
            }else{
                //右节点不为空,并且没访问过
                //切换为右子树,重复上面的步骤
                cur=cur.right;
            }
            
        }
        return res;
    }


    //摸底递归栈的方式
    public List<Integer> postorderTraversal(TreeNode root) {
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
                stack.push(new Command(false,node));
                if (node.right!=null) {
                    stack.push(new Command(true,node.right));
                }
                if (node.left!=null) {
                    stack.push(new Command(true,node.left));
                }
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