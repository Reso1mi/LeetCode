import java.util.*;
import javafx.util.Pair;
public class EraseOverlapIntervals435{
    public static void main(String[] args) {
        EraseOverlapIntervals435 e=new EraseOverlapIntervals435();
        System.out.println(e.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }

    //[1,2] [2,3] [3,4] [1,3]
    //[1,3] [1,2] [2,3] [3,4]
/*    static class Key{
        int index;
        int prev;

        public Key(int index,int prev){
            this.index=index;
            this.prev=prev;
        }

        public boolean equals(Object obj){
            Key key=(Key)obj;
            return key.index==this.index && key.prev==this.prev;
        }

        public int hashCode(){
            return Objects.hash(index,prev);
        }
    }*/

    //记忆化递归 TLE
    HashMap<Pair,Integer> cache=new HashMap<>();
    
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        return intervals.length-dfs(intervals,0,Integer.MIN_VALUE);
    }

    //背包问题,返回最多可以留下的区间
    public int dfs(int[][] intervals,int index,int prev) {
        if (index==intervals.length) {
            return 0;
        }
        Pair key=new Pair(index,prev);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int res=dfs(intervals,index+1,prev);
        if (intervals[index][0]>=prev) {
            res=Math.max(res,dfs(intervals,index+1,intervals[index][1])+1);
        }
        cache.put(key,res);
        return res;
    }

    //递推的方式
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals==null || intervals.length<=0) {
            return 0;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[]dp=new int[intervals.length];
        int max=-1;
        for (int i=0;i<intervals.length;i++) {
            dp[i]=1;
            for (int j=0;j<i;j++) {
                if(intervals[i][0]>=intervals[j][1]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return intervals.length-max;
    }
}