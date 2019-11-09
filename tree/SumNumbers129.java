public class SumNumbers129{
    public static void main(String[] args) {

    }

    //BFS
    public int sumNumbers(TreeNode root) {
        int res=0;
        if (root == null ) return res;
        Stack<TreeNode> node_stack=new Stack<>();
        Stack<Integer> sum_stack=new Stack<>();
        node_stack.add(root);
        sum_stack.add(root.val);
        while(!node_stack.isEmpty()){
            TreeNode node=node_stack.pop();
            int tempS=sum_stack.pop();
            if (node.left==null && node.right==null) {
                res+=tempS;
                continue;
            }
            if (node.left!=null) {
                node_stack.add(node.left);
                //注意*10,在上一层的基础上*10
                sum_stack.add(tempS*10+node.left.val);
            }
            if (node.right!=null) {
                node_stack.add(node.right);
                sum_stack.add(tempS*10+node.right.val);
            }
        }
        return res;
    }


    private int sum=0;
    //DFS
    public int sumNumbers2(TreeNode root) {
        sumNumber(0,root);
        return sum;
    }

    public void sumNumber(int parent,TreeNode root) {
        if (root==null) {
            return;
        }
        int cur=parent*10+root.val;
        //找到叶子节点
        if (root!=null && root.left==null&& root.right==null) {
            sum+=cur;
        }
        sumNumber(cur,root.left);
        sumNumber(cur,root.right);
    }
}
