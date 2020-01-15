public class MaxPathSum124{
    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {
        if (root==null) {
            return Integer.MIN_VALUE;
        }
        if (root.left==null && root.right==null) {
            return root.val;
        }
        int res=helper(root);
        return Math.max(res,Math.max(maxPathSum(root.left),maxPathSum(root.right)));
    }

    //以当前节点为根的最大路径和
    public int helper(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;;
        if (root.left==null && root.right==null) {
            return root.val;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        return root.val+(left>0?left:0)+(right>0?right:0);
    }

    //root为起始节点的最大路径和
    //这里可以cache一下
    //cache 前 219ms
    //cache 后 30ms

    private  HashMap<String,Integer> cache=new HashMap<>();

    public int dfs(TreeNode root){
        if (root==null) {
            return Integer.MIN_VALUE;
        }
        if (cache.containsKey(root.toString())) {
            return cache.get(root.toString());
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int max=Math.max(left,right);
        cache.put(root.toString(),root.val+(max>0?max:0));
        return root.val+(max>0?max:0);
    }


    //最优解
    private int res=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    //以当前节点为根的最大路径和
    public int helper(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(helper(root.left),0);
        int right=Math.max(helper(root.right),0);
        res=Math.max(res,root.val+left+right);
        return root.val+Math.max(left,right);
    }
}