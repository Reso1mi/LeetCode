public class FindMedianSortedArrays4{
    public static void main(String[] args) {
        
    }

    //find nums1+nums2 /2 大的数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int leftMid=(m+n+1)/2;
        int rightMid=(m+n+2)/2;
        return (findMedian(nums1,0,m-1,nums2,0,n-1,leftMid) + findMedian(nums1,0,m-1,nums2,0,n-1,rightMid)) * 0.5;
    }
    //    i
    //1 2 3 5
    //    j
    //1 2 4 6 7 8 9     k=6 find k/2=3
    //
    //        i
    //*1 2 3* 5
    //j 
    //1 2 4 6 7 8 9     k=3 find k/2=1  res=4
    public double findMedian(int[] nums1,int left1,int right1, int[] nums2,int left2,int right2,int k) {
        int len1=right1-left1+1;
        int len2=right2-left2+1;
        if (len1==0) {
            return nums2[left2+k-1];
        }
        if (len2==0) {
            return nums1[left1+k-1];
        }
        if (k==1) {
            return Math.min(nums1[left1],nums2[left2]);
        }
        int i=left1+Math.min(len1,k/2)-1;
        int j=left2+Math.min(len2,k/2)-1;
        if (nums1[i] < nums2[j]) {
            return findMedian(nums1,i+1,right1,nums2,left2,right2,k-(i-left1+1));
        }else{
            return findMedian(nums1,left1,right1,nums2,j+1,right2,k-(j-left2+1));
        }
    }
}