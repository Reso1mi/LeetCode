public class IsStraightJZ61{
    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {
        int[] bucket=new int[14];
        for(int i=0;i<5;i++){
            bucket[nums[i]]++;
            //有非0的对子,直接false
            if(nums[i]!=0 && bucket[nums[i]] >1 ){
                return false;
            }
        }
        //记录起手牌和最大牌
        int start=-1,end=-1;
        for(int i=1,j=13;end==-1||start==-1;i++,j--){
            if(bucket[i]==1 && start==-1) start=i;
            if(bucket[j]==1 && end==-1) end=j;
        }
        //小于等于4就行,多的用0补
        return end-start<=4;
    }

    //缩减成一个循环
    public boolean isStraight(int[] nums) {
        int[] bucket=new int[14];
        int min=14,max=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) continue;
            if(bucket[nums[i]]==1) return false;
            bucket[nums[i]]++;
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        return max-min<=4;
    }
}