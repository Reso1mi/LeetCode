public class RobTree337{
    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        int[] res=tryRob(root);
        return Math.max(res[0],res[1]);
    }

    //树形dp???
    //看的懂，但是肯定写不出来 。。。。
    public int[] tryRob(TreeNode root) {
        int[] dp=new int[2];
        if (root==null) {
            return dp;
        }

        int[] left=tryRob(root.left);
        int[] right=tryRob(root.right);
        //不包含当前节点的最大值
        dp[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //包含当前节点的最大值
        dp[1]=left[0]+right[0]+root.val;
        return dp;
    }

    //AC了,但是效率很低
    //可以用hashMap缓存一下每个节点rob的值,但是没必要
    public int rob(TreeNode root) {
        return tryRob(root);
    }

    public int tryRob(TreeNode root) {
        if (root==null) {
            return 0;
        }
        if (root.left==null && root.right==null) {
            return root.val;
        }
        //偷取当前节点
        int res=root.val;
        if (root.left!=null) {
            res+=rob(root.left.left)+rob(root.left.right);
        }
        if (root.right!=null) {
            res+=rob(root.right.left)+rob(root.right.right);
        }
        //不偷当前节点
        int res2=0;
        res2=rob(root.left)+rob(root.right);
        return Math.max(res,res2);
    }
}