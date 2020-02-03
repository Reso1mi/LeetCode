public class HIndex274{
    public static void main(String[] args) {

    }

    //3 0 6 1 5
    //6 5 3 2 1
    //
    //[12,2,12,13,22,231,45,789]
    //[2,12,12,13,22,45,231,789]
    public int hIndex(int[] citations) {
        int len=citations.length;
        Arrays.sort(citations);
        int count=0;
        for (int i=len-1;i>=0;i--) {
            if (citations[i]<=len-(i+1)) {
                return len-(i+1);
            }
        }
        return len;
    }
}