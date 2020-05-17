public class MaxSideLength1292{
    public static void main(String[] args) {
        MaxSideLength1292 m = new MaxSideLength1292();
        int[][] mat={{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        System.out.println(m.maxSideLength(mat,4));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int left=1,right=Math.min(m,n);
        //核心公式
        //sum([x1,y1]->[x2,y2])
        //= P[x2][y2]-P[x2][y1-1]-P[x1-1][y2]+P[x1-1][y1-1]
        //==> mat[i][j]=P[i][j]-P[i-1][j]-P[j-1][i]+P[i-1][j-1]
        int[][] dp=new int[m+1][n+1];
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                dp[i][j]=mat[i-1][j-1]+dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
            }
        }
        int res=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(mat,mid,threshold,dp)){
                res=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return res;
    }
    
    public boolean check(int[][] mat,int side,int threshold,int[][] dp){
        //枚举所有的左端点
        for (int i=1;i+side-1<=mat.length;i++) {
            for (int j=1;j+side-1<=mat[0].length;j++) {
                int ri=i+side-1,rj=j+side-1;
                //System.out.println(ri+","+rj+" dp:"+ dp[ri][rj]);
                if(dp[ri][rj]-dp[i-1][rj]-dp[ri][j-1]+dp[i-1][j-1]<=threshold){
                    return true;
                }
            }
        }
        return false;
    }
}