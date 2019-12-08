public class Main12_1{
    public static void main(String[] args) {

    }

    public String tictactoe(int[][] moves) {
        int[][] m=new int[3][3];
        for (int i=0;i<moves.length;i++) {
            int x=moves[i][0],y=moves[i][1];
            m[x][y]= i%2==0?1:-1;

            if (x==0 && m[x][y]==m[x+1][y] &&m[x][y]==m[x+2][y]) {
                return m[x][y]==1?"A":"B";
            }

            if (x==1 && m[x][y]==m[x-1][y] &&m[x][y]==m[x+1][y]) {
                return m[x][y]==1?"A":"B";
            }

            if (x==2 && m[x][y]==m[x-1][y] &&m[x][y]==m[x-2][y]) {
                return m[x][y]==1?"A":"B";
            }

            if (y==0 && m[x][y]==m[x][y+1] &&m[x][y]==m[x][y+2]) {
                return m[x][y]==1?"A":"B";
            }

            if (y==1 && m[x][y]==m[x][y+1] &&m[x][y]==m[x][y-1]) {
                return m[x][y]==1?"A":"B";
            }

            if (y==2 && m[x][y]==m[x][y-1] &&m[x][y]==m[x][y-2]) {
                return m[x][y]==1?"A":"B";
            }

            if (x==y&&x==1 && m[x][y]==m[x-1][y-1] && m[x+1][y+1]==m[x][y]) {
                return m[x][y]==1?"A":"B";   
            }

            if (x==y&&x==0 && m[x][y]==m[x+1][y+1] && m[x+2][y+2]==m[x][y]) {
                return m[x][y]==1?"A":"B";   
            }

            if (x==y&&x==2 && m[x][y]==m[x-1][y-1] && m[x-2][y-2]==m[x][y]) {
                return m[x][y]==1?"A":"B";   
            }

            if (x+y==2&&x==0 && m[x][y]==m[x+2][y-2] && m[x+1][y-1]==m[x][y]) {
                return m[x][y]==1?"A":"B";   
            }

            if (x+y==2&&x==1 && m[x][y]==m[x+1][y-1] && m[x-1][y+1]==m[x][y]) {
                return m[x][y]==1?"A":"B";   
            }

            if (x+y==2&&x==2 && m[x][y]==m[x-2][y+2] && m[x-1][y+1]==m[x][y]) {
                return m[x][y]==1?"A":"B";   
            }
        }
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (m[i][j]==0) {
                    return "Pending";
                }
            }
        }
        return "Draw";
    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res=new LinkedList<>();
        if (cheeseSlices>tomatoSlices || tomatoSlices%2==1) {
            return res;
        }
        if((4*cheeseSlices-tomatoSlices)%2==0){
            int small=(4*cheeseSlices-tomatoSlices)/2;
            int big=cheeseSlices-small;
            if (big>=0 && small>=0) {
                res.add(big);   
                res.add(small);
            }
        }
        return res;
    }
}