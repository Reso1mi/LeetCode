import java.util.*;
public class Main174{
    public static void main(String[] args) {

    }

    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat==null || mat.length<=0) {
            return new int[]{};
        }
        Pair[] pair=new Pair[mat.length];
        int[] res=new int[k];
        for (int i=0;i<mat.length;i++) {
            int count=0;
            for (int j=0;j<mat[0].length;j++) {
                if (mat[i][j]==1) {
                    count++;
                }
            }
            pair[i]=new Pair(i,count);
        }
        Arrays.sort(pair,(p1,p2)-> p1.count!=p2.count?p1.count-p2.count:p1.index-p2.index);
        for (int i=0;i<k;i++) {
            res[i]=pair[i].index;
        }
        return res;
    }

    class Pair{
        int index;
        int count;
        public Pair(int index,int count){
            this.index=index;
            this.count=count;
        }
    }

    public int minSetSize(int[] arr) {
        int half=arr.length/2+1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<arr.length;i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<HashMap.Entry<Integer,Integer>> pq=new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
        for (HashMap.Entry ent:map.entrySet()) {
            pq.add(ent);
        }
        int res=0;
        while(half>=0){
            half-=pq.poll().getValue();
            res++;
        }
        return res;
    }

    private long mod=1000000007;

    public int maxProduct(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        long sumAll=sum(root);
        while(!stack.isEmpty() || cur!=null){
            TreeNode temp=null;
            long s=0L;
            while(cur!=null){
                temp=cur.left;
                cur.left=null;
                long r=sum(root);
                s=r*(sumAll-r);
                max=Math.max(s,max);
                cur.left=temp;
                stack.add(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            temp=cur.right;
            cur.right=null;
            long r=sum(root);
            s=r*(sumAll-r);
            max=Math.max(s,max);
            cur.right=temp;
            cur=cur.right;
        }
        return (int)(max%mod);
    }

    private long max=-1;

    private HashMap<String,Long> cache=new HashMap<>();

    public long sum(TreeNode root){
        if (root==null) {
            return 0;
        }
        return root.val+sum(root.left)+sum(root.right);
    }


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

    public int maxJumps(int[] arr, int d) {
        int[][] max=new int[arr.length][arr.length];
        int[][] min=new int[arr.length][arr.length];
        for (int i=0;i<arr.length;i++) {
            max[i][i]=arr[i];
            for (int j=i+1;j<arr.length;j++) {
                max[i][j]=Math.max(max[i][j-1],arr[j]);
            }
        }
        for (int i=0;i<arr.length;i++) {
            min[i][i]=arr[i];
            for (int j=i+1;j<arr.length;j++) {
                min[i][j]=Math.min(min[i][j-1],arr[j]);
            }
        }
        int res=0;
        for (int i=0;i<arr.length;i++) {
            res=Math.max(jump(arr,d,i,max,min),res);
        }
        return res;
    }

    public int jump(int[] arr,int d,int index,int[][] max,int[][] min){ //从index起跳能跳多远
        int res=0;
        for (int i=Math.max(index-d,0);i<index;i++) {
            if (arr[index]>arr[i] && arr[i]>min[i+1][index-1] && arr[i]<max[i+1][index-1]) {
                res=Math.max(jump(arr,d,i,max,min)+1,res);
            }
        }

        for (int i=index+1;i<=Math.min(index+d,arr.length-1);i++) {
            if (arr[index]>arr[i] && arr[i]>min[index+1][i-1] && arr[i]<max[index+1][i-1]) {
                res=Math.max(jump(arr,d,i,max,min)+1,res);
            }
        }
        return res;
    }
}