public class Flatten114{
    public static void main(String[] args) {

    }

    //前序遍历
    TreeNode last=null;

    public void flatten(TreeNode root) {
        if (root==null) {
            return;
        }
        if (last!=null) {
            last.left=null;
            last.right=root;
        }
        last=root;
        TreeNode right=root.right;//保存右子树
        flatten(root.left);
        flatten(right);
    }

    //后序遍历
    TreeNode pre=null;

    public void flatten(TreeNode root) {
        if (root==null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }


    public void flatten(TreeNode root) {
        while(root!=null){
            if (root.left==null) {
                root=root.right;
            }else{
                TreeNode mRight=root.left;
                while(mRight.right!=null){
                    mRight=mRight.right;
                }
                mRight.right=root.right;
                root.right=root.left;
                root.left=null;
                root=root.right;
            }
        }
    }

    public void flatten(TreeNode root) {
        TreeNode mRight=null;
        while(root!=null){
            if (root.left!=null) {
                mRight=root.left;
                //找到左边的最右节点
                while(mRight.right!=null){
                    mRight=mRight.right;
                }
                //将根的右节点接在mRight.right
                mRight.right=root.right;
                //将root.left接在root.right
                root.right=root.left;
                //左节点置为null
                root.left=null;
            }
            //重复该过程
            root=root.right;
        }
    }
}