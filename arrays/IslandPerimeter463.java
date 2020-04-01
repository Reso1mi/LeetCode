public class IslandPerimeter463{

    //和892类似的解法，简化版
    public int islandPerimeter(int[][] grid) {
        int count=0;
        int left=0,up=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(i-1>=0 && grid[i-1][j]==1){
                        up++;
                    }
                    if(j-1>=0 && grid[i][j-1]==1){
                        left++;
                    }
                    count++;
                }
            }
        }
        return count*4-(up+left)*2;
    }
}