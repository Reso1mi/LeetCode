public class MySqrt69{
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    //[0,x]  x
    public static int mySqrt(int x) {
        long left=0L,right=x;
        while(left<right){
            long mid=left+(right-left)/2+1;
            if (mid*mid>x) {
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return (int)right;
    }
}