public class MinTimeLCP12{
    public static void main(String[] args) {

    }

    public int minTime(int[] time, int m) {
        int left=0,right=0;//上界最多sum(time)
        for(int i=0;i<time.length;i++){
            right+=time[i];
        }
        int res=right+1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(check(time,mid,m)){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        //其实返回left就行了,主要是避免搞混
        return res; 
    }
    
    //核心的check
    public boolean check(int[] time,int T,int m){
        int day=1,sum=0,maxt=0;
        for (int t:time) {
            sum+=t;
            maxt=Math.max(maxt,t); //维护每一组的最大值
            if(sum-maxt>T){ //当前组减去最大值不满足
                day++;
                sum=t;
                maxt=t;
            }
        }
        return day<=m;
    }

    //weiwei的模板
    public int minTime(int[] time, int m) {
        int left=0,right=0;
        for(int i=0;i<time.length;i++){
            right+=time[i];
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(check(time,mid,m)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}