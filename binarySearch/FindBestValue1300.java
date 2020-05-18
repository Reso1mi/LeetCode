public class FindBestValue1300{
    public static void main(String[] args) {

    }

    //憨憨二分解法
    public int findBestValue(int[] arr, int target) {
        int sum=0;
        int left=0,right=Integer.MIN_VALUE;
        for(int num:arr){
            sum+=num;
            right=Math.max(right,num);
        }
        //找第一个小于target的和第一个大于target的，比较diff
        int[] small=searchSmall(arr,left,right,target);
        int[] large=searchLarge(arr,left,right,target);
        return small[1]<=large[1]?small[0]:large[0];
    }
    
    public int[] searchSmall(int[] arr,int left,int right,int target){
        int res=left;
        int diff=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            int sum=getSum(arr,mid);
            if(sum<=target){
                res=mid;
                diff=target-sum;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return new int[]{res,diff};
    }
    
    public int[] searchLarge(int[] arr,int left,int right,int target){
        int res=right;
        int diff=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            int sum=getSum(arr,mid);
            if(sum>=target){
                res=mid;
                diff=sum-target;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return new int[]{res,diff};
    }
    
    public int getSum(int[] arr,int mid){
        int sum=0;
        for(int a:arr){
            sum+=a>mid?mid:a;
        }
        return sum;
    }

    //正常解法
    public int findBestValue(int[] arr, int target) {
        int sum=0;
        int left=0,right=Integer.MIN_VALUE;
        for(int num:arr){
            sum+=num;
            right=Math.max(right,num);
        }
        if(sum<=target) return right;
        int res=left;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(getSum(arr,mid)<=target){
                res=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        if(target-getSum(arr,res)<=getSum(arr,res+1)-target){
            return res;
        }
        return res+1;
    }

    public int getSum(int[] arr,int mid){
        int sum=0;
        for(int a:arr){
            sum+=a>mid?mid:a;
        }
        return sum;
    }
}