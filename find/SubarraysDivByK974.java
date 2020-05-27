public class SubarraysDivByK974{
    public static void main(String[] args) {

    }

    //同余定义 (b-a)%k=0 => b%k==a%k
    public int subarraysDivByK(int[] A, int K) {
        int[] pre=new int[K];
        int sum=0;
        pre[sum]=1;
        int res=0;
        for(int a:A){
            sum=(sum+a)%K;
            //Java被除数为负数的时候取模也是负数
            //这里应该纠正，避免负数的模
            if(sum<0) sum+=K;
            res+=pre[sum];
            pre[sum]++;
        }
        return res;
    }
}