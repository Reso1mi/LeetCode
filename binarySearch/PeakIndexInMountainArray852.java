public class PeakIndexInMountainArray852{
    public static void main(String[] args) {
        int[] nums={18,29,38,59,98,100,99,98,90};
        peakIndexInMountainArray(nums);
    }

    public static int peakIndexInMountainArray(int[] A) {
        int left=0,right=A.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            //System.out.println(mid);
            if (mid>0 && mid<A.length && A[mid] > A[mid-1] && A[mid]<A[mid+1]) {
                left=mid+1;
            }else if (mid>0 && mid<A.length && A[mid]< A[mid-1] && A[mid]>A[mid+1]){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return left;
    }
}