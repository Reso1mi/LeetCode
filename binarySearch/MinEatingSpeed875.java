public class MinEatingSpeed875{
    public static void main(String[] args) {

    }

    //二分答案
    public int minEatingSpeed(int[] piles, int H) {
        int max=0;
        for(int p:piles) max=Math.max(max,p);
        int left=1,right=max;
        int res=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(piles,mid,H)){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }
    
    public boolean check(int[] piles,int k,int H){
        int count=0;
        for(int p:piles) count+=(p-1)/k+1; //向上取整
        return count<=H;
    }
}