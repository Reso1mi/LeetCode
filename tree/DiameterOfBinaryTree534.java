public class DiameterOfBinaryTree534{
    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {
        return root==null?0:Math.max(hight(root.left)+hight(root.right),Math.max(diameterOfBinaryTree(root.right),diameterOfBinaryTree(root.left)));
    }

    public int hight(TreeNode node){
        return node==null?0:Math.max(hight(node.left),hight(node.right))+1;
    }

    int max=Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) {
            return 0;
        }
        hight(root);
        return max;
    }

    public int hight(TreeNode node){
        if (node==null) {
            return 0;
        }
        int left=hight(node.left);
        int right=hight(node.right);
        max=Math.max(left+right,max);
        return Math.max(left,right)+1;
    }
}