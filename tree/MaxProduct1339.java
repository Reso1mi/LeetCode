public class MaxProduct1339{
    public static void main(String[] args) {

    }

    private long mod=1000000007;    

    List<Long> sum=new ArrayList<>();

    //标准解法
    public int maxProduct(TreeNode root) {
        long max=-1;
        long sumAll=dfs(root);
        for (Long s:sum) {
            max=Math.max(max,s*(sumAll-s));    
        }
        return (int)(max%mod);
    }

    public long dfs(TreeNode root){
        if (root==null) {
            return 0;
        }
        sum.add(root.val+dfs(root.left)+dfs(root.right));
        return sum.get(sum.size()-1);
    }

    //空间小一点的解法
    long sumAll=0;

    long max=-1;

    private long mod=1000000007;

    public int maxProduct(TreeNode root) {
        sumAll=dfs(root);
        dfs(root);
        return (int)(max%mod);
    }

    public long dfs(TreeNode root){
        if (root==null) {
            return 0;
        }
        long temp=root.val+dfs(root.left)+dfs(root.right);
        max=Math.max(temp*(sumAll-temp),max);
        return temp;
    }


    //比赛sb解法
    private long mod=1000000007;

    private long sumAll=0;

    private long max=-1;
    
    public int maxProduct(TreeNode root) {
        sumAll=sum(root);
        dfs(root);
        return (int)(max%mod);
    }

    public void dfs(TreeNode root){
        if (root==null) {
            return;
        }
        long temp=sum(root);
        max=Math.max(max,temp*(sumAll-temp));
        dfs(root.left);
        dfs(root.right);
    }

    private HashMap<String,Long> cache=new HashMap<>();

    public long sum(TreeNode root){
        if (root==null) {
            return 0;
        }
        if (cache.containsKey(root.toString())) {
            return cache.get(root.toString());
        }
        cache.put(root.toString(),root.val+sum(root.left)+sum(root.right));
        return cache.get(root.toString());
    }
}