public class MinDifficulty1335{
    public static void main(String[] args) {

    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int jlen=jobDifficulty.length;
        if(jlen<d){
            return -1;
        }
        //dp[i][j]   第i天完成前j项任务的最低难度
        int[][] dp=new int[d][jlen];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int max=0;
        for(int j=0;j<jlen;j++){
            max=Math.max(max,jobDifficulty[j]);
            dp[0][j]=max;
        }
        for(int i=1;i<d;i++){
            for(int j=0;j<jlen;j++){
                for(int k=j-1;k>=i-1;k--){
                    dp[i][j]=Math.min(dp[i][j], dp[i-1][k]+maxDifficulty(jobDifficulty,k+1,j));
                }
            }
        }
        return dp[d-1][jlen-1];
    }

    public int maxDifficulty(int[] jobDifficulty,int left,int right){
        int max=jobDifficulty[left];
        for(int i=left;i<=right;i++){
            max=Math.max(max,jobDifficulty[i]);
        }
        return max;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int jlen=jobDifficulty.length;
        if(jlen<d){
            return -1;
        }
        //dp[i][j]   前i天完成前j项任务的最低难度
        int[][] dp=new int[d][jlen];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //预处理
        int[][] maxRange=new int[jlen][jlen];
        for(int i=0;i<jlen;i++){
            maxRange[i][i]=jobDifficulty[i];
            for (int j=i+1;j<jlen;j++) {
                maxRange[i][j]=Math.max(maxRange[i][j-1],jobDifficulty[j]);
            }
        }
        for(int j=0;j<jlen;j++){
            dp[0][j]=maxRange[0][j];
        }
        for(int i=1;i<d;i++){
            for(int j=0;j<jlen;j++){
                for(int k=j-1;k>=i-1;k--){
                    dp[i][j]=Math.min(dp[i][j], dp[i-1][k]+maxRange[k+1][j]);
                }
            }
        }
        return dp[d-1][jlen-1];
    }
}