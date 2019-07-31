public class MaxDepth104{

    public static void main(String[] args) {

    }

    //maxDepth(root)=1+max(maxDepth(root.left),maxDepth(root.right));
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int maxLeft=maxDepth(root.left);
        int maxRight=maxDepth(root.right);
        return (maxLeft>maxRight?maxLeft:maxRight)+1;
    }
}