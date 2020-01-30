public class HammingDistance461{
    public static void main(String[] args) {

    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

    public int hammingDistance(int x, int y) {
        int i=x^y;
        int count=0;
        while(i!=0){
            if ((i&1)==1) { //括号不能掉
                count++;
            }
            i=i>>1;
        }
        return count;
    }
}