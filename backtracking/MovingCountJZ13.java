public class MovingCountJZ13{
    public static void main(String[] args) {
        MovingCountJZ13 m=new MovingCountJZ13();
        System.out.println(m.movingCount(2,3,1));
        //a(0,0) a(0,1) a(0,2)
        //a(1,0) a(1,1) a(1,2)
        System.out.println(m.movingCount(3,1,0));
        System.out.println(m.movingCount(3,2,2));
        System.out.println(m.movingCount(7,2,3));
        //a(0,0) a(0,1)
        //a(1,0) a(1,1)
        //a(2,0) a(2,1)
        //a(3,0) a(3,1)
        //a(4,0) a(4,1)
        //a(5,0) a(5,1)
        //a(6,0) a(6,1)
    }

    private int[][] direction={{1,0},{0,1},{0,-1},{-1,0}};

    public int movingCount(int m, int n, int k) {
        return dfs(m,n,0,0,k,new boolean[m][n]);   
    }

    public int dfs(int m,int n,int x,int y,int k,boolean[][] visit){
        visit[x][y]=true;
        int res=1;
        for (int i=0;i<direction.length;i++) {
            int nx=x+direction[i][0];
            int ny=y+direction[i][1];
            if(valid(m,n,nx,ny,k) && !visit[nx][ny]){
                //以为是求最长的距离.....
                //res=Math.max(dfs(m,n,nx,ny,k,visit)+1,res);
                res+=dfs(m,n,nx,ny,k,visit);
            }
        }
        //visit[x][y]=false;
        return res;
    }

    public boolean valid(int m,int n,int x,int y,int k){
        if(x<0 || x>=m || y<0 || y>=n){
            return false;
        }
        int res=0;
        //35 37
        while(x!=0){
            res+=(x%10);
            x/=10;
        }
        while(y!=0){
            res+=(y%10);
            y/=10;
        }
        return res<=k;
    }
}