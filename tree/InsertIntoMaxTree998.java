public class InsertIntoMaxTree998{
    public static void main(String[] args) {

    }

    //题目描述很辣鸡
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            root.right=insertIntoMaxTree(root.right,val);    
            return root;
        }
        TreeNode newRoot=new TreeNode(val);
        newRoot.left=root;
        return newRoot;
    }
}