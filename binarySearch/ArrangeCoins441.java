public class ArrangeCoins441{
    public static void main(String[] args) {

    }

    //二分答案
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        int res = 0;
        while(left <= right){
            long mid = left + (right - left)/2;
            long sum = (1 + mid) * mid / 2;
            if(sum <= n){
                res = (int)mid;
                left = (int)mid + 1;
            }else{
                right = (int)mid - 1;
            }
        }
        return res;
    }
}