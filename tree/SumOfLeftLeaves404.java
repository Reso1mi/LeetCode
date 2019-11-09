public class SumOfLeftLeaves404{
    public static void main(String[] args) {

    }

    private int sum=0;

    public int sumOfLeftLeaves(TreeNode root){
        sumOfLeft(root);
        return sum;
    };

    public void sumOfLeft(TreeNode root) {
        if (root==null) {
            return;
        }
        if (root.left!=null && root.left.left==null &&root.left.right==null) {
            sum+=root.left.val;
        }
        sumOfLeft(root.left);
        sumOfLeft(root.right);
    }
}