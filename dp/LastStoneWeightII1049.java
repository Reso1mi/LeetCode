public class LastStoneWeightII1049{
    public static void main(String[] args) {

    }

    //天真的错误解法 74 / 82 个通过测试用例
    //[21,26,31,33,40] ->[7,21,26,31] -> [5,7,21] -> [5,14] ->[9]
    //[21,26,31,33,40] ->[19,26,31,33]->[5]
    public int lastStoneWeightII(int[] stones) {
        if(stones==null ||stones.length<=0){
            return 0;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<stones.length;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int y=pq.poll();
            int x=pq.poll();
            pq.add(y-x);
        }
        return pq.poll();
    }

    //突然想通了，其实和前面的有一题有点像
    //   sum   = psum + nsum
    //  target = psum - nsum  (psum >= nsum)
    //  sum+target = 2*psum
    //  target = 2*psum-sum
    //  2*psum-sum>=0
    //  psum>=sum/2
    //  sum-nsum >= sum/2
    //  nsum <= sum/2
    public int lastStoneWeightII(int[] stones) {
        if(stones==null ||stones.length<=0){
            return 0;
        }
        int n=stones.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=stones[i];
        }
        //背包容量为sum/2,求最多能装多少,经典的01背包
        int amount=sum/2;
        int[] dp=new int[amount+1];
        for (int i=0;i<stones.length;i++) {
            for (int j=amount;j>=stones[i];j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        //nsum=dp[amount]
        //target=psum-nsum = sum-nusm-nsum
        //wrong: return (amount-dp[amount])*2;
        //return sum%2==0?(amount-dp[amount])*2:(amount-dp[amount])*2+1
        return sum-2*dp[amount];
    }


    //记忆化递归
    Integer[][] dp=null;

    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int i=0;i<stones.length;i++) {
            sum+=stones[i];
        }
        dp=new Integer[stones.length+1][sum];
        return 2*dfs(stones,0,0,sum)-sum;
    }

    public int dfs(int[] stones,int index,int psum,int sum){
        if(2*psum>=sum){
            return psum;
        }
        if(dp[index][psum]!=null){
            return dp[index][psum];
        }
        int min=Integer.MAX_VALUE;
        for (int i=index;i<stones.length;i++) {
            min=Math.min(dfs(stones,i+1,psum+stones[i],sum),min);
        }
        return dp[index][psum]=min;
    }
}