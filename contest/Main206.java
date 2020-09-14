public class Main206 {
    public static void main(String[] args) {
        
    }

    //[[1,3,2],[2,3,0],[1,0,3],[1,0,2]]
    //[[2,1],[3,0]]
    /*
    6
    [[1,4,3,2,5],[0,5,4,3,2],[3,0,1,5,4],[2,1,4,0,5],[2,1,0,3,5],[3,4,2,0,1]]
    [[3,1],[2,0],[5,4]]
     */
    //x,y pair[0],x > pair[0],pair[1] && x,pair[0] > x,y
    public int unhappyFriends(int n, int[][] pref, int[][] pair) {
        int res = 0;
        for (int i = 0; i < pair.length; i++) {
            //亲密度从高到底
            boolean flag1 = false;
            boolean flag2 = false;
            for (int j = 0; j < pair.length; j++) {
                if (!flag1 && j!=i && (check(pref, pair[i][0],pair[i][1], pair[j][0],pair[j][1]) || 
                    check(pref, pair[i][0],pair[i][1], pair[j][1],pair[j][0]))) {
                    res++;
                    flag1 = true;
                }
                //1,2 3,0
                if (!flag2 && j!=i && (check(pref, pair[i][1],pair[i][0], pair[j][0],pair[j][1]) ||
                    check(pref, pair[i][1],pair[i][0], pair[j][1],pair[j][0]))) {
                    res++;
                    flag2 = true;
                }
            }
        }
        return res;
    }

    public boolean check(int[][] pref, int x, int y, int p0, int p1) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < pref[p0].length; i++) {
            if (pref[p0][i] == x) {
                a = i;
            }
            if (pref[p0][i] == p1) {
                b = i;
            }
        }
        int aa = 0;
        int bb = 0;
        for (int i = 0; i < pref[x].length; i++) {
            if (pref[x][i] == p0) {
                aa = i;
            }
            if (pref[x][i] == y) {
                bb = i;
            }
        }
        return a < b && aa < bb;
    }
}