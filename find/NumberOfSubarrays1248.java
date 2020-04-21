public class NumberOfSubarrays1248{
    public static void main(String[] args) {
        
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int[] map=new int[50001];  
        map[0]=1;
        int sum=0;
        int res=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]&1;
            map[sum]++;
            //sum-x=k
            if(sum-k >=0 && map[sum-k]!=0){
                res+=map[sum-k];
            }
        }
        return res;
    }
}