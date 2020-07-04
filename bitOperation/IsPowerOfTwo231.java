public class IsPowerOfTwo231{
    public static void main(String[] args) {

    }

    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0; 
    }
}