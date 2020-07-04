public class HammingWeight191{
    public static void main(String[] args) {

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
        //while(n>0){
            n&=(n-1);
            count++;
        }
        return count;
    }

    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if((n&1)==1) 
                count++;
            n>>>=1; //无符号右移,避免添高位添1死循环
        }
        return count;
    }
}