public class MaxSatisfied1052{
    public static void main(String[] args) {

    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if(grumpy==null || grumpy.length<0) return 0;
        int N=grumpy.length;
        int left=0;
        int window=0;//窗口内反转人数
        int max=0; //最多反转人数
        for(int right=0;right<N;right++){
            if(grumpy[right]==1){
                window+=customers[right];
            }
            //while和if都可以,个人比较喜欢while通用性比较强
            while(right-left+1>X){
                if(grumpy[left]==1){
                    window-=customers[left];
                }
                left++;
            }
            max=Math.max(window,max);
        }
        int res=0;
        for(int i=0;i<N;i++){
            res+=(grumpy[i]==0?customers[i]:0);
        }
        return res+max;
    }
}