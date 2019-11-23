public class RangeSumBST938{
    public static void main(String[] args) {

    }

    private int sum=0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        preorder(root,L,R);
        return sum;
    }

    public void preorder(TreeNode root, int L, int R) {
        if (root==null) {
            return;
        }
        rangeSumBST(root.left,L,R);
        if (root.val>=L && root.val<=R) {
            sum+=root.val;
        }
        rangeSumBST(root.right,L,R);
    }
}