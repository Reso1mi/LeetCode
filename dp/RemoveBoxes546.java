public class RemoveBoxes546{
    public static void main(String[] args) {

    }

    /*
    [1, 3, 2, 2, 2, 3, 4, 3, 1] 
    ----> [1, 3, 3, 4, 3, 1] (3*3=9 分) 
    ----> [1, 3, 3, 3, 1] (1*1=1 分) 
    ----> [1, 1] (3*3=9 分) 
    ----> [] (2*2=4 分)
     */
    //WA了
    //46 / 60 个通过测试用例
    public int removeBoxes2(int[] boxes) {
        if (boxes==null || boxes.length<=0) {
            return 0;
        }
        int N=boxes.length;
        int[][] dp=new int[N][N];
        for (int i=0;i<N;i++) {
            dp[i][i]=1;
        }
        for (int len=2;len<=N;len++) {
            for (int left=0;left+len-1<N;left++) {
                int right=left+len-1;
                //至少是前一区间+1
                dp[left][right]=dp[left][right-1]+1;
                int k=0; //有多少个right
                for (int i=left;i<right;i++){
                    if(boxes[i]==boxes[right]) k++;
                }
                if(k==0) continue;
                //特判一下
                if(boxes[right]==boxes[left]){
                    dp[left][right]=Math.max(dp[left][right-1]+2*k+1,dp[left][right]);
                }
                for (int i=left+1;i<right && k>0;i++) {
                    if(boxes[i]==boxes[right]){
                        //1, 3, 2, 3, 4 | 3
                        //(k+1)*(k+1)-k*k=2*k+1
                        dp[left][right]=Math.max(dp[left][right],dp[left][i-1]+dp[i][right-1]+2*k+1);
                        k--;
                    }
                }
            }
        }
        return dp[0][N-1];
    }

    public int removeBoxes(int[] boxes) {
        if (boxes==null || boxes.length<=0) {
            return 0;
        }
        int N=boxes.length;
        int[][] dp=new int[N+1][N+1];
        for (int i=0;i<=N;i++) {
            dp[i][i]=1;
        }
        for (int len=2;len<=N;len++) {
            for (int left=1;left+len-1<=N;left++) {
                int right=left+len-1;
                //至少是前一区间+1
                dp[left][right]=dp[left][right-1]+1;
                int k=0; //有多少个right
                for (int i=left;i<right;i++){
                    if(boxes[i-1]==boxes[right-1]) k++;
                }
                for (int i=left;i<right && k>0;i++) {
                    if(boxes[i-1]==boxes[right-1]){
                        //1, 3, 2, 3, 4 | 3
                        //(k+1)*(k+1)-k*k=2*k+1
                        dp[left][right]=Math.max(dp[left][right],dp[left][i-1]+dp[i][right-1]+2*k+1);
                        k--;
                    }
                }
            }
        }
        return dp[1][N];
    }

    //不行了GG,好难,以后再做吧
}