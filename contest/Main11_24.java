public class Main11_24{
    public static void main(String[] args) {

    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int min=0;
        for (int i=0;i<points.length-1;i++) {
            min+= Math.max(Math.abs(points[i+1][0]-points[i][0]),Math.abs(points[i+1][1]-points[i][1]));
        }
        return min;
    }



    private int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};

    int count=0;

/*    public int countServers(int[][] grid) {
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (!visit[i][j] && grid[i][j]==1) {
                    dfs(grid,i,j,visit);            
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid,int x,int y,boolean[][] visit){
        visit[x][y]=true;
        for (int i=0;i<direction.length;i++) {
            for (int i=0;i<grid.length;i++) {
                int nx=x+direction[i][0];
                int ny=y+direction[i][1];
                if (isValid(grid,nx,ny) && !visit[nx][ny] && grid[nx][ny]==1) { 
                    count+=2;
                }
            }
        }
    }*/

    private boolean isValid(final int[][] grid,int x,int y){
        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
    }

    int count=0;

    public int countServers(int[][] grid) {
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]==1) {
                    check(grid,i,j,visit);
                }
            }
        }
        return count;
    }

    private void check(int[][] grid,int x,int y){
        for (int i=0;i<grid.length;i++) {
            if (i!=x && grid[i][y]==1) {
                count++;
                return;
            }
        }
        for (int i=0;i<grid[0].length;i++) {
            if (i!=y && grid[x][i]==1) {
                count++;
                return;
            }
        }
    }


    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieTree tt=new TrieTree();
        for (int i=0;i<products.length;i++) {
            tt.insert(products[i]);
        }
        List<List<String>> res=new ArrayList<>();
        for (int i=1;i<searchWord.length();i++) {
            String s=searchWord.substring(0,i);
            
        }
    }
}
