public class Makesquare473{
    public static void main(String[] args) {

    }

    //等价于能否将nums分为4等分
    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length<4){
            return false;
        }
        int N=nums.length;
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=nums[i];
        }
        if(sum%4!=0) return false;
        int[] side=new int[4];
        Arrays.sort(nums);
        return dfs(nums,N-1,side,sum/4);
    }

    public boolean dfs(int[] nums,int index,int[] side,int avg){
        if(index==-1){
            return true;
        }
        for(int i=0;i<side.length;i++){
            //if(side[i]+nums[index]<=avg){
            int rest=avg-side[i]-nums[index];
            if(rest==0 || rest>=nums[0]){ //改进剪枝方式
                side[i]+=nums[index];
                if(dfs(nums,index-1,side,avg)){
                    return true;
                }
                side[i]-=nums[index];
            }
        }
        return false;
    }

    //状压DP,算了,下面的是错的,模仿的官方题解,但是WA了
    //没必要,又不打比赛
    Boolean[][] dp=null;

    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length<4){
            return false;
        }
        int N=nums.length;
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=nums[i];
        }
        if(sum%4!=0) return false;
        int[] side=new int[4];
        Arrays.sort(nums);
        dp=new Boolean[1<<N][5];
        return dfs(nums,N-1,0,side,sum/4);
    }

    public boolean dfs(int[] nums,int index,int state,int[] side,int avg){
        int cnt=0;
        for (int i=0;i<4;i++) cnt+=(side[i]==avg?1:0);
        if(index==-1){
            return dp[state][cnt]=cnt==4;
        }
        if(dp[state][cnt]!=null){
            return dp[state][cnt];
        }
        for(int i=0;i<side.length;i++){
            if(side[i]+nums[index]<=avg){
                side[i]+=nums[index];
                if(dfs(nums,index-1,state|(1<<index),side,avg)){
                    return dp[state][cnt]=true;
                }
                side[i]-=nums[index];
            }
        }
        return dp[state][cnt]=false;
    }
}