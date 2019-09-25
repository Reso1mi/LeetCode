import java.util.*;

public class  NumSquares279{
    public static void main(String[] args) {
        System.out.println(numSquares(9));
    }
    // 1    1
    // 2    1 1s
    // 3    1 1 1
    // 4    4               [1,4,9,16,25,36,49]
    // 5    4 1
    // 6    4 1 1 
    // 7    4 1 1 1 
    // 8    4 4
    // 9    9
    // 10   9 1
    // 11   9 1 1
    // 12   4 4 4   
    // 13   4 9     
    // 14   4 9 1   (5 9)
    // 15   4 9 1 1 (6 9)
    // 16   4 4 4 4
    // 17   9 4 4
    // 18   9 9
    // dp[i] =min(dp[i],i^2 +dp[i-i^2]);
    public static int numSquares(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        for (int i=1;i<=n;i++) {
            dp[i]=i; //dp[i]初始化,最坏解就是i,只能分解为1的平方的和
            for (int j=1;i>=j*j;++j){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static int numSquares2(int n) {
        Queue<Pair> queue=new LinkedList<>();
        boolean[] visit=new boolean[n+1];
        queue.add(new Pair(n,0));
        visit[n]=true;
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            int num=pair.num;
            int step=pair.step;
            if (num==0) {
                return step;
            }
            for (int i=1;i*i<=num;i++) {
                int temp=num-i*i;
                if (!visit[temp]) {
                    queue.add(new Pair(temp,step+1));
                    visit[temp]=true;
                }
            }
        }
        return -1;
    }

    static class Pair{
        public int step;
        public int num;
        public Pair(int num,int step){
            this.num=num;
            this.step=step;
        }
    }
}