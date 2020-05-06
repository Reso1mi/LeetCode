import java.util.*;
public class MincostTickets983{
    public static void main(String[] args) {
        MincostTickets983 m=new MincostTickets983();
        m.mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15});
    }

    //[1,4,6,7,8,20]  csots=[2,7,15]
    //[1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
    //错误解法
    public int mincostTickets3(int[] days, int[] costs) {
        int n=days.length;
        int[][] dp=new int[366][366];
        for (int i=0;i<n;i++) {
            Arrays.fill(dp[i],0x3f3f3f3f);
        }
        for (int i=days[0];i<=days[n-1];i++) {
            dp[i][i]=costs[0];
        }
        int [] dt = {1,7,30};
        for (int len=2;len<=days[n-1]-days[0]+1;len++) {
            for (int left=days[0];left+len-1<=days[n-1];left++) {
                int right=left+len-1;
                for (int k=0;k<3;k++) {
                   dp[left][right]=Math.min((right-dt[k]>=days[0]?dp[left][right-dt[k]-1]:0)+costs[k],dp[left][right]);
                }
            }
        }
        return dp[days[0]][days[n-1]];
    }


    //[1,4,6,7,8,20]  csots=[2,7,15]
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp=new int[days[n-1]+1];
        boolean[] visit=new boolean[days[n-1]+1];
        for (int i:days) {
            visit[i]=true;
        }
        Arrays.fill(dp,0x3f3f3f3f);
        int [] dt = {1,7,30};
        dp[days[0]-1]=0;//初始状态
        //枚举所有的day
        for (int d=days[0];d<=days[n-1];d++) {
            //一开始没想到这里，dubug的时候才看出来，不在旅游计划中的应该直接延续前面的
            if (!visit[d]) { 
                dp[d]=dp[d-1];
                continue;
            }
            //三种票
            for (int k=0;k<3;k++) {
                dp[d]=Math.min((d-dt[k]>=days[0]-1?dp[d-dt[k]]:0)+costs[k],dp[d]);
            }
        }
        return dp[days[n-1]];
    }

    //不行，这不连续的不好搞
/*    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        int[] dp=new int[366];
        Arrays.fill(dp,0x3f3f3f3f);
        int [] dt = {1,7,30};
        dp[days[0]]=costs[0];
        for (int i=1;i<n;i++) {
            for (int k=0;k<3;k++) {
                if(days[i]-days[i-1]>dt[k]){
                    dp[days[i]]=Math.min(dp[days[i-1]]+costs[k],dp[days[i]]);
                }else{
                    dp[days[i]]=Math.min(dp[days[i]-dt[k]]costs[k],dp[days[i]]);
                }
            }
            System.out.println(days[i]+" "+dp[days[i]]);
        }
        return dp[days[n-1]];
    }*/
}