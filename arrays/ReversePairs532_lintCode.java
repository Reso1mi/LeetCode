public class ReversePairs532_lintCode{
    public static void main(String[] args) {
        ReversePairs532_lintCode r=new ReversePairs532_lintCode();
        int[] A={2,4,1,3,5};
        System.out.println(r.reversePairs(A));
    }
    public long reversePairs(int[] A) {
        if (A==null || A.length<=0) {
            return 0;
        }
        return reversePairs(A,0,A.length-1);
    }

    public long reversePairs(int[] A,int left,int right) {
        if (left == right) {
            return 0;
        }
        int mid=left+(right-left)/2;
        long l=reversePairs(A,left,mid);
        long r=reversePairs(A,mid+1,right);
        return merge(A,left,mid,right)+l+r;
    }

    public long merge(int[] nums,int left,int mid,int right){
        long res=0;
        int[] help=new int[right-left+1];
        int i=left,j=mid+1;
        int index=0;
        while(i<=mid && j<=right){
            //小于等于的时候让i先进栈
            //help[index++]=nums[i]<=nums[j] ? nums[i++]:nums[j++];
            if (nums[i]<=nums[j]) {
                help[index++] = nums[i++];
            }else{
                help[index++] = nums[j++];
                res+= mid-i+1; //j和i-mid间的所有元素形成逆序对
            }
        }
        while(i<=mid){
            help[index++]=nums[i++];
        }
        while(j<=right){
            help[index++]=nums[j++];
        }

        for (int k=0;k<help.length;k++) {
            nums[left+k]=help[k];
        }
        return res;
    }

}