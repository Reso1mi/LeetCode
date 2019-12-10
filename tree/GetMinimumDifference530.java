public class GetMinimumDifference530{
    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        int diff=Integer.MAX_VALUE,last=-1;
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            if (last!=-1) {
                diff=Math.min(diff,Math.abs(last-cur.val));   
            }
            last=cur.val;
            cur=cur.right;
        }
        return diff;
    }

    private int diff = Integer.MAX_VALUE;

    private int last = -1;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return diff;
    }

    public void inorder(TreeNode root){
        if (root==null) {
            return;
        }
        inorder(root.left);
        diff = last==-1?diff:Math.min(diff,Math.abs(last-root.val));
        last = root.val;
        inorder(root.right);
    }
}