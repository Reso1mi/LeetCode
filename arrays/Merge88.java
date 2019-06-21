public class Merge88{

	public static void main(String[] args) {
		

	}

	//复习归并merge
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums1.length<=0||nums2.length<=0){
			return;
		}
		int []res=new int[m+n];
		int i1=0,i2=0;
		for(int i=0;i1<m&&i2<n;i++) {
			if(nums1[i1]<=nums2[i2]) {
				res[i]=nums1[i1++];
			}else if(nums1[i1]>nums2[i2] ){
				res[i]=nums2[i2++];
			}
		}
		if(i1>=m){
			System.arraycopy(nums2,i2,res,i2+m,n-i2);
		}else{
			System.arraycopy(nums1,i1,res,i1+n,m-i1);
		}
		System.arraycopy(res,0,nums1,0,res.length);
	}

	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		if(nums1.length<=0||nums2.length<=0){
			return;
		}
		int []res=new int[m+n];
		int i1=0,i2=0;
		for(int i=0;i<m+n;i++) {
			if(i1>m){
				res[i]=nums2[i2++];
			}else if(i2>n){
				res[i]=nums1[i1++];
			}else if(nums1[i1]<=nums2[i2]) {
				res[i]=nums1[i1++];
			}else if(nums1[i1]>nums2[i2] ){
				res[i]=nums2[i2++];
			}
		}
		System.arraycopy(res,0,nums1,0,res.length);
	}

	//no extra memery
	public static void merge3(int[] nums1, int m, int[] nums2, int n) {
		if(nums1.length<=0||nums2.length<=0){
			return;
		}
		int i1=m-1,i2=n-1;
		for(int i=m+n-1;i>=0;i--) {
			if(i1<0){
				nums1[i]=nums2[i2--];
			}else if(i2<0){
				nums1[i]=nums1[i1--];
			}else if(nums1[i1]>nums2[i2]) {
				nums1[i]=nums1[i1--];
			}else if(nums1[i1]<=nums2[i2] ){
				nums1[i]=nums2[i2--];
			}
		}
	}

}