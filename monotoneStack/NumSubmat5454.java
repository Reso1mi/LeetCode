public class NumSubmat5454{
    //解法一: N3
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //预处理mat[i][j]上边有多少个连续的1
        int[][] upCnt= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 1){
                    upCnt[i][j] = i==0 ? mat[i][j]&1 : upCnt[i-1][j]+1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 1){
                    int k = j;
                    int rowCnt = upCnt[i][j];
                    while(k>=0){
                        rowCnt = Math.min(rowCnt, upCnt[i][k]);
                        res += rowCnt;
                        k--;
                    }
                }
            }
        }
        return res;
    }

    //单调栈优化 O(MN)
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //预处理mat[i][j]上边有多少个连续的1
        int[][] upCnt= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 1){
                    upCnt[i][j] = i==0 ? mat[i][j]&1 : upCnt[i-1][j]+1;
                }
            }
        }
        //单调递增栈维护列的长度
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            stack.clear();
            int ijCnt = 0; //以i,j为右下角的矩形的cnt
            for (int j = 0; j < n; j++) {
                ijCnt += upCnt[i][j];
                while(!stack.isEmpty() && upCnt[i][stack.peek()] > upCnt[i][j]){
                    int cur = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    //减去多的部分
                    ijCnt -= (cur-left) * (upCnt[i][cur] - upCnt[i][j]);
                }
                stack.push(j);
                res += ijCnt;
            }
        }
        return res;
    }

    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        //预处理mat[i][j]上边有多少个连续的1
        int[][] upCnt= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 1){
                    upCnt[i][j] = i==0 ? mat[i][j]&1 : upCnt[i-1][j]+1;
                }
            }
        }
        //单调递增栈维护列的长度
        Deque<int[]> stack = new ArrayDeque<>();
        int res = 0;
        for(int i = 0;i < m; i++){
            stack.clear();
            for (int j = 0; j < n; j++) {
                while(!stack.isEmpty() && upCnt[i][stack.peek()[0]] > upCnt[i][j]){
                    stack.pop();
                }
                int[] pair = stack.isEmpty() ? new int[]{-1,0} : stack.peek();
                //以当前栈顶元素mat[i][pair[0]]为右下角能形成矩形个数
                int cur = (j-pair[0]) * upCnt[i][j] + pair[1];
                res += cur;
                //将mat[i][j]的索引j和以其为右下角形成的矩阵个数cur存入单调栈
                stack.push(new int[]{j, cur});
            }
        }
        return res;
    }
}