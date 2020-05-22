public class SplitArray410{
    public static void main(String[] args) {

    }

    //一样的套路
    public int splitArray(int[] nums, int m) {
        long left=0,right=0;
        for(int num:nums){
            left=Math.max(left,num);
            right+=num;
        }
        long res=0;
        while(left<=right){
            long mid=left+(right-left)/2;
            if(check(nums,mid,m)){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return (int)res;
    }
    
    public boolean check(int[] nums,long limit,int m){
        long sum=0;
        int count=1;
        for(int num:nums){
            if(sum+num>limit){
                sum=0;
                count++;
            }
            sum+=num;
        }
        return count<=m;
    }
}