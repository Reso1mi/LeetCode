public class TrimBST669{
    public static void main(String[] args) {

    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null){
            return root;
        }
        root.left=trimBST(root.left,L,R);
        root.right=trimBST(root.right,L,R);
        //root.val<L,左子树全部小于L
        if(root.val<L){
            return root.right;
        }
        if(root.val>R){
            return root.left;
        }
        return root;
    }
}