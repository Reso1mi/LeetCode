public class MaxDistance5489 {
    public static void main(String[] args) {

    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = (int)1e9+1;
        int res = 1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (check(position, m, mid)) {
                res = mid;
                left = mid + 1; 
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
    //1  1000 2000 3000 m=3
    //验证在距离至少为force的情况下能否放下所有的球，然后增大force逼近答案
    //所以check验证成功的不一定是合法的答案，但是最终一定会到达real ans
    //类似【378. 有序矩阵中第K小的元素】这道题
    public boolean check(int[] position, int m, int force) {
        int last = position[0];
        m--;
        for (int i = 1; i < position.length; i++) {
            if (position[i]-last < force) {
                continue;
            }
            last = position[i];
            m--;
            if (m==0) return true;
        }
        return false;
    }
}