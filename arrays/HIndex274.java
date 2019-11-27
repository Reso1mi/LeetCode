public class HIndex274{
    public static void main(String[] args) {

    }

    //3 0 6 1 5
    //0 1 3 5 6
    //
    //[12,2,12,13,22,231,45,789]
    //[2,12,12,13,22,45,231,789]
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int min=0;
        int count=0;
        for (int i=citations.length-1;i>=0;i--) {
            count++;
            min=citations[i];
            if (min<=count-1) {
                return count;
            }
        }
        return count;
    }
}