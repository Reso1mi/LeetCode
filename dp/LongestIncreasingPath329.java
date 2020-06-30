public class LongestIncreasingPath329{
    public static void main(String[] args) {

    }

    int [][] dir ={{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    Integer [][] cache = null;
    
    //记忆化递归，数组递推的方式状态转移方向不明确，需要排序
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length <=0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        cache = new Integer[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }
    
    public int dfs(int[][] matrix, int x, int y){
        if (cache[x][y] != null){
            return cache[x][y];
        }
        int res = 1;
        for (int i = 0; i < dir.length; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (valid(matrix, nx, ny) && matrix[nx][ny] > matrix[x][y]){
                res = Math.max(res, dfs(matrix, nx, ny)+1);
            }
        }
        return cache[x][y] = res;
    }
    
    public boolean valid(int[][] matrix, int x, int y){
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length; 
    }
}