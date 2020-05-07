public class LongestOnes1004{
    public static void main(String[] args) {

    }

    //简单的滑窗
    public int longestOnes(int[] A, int K) {
        if(A==null || A.length<=0) return 0;
        int N=A.length;
        int left=0,res=0,countA=0;
        for(int right=0;right<N;right++){
            countA+=(A[right]&1);
            //if也可以，个人喜欢while通用性更强
            while(right-left+1-countA>K){ 
                countA-=(A[left++]&1);
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}