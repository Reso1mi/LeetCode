public class FindFrequentTreeSum508{
    public static void main(String[] args) {

    }

    Map<Integer,Integer> map = new HashMap<>();

    //int max=0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root ==null) {
            return new int[]{};
        }
        dfs(root);
        List<Integer> res=new ArrayList<>();
        List<Integer> counts=new ArrayList<>(map.values());
        int max=counts.stream().mapToInt(Integer::valueOf).max().getAsInt();
        for (Integer key:map.keySet()) {
            if (map.get(key) == max) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int dfs(TreeNode root){
        if (root==null) {
            return 0;
        }
        int value=root.val+dfs(root.right)+dfs(root.left);
        map.put(value,map.getOrDefault(value,0)+1);
        return value;
    }



    //lambda写法
    private Map<Integer,Integer> map = new HashMap<>();

    private int maxCount=0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root ==null) {
            return new int[]{};
        }
        dfs(root);
        List<Integer> res=new ArrayList<>();
        map.keySet().stream().filter(val->map.get(val)==maxCount).forEach(res::add);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int dfs(TreeNode root){
        if (root==null) {
            return 0;
        }
        int value=root.val+dfs(root.right)+dfs(root.left);
        map.put(value,map.getOrDefault(value,0)+1);
        maxCount=Math.max(maxCount,map.get(value));
        return value;
    }
}