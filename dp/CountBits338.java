public class CountBits338{
    public static void main(String[] args) {

    }

    public int[] countBits(int num) {
        int[] res=new int[num+1];
        for (int i=1;i<=num;i++) {
            //如果i二进制以0结尾,那么i>>1的countBit和i一样,i&1=0
            //反之,那么i>>1的比i会少1个,i&1=1
            res[i]=res[i>>1]+(i&1);
        }
        return res;
    }

    public int[] countBits(int num) {
        int[] res=new int[num+1];
        for (int i=1;i<=num;i++) {
            res[i]=res[i&(i-1)]+1;
        }
        return res;
    }
}