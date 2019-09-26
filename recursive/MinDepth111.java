public class MinDepth111{
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root==null && root.left==null&&root.right==null) return 0;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}