public class NumOfSubarrays1343{
    public static void main(String[] args) {

    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        threshold*=k;
        int sum=0;
        int count=0;
        for (int i=0;i<k;i++) {
            sum+=arr[i];
        }
        for (int i=k;i<arr.length;i++) {
            if (sum>=threshold) {
                count++;
            }
            //0 1 2 3
            sum+=arr[i];
            sum-=arr[i-k];
        }
        return count;
    }
}