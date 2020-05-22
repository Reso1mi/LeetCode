public class ShortestBridg934{
    public static void main(String[] args) {

    }


    int[] dir = {0, 1, 0, -1, 0};

    public int shortestBridge(int[][] A) {
        boolean[][] mark = new boolean[A.length][A[0].length];
        lable:
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, mark);
                    break lable;
                }
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && mark[i][j]) {
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dir[i];
                int ny = pair.y + dir[i + 1];
                if (valid(A, nx, ny) && !mark[nx][ny]) {
                    if (A[nx][ny] == 1) {
                        return pair.step;
                    }
                    mark[nx][ny] = true;
                    queue.add(new Pair(nx, ny, pair.step + 1));
                }
            }
        }
        return 1;
    }

    public void dfs(int[][] A, int x, int y, boolean[][] mark) {
        mark[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i];
            int ny = y + dir[i + 1];
            if (valid(A, nx, ny) && A[nx][ny] == 1 && !mark[nx][ny]) {
                dfs(A, nx, ny, mark);
            }
        }
    }

    public boolean valid(int[][] A, int x, int y) {
        return x >= 0 && x < A.length && y >= 0 && y < A[0].length;
    }

    class Pair {
        int x, y;
        int step;
        public Pair(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}