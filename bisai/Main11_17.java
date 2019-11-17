public class Main11_17{
    public static void main(String[] args) {
        Main11_17 ma = new Main11_17();
        int[] nums={3,6,5,1,8};
        System.out.println(ma.maxSumDivThree(nums));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        while (k>0) {
            int[][] bak=new int[n][m];
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    bak[i][j]=grid[i][j];
                }
            }
            for (int j=1;j<m;j++) {
                for (int i=0;i<n;i++) {
                    grid[i][j]=bak[i][j-1];
                }
            }
            for (int i=0;i<n-1;i++) {
                grid[i+1][0]=bak[i][m-1];
            }
            grid[0][0]=bak[n-1][m-1];
            k--;
        }
        List<List<Integer>> res=new LinkedList<>();
        for (int i=0;i<n;i++) {
            List<Integer> temp=new LinkedList<>();
            for (int j=0;j<m;j++) {
                temp.add(grid[i][j]);
            }
            res.add(temp);
        }
        return res;
    }


    public FindElements(TreeNode root) {
        treeroot=root;
        create(root,0);
    }

    private TreeNode treeroot=null;

    public void create(TreeNode root,int rootVal){
        if (root==null) {
            return;
        }
        root.val=rootVal;
        if (root.left!=null) {
            create(root.left,2*rootVal+1);
        }   
        if (root.right!=null) {
            create(root.right,2*rootVal+2);
        }
    }
    
    public boolean find(int target) {
        return find(treeroot,target);
    }

    public boolean find(TreeNode root,int target) {
        if (root==null) {
            return false;
        }
        if (root.val==target) {
            return true;
        }
        return find(root.left,target)||find(root.right,target);
    }


    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,0);
        return max;
    }

    int max=-1;

    public void dfs(int[] nums,int index,int sum) {
        if (sum%3==0) {
            max=Math.max(max,sum);
        }
        for (int i=index;i<nums.length;i++) {
            if (i>index && nums[i]==nums[i-1]) {
                continue;
            }
            dfs(nums,i+1,sum+nums[i]);
        }
    }

    public int maxSumDivThree(int[] nums,int index,int sum) {
        if (index==nums.length-1) {
            return sum;
        }
        System.out.println("ad "+sum);
        int res=maxSumDivThree(nums,index+1,sum);
        if ((sum+nums[index])%3==0) {
            res=Math.max(res,maxSumDivThree(nums,index+1,sum+nums[index]));
        }
        return res;
    }
}