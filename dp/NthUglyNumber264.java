import java.util.*;
public class NthUglyNumber264{
    public static void main(String[] args) {
        NthUglyNumber264 n=new NthUglyNumber264();
        System.out.println(n.nthUglyNumber4(10));
    }
    
    //小根堆的方式,朴素去重TLE
    public int nthUglyNumber2(int n) {
        PriorityQueue<Long> queue=new PriorityQueue<>();
        n-=1;
        long base=1;
        while(n>0){
            queue.add(base*2);
            queue.add(base*3);
            queue.add(base*5);
            long temp=base;
            base=queue.poll();
            if(base!=temp){
                n--;
            }
        }
        return (int)base;
    }

    //去重
    public int nthUglyNumber3(int n) {
        PriorityQueue<Long> queue=new PriorityQueue<>();
        n-=1;
        long base=1;
        while(n-- >0){
            queue.add(base*2);
            queue.add(base*3);
            queue.add(base*5);
            base=queue.poll();
            while(!queue.isEmpty()&&base==queue.peek()){
                queue.poll();
            }
        }
        return (int)base;
    }

    //HashSet去重
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> queue=new PriorityQueue<>();
        HashSet<Long> set=new HashSet<>();
        long base=1;
        long[] ugly={2,3,5};
        n-=1;
        set.add(1L);
        while(n-->0){
            for(int i=0;i<3;i++){
                if (!set.contains(ugly[i]*base)) {
                    queue.add(ugly[i]*base);
                    set.add(ugly[i]*base);
                }
            }
            base=queue.poll();
        }
        return (int)base;
    }

    //类似动态规划的解法
    public int nthUglyNumber4(int n) {
        int[] dp=new int[n];
        dp[0]=1;
        int index1=0,index2=0,index3=0;
        for (int i=1;i<n;i++) {
            dp[i]=Math.min(dp[index1]*2,Math.min(dp[index2]*3,dp[index3]*5));
            index1+=(dp[index1]*2==dp[i]?1:0);
            index2+=(dp[index2]*3==dp[i]?1:0);
            index3+=(dp[index3]*5==dp[i]?1:0);
        }
        return dp[n-1];
    }
}