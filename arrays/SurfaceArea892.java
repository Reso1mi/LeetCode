public class SurfaceArea892{
    public static void main(String[] args) {

    }

    //二货做法
    public int surfaceArea(int[][] grid) {
        if(grid==null||grid.length<=0) return 0;
        int N=grid.length;
        int maxSumH=0;
        int maxSumL=0;
        int empty=0;
        int res=0;
        for (int i=0;i<N;i++) {
            int max1=0,max2=0;
            for(int j=0;j<N;j++){
                if(grid[i][j]==0){
                    empty++;
                }
                if(i<N-1 && i>=1 && grid[i][j] < grid[i-1][j] && grid[i][j] < grid[i+1][j]){
                    res+=Math.min(i>=1?(grid[i-1][j]-grid[i][j]):0,i<N-1?(grid[i+1][j]-grid[i][j]):0)*2;
                } 
                if(j<N-1 && j>=1 && grid[i][j] < grid[i][j-1] && grid[i][j] < grid[i][j+1]){
                    res+=Math.min(j>=1?(grid[i][j-1]-grid[i][j]):0,j<N-1?(grid[i][j+1]-grid[i][j]):0)*2;
                }
                max1=Math.max(max1,grid[i][j]);
                max2=Math.max(max2,grid[j][i]);
            }
            maxSumH+=max1;
            maxSumL+=max2;
        }
        return res+(N*N-empty)*2+(maxSumL+maxSumH)*2;
    }

    //加法思路
    public int surfaceArea(int[][] grid) {
        if(grid==null || grid.length<=0 ) return 0;
        int N=grid.length;
        int res=0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                //正面,背面暴露的面积
                res+= Math.max(j<N-1?grid[i][j+1]-grid[i][j]:grid[i][j],0);
                res+= Math.max(j>0?grid[i][j-1]-grid[i][j]:grid[i][j],0);
                //左和右边暴露的面积
                res+= Math.max(i<N-1?grid[i+1][j]-grid[i][j]:grid[i][j],0);
                res+= Math.max(i>0?grid[i-1][j]-grid[i][j]:grid[i][j],0);
                //上和下的面积
                res+= grid[i][j]!=0?2:0;
            }
        }
        return res;
    }

    //巧妙的减法思路
    public int surfaceArea(int[][] grid) {
        if(grid==null || grid.length<=0 ) return 0;
        int N=grid.length;
        int x=0,y=0,count=0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if(grid[i][j]!=0){
                    x+=grid[i][j]-1;
                    count+=grid[i][j];
                }
                if(i>=1 && grid[i-1][j]!=0){
                    y+=Math.min(grid[i][j],grid[i-1][j]);
                }
                if(j>=1 && grid[i][j-1]!=0){
                    y+=Math.min(grid[i][j],grid[i][j-1]);
                }
            }
        }
        return count*6-2*x-2*y;
    }
}