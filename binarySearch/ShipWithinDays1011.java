public class ShipWithinDays1011{
    public static void main(String[] args) {

    }

    public int shipWithinDays(int[] weights, int D) {
        int sum=0,max=0;
        for(int w:weights){
            max=Math.max(w,max);
            sum+=w;
        }
        int left=Math.max(sum/D,max),right=sum;
        int res=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(weights,mid,D)){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
    
    public boolean check(int[] weights,int load,int D){
        int temp=0;
        for(int w:weights){
            if(temp+w>load){
                temp=0;
                D--;
            }
            temp+=w;
        }
        //return D>=0;
        return D>0;
    }

    //之前的二分模板
    public int shipWithinDays(int[] weights, int D) {
        int sum=0,max=0;
        for(int w:weights){
            max=Math.max(w,max);
            sum+=w;
        }
        int left=Math.max(sum/D,max),right=sum;
        int res=0;
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(weights,mid,D)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}