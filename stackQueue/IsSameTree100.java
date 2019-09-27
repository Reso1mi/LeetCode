public class IsSameTree100{
    public static void main(String[] args) {

    }

/*    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        }
        if (   (p==null && q!=null) 
            || (p!=null && q==null)
            || (p.left==null && q.left!=null) 
            || (p.right!=null && q.right==null)
            || p.val!=q.val
            || (p.left!=null && p.left.val!=q.left.val) 
            || (p.right!=null && p.right.val!=q.right.val)) {
            return false;
        }
        return isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);
    }*/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        }
        if (p!=null && q!=null && p.val==q.val) {
            return isSameTree(p.right,q.right)&&isSameTree(p.left,q.left);;
        }
        return false;
    }
}
