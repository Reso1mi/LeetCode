public class BuildTreeFromPreAndInor105{
    public static void main(String[] args) {

    }

    //3,9,20,15,7
    //9,3,15,20,7
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null) {
            return null;
        }
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder,int preleft,int preright,int[] inorder,int inleft,int inright) {
        if (preleft>preright || inleft>inright) {
            return null;
        }
        TreeNode root=new TreeNode(preorder[preleft]);
        int index=inleft;
        while(inorder[index] != preorder[preleft]) {
            index++;
        }
        root.left=buildTree(preorder,preleft+1,preleft+index-inleft,inorder,inleft,index-1);
        root.right=buildTree(preorder,preleft+index-inleft+1,preright,inorder,index+1,inright);
        return root;
    }
}
