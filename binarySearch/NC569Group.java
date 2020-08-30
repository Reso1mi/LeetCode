public class NC569Group {
    public static void main(String[] args) {

    }

    //最小值最大
    public int solve (int n, int k, int[] a) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < a.length; i++) {
            left = Math.min(left, a[i]);
            right += a[i];
        }
        int res = 0;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (check(mid, a, k)) {
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }

    //分为k组能否保证每组都大于等于mid
    public boolean check(int mid, int[] a, int k) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum >= mid) {
                sum = 0;
                count++;
            }
        }
        return count >= k;
    }
}