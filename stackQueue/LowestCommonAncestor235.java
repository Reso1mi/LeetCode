public class LowestCommonAncestor235{
    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //特殊情况,其中一个已经是另一个的祖先了
        if (p==root || q==root) return root;
        //都小于根节点
        if (p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }else if (p.val > root.val && q.val > root.val) {
            //都大于根节点
            return lowestCommonAncestor(root.right,p,q);
        }else{
            //一大一小
            return root;
        }
    }
}