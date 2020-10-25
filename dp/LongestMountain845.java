public class LongestMountain845{
    public static void main(String[] args) {

    }

    public int longestMountain(int[] A) {
        int res = 0;
        int up = 0, down = 0;
        //[2,1,4,7,3,2,5]
        for (int i = 1; i < A.length; i++) {
            //前面是下降，这里开始增加或者和前一个元素相同，需要重置
            if ((down > 0 && A[i] > A[i-1]) || A[i] == A[i-1]) {
                up = down = 0;
            }
            up += A[i] > A[i-1] ? 1 : 0;
            down += A[i] < A[i-1] ? 1 : 0;
            if (up > 0 && down > 0) {
                res = Math.max(res, up+down+1);   
            }
        }
        return res;
    }
}