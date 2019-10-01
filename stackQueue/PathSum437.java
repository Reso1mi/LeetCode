public class PathSum437{
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null ) {
            return 0;
        }
        int res=findPath(root,sum);
        res+=pathSum(root.left,sum);
        res+=pathSum(root.right,sum);
        return res;
    }

    public int findPath(TreeNode node,int sum){
        int res=0;
        if (node==null) {
            return res;
        }
        if (node.val==sum) {
            res++;
        }
        res+=findPath(node.left,sum-node.val);
        res+=findPath(node.right,sum-node.val);
        return res;
    }
}
