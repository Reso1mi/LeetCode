import java.util.*;
public class MaxCoins312{
    public static void main(String[] args) {
        MaxCoins312 m=new MaxCoins312();
        int res=m.maxCoins(new int[]{3,1,5,8});
        System.out.println(res);
    }

    //暴力回溯
    public int maxCoinsTLE(int[] nums) {
        LinkedList<Integer> list=new LinkedList<>();
        for (int n:nums) list.add(n);
            dfs(list,0);
        return max;
    }

    private int max=0;

    public void dfs(LinkedList<Integer> list,int sum) {
        if (list.size()==0) {
            max=Math.max(sum,max);
            return;
        }
        for (int i=0;i<list.size();i++) {
            int temp=list.get(i);
            //这个值要先算
            int cur=(i-1<0?1:list.get(i-1))*(i+1>=list.size()?1:list.get(i+1))*temp;
            list.remove(i);
            dfs(list,sum+cur);
            list.add(i,temp);
        }
    }

    //区间型DP
    public int maxCoins(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int[] A=new int[nums.length+2];
        A[0]=1;A[A.length-1]=1;
        for (int i=0;i<nums.length;i++) {
            A[i+1]=nums[i]; //copy一个新数组
        }
        //区间DP
        int n=A.length;
        int[][] dp=new int[n][n]; //dp[i][j]代表的是不包含边界i,j的最大得分
        for (int len=2;len<=n;len++) { //枚举区间长度
            for (int i=0;i<=n-len;i++) { //枚举起点
                int j=i+len-1; //区间终点
                for (int k=i+1;k<j;k++) { //枚举分割点
                    dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]+A[k]*A[i]*A[j]);
                }
            }
        }
        return dp[0][n-1];
    }

    //简洁型
    public int maxCoins(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int n=nums.length;
        //dp[i][j]代表的是包含边界i,j的最大得分
        int[][] dp=new int[n][n]; 
        for (int len=1;len<=n;len++) { //枚举区间长度
            for (int i=0;i<=n-len;i++) { //枚举起点
                int j=i+len-1; //区间终点
                for (int k=i;k<=j;k++) { //枚举分割点
                    dp[i][j]=Math.max(dp[i][j],(k-1>=0?dp[i][k-1]:0)+(k+1<n?dp[k+1][j]:0)+nums[k]*(i-1>=0?nums[i-1]:1)*(j+1<n?nums[j+1]:1));
                }
            }
        }
        return dp[0][n-1];
    }
}