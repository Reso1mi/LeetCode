public class NumOfArrays1420{
    public static void main(String[] args) {

    }

    int mod=(int)1e9+7;

    Integer [][][] dp=null;

    public int numOfArrays(int n, int m, int k) {
        dp=new Integer[n+1][m+1][k+1];
        return dfs(n,0,m,k);
    }

    public int dfs(int pos,int preMax,int m,int k){
        if(k==0 && pos==0) return dp[pos][preMax][k]=1;
        //k=0但是pos不为0并没有结束,还可以继续找比preMax小的元素
        //if(pos==0 || k==0) return 0; 
        if(pos==0 || k<0) return 0;
        if(dp[pos][preMax][k]!=null){
            return dp[pos][preMax][k];
        }
        long res=0;
        for (int i=1;i<=m;i++) {
            if(i>preMax){ //大于preMax,代价-1,更新最大值
                res=(res+dfs(pos-1,i,m,k-1))%mod;
            }else{ //小于preMax,代价不变,最大值不变
                res=(res+dfs(pos-1,preMax,m,k))%mod;
            }
        }
        return dp[pos][preMax][k]=(int)(res%mod);
    }

    //记忆化递归优化
    int mod=(int)1e9+7;

    Long [][][] dp=null;

    public int numOfArrays(int n, int m, int k) {
        dp=new Long[n+1][m+1][k+1];
        return (int)dfs(n,0,m,k);
    }

    public long dfs(int pos,int preMax,int m,int k){
        if(k==0 && pos==0) return dp[pos][preMax][k]=1;
        //k=0但是pos不为0并没有结束,还可以继续找比preMax小的元素
        //if(pos==0 || k==0) return 0; 
        if(pos==0 || k<0) return 0;
        if(dp[pos][preMax][k]!=null){
            return dp[pos][preMax][k];
        }
        long res=0;
        res=(res+(preMax*dfs(pos-1,preMax,m,k))%mod)%mod;
        for (int i=preMax+1;i<=m;i++) {
            res=(res+dfs(pos-1,i,m,k-1))%mod;
        }
        return dp[pos][preMax][k]=res%mod;
    }


    //递推的方式
    public int numOfArrays(int n, int m, int k) {
        int mod=1000_000_007;

        long[][][] dp=new long[n+1][m+1][k+1];
        for(int i=1;i<=m;i++){
            dp[1][i][1]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int cost=1;cost<=k;cost++){
                    //新增加的元素小于等于j也就是原数组的最大值,对应上面递归的i<=preMax
                    //所以新增加的元素在新数组的末尾有1~j种选择
                    dp[i][j][cost]=(j*dp[i-1][j][cost])%mod;
                    for(int nm=1;nm<j;nm++){
                        //新增加的元素大于原数组的最大值j,对应上面递归的i>preMax
                        dp[i][j][cost]=(dp[i][j][cost]+dp[i-1][nm][cost-1])%mod;
                    }
                }
            }
        }
        long res=0;
        for(int i=1;i<=m;i++){
            res+=dp[n][i][k];
            res%=mod;
        }
        return (int)(res%mod);
    }
}