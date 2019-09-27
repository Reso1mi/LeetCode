public class InvertTree226{
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;
    }

    //傻逼了。。。。。。。
    /*public static void swap(TreeNode node1,TreeNode node2){
        TreeNode temp=node1;
        node1=node2;
        node2=temp;
    }*/
}