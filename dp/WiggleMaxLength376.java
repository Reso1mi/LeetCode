public class WiggleMaxLength376{
    public static void main(String[] args) {

    }

    //有顺序,不连续
    public int wiggleMaxLength(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int up=1;
        int down=1;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]>nums[i-1]) {
                up=down+1;
            }else if (nums[i]>nums[i-1]){
                down=up+1;
            }
        }
        return Math.max(up,down);
    }

    //O(N^2)DP
    public int wiggleMaxLength(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int []up=new int[nums.length]; 
        int []down=new int[nums.length]; 
        for (int i=0;i<nums.length;i++) {
            up[i]=1; down[i]=1; //初始化
            for (int j=0;j<i;j++) {
                if(nums[i]>nums[j]){
                    up[i]=Math.max(up[i],down[j]+1);
                }else if(nums[i]<nums[j]){
                    down[i]=Math.max(down[i],up[j]+1);
                }
            }
        }
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }

    //线性DP
    public int wiggleMaxLength2(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int []up=new int[nums.length];
        int []down=new int[nums.length];
        up[0]=down[0]=1;
        for (int i=1;i<nums.length;i++) {
            if(nums[i]>nums[i-1]){
                up[i]=down[i-1]+1;
                down[i]=down[i-1];
            }else if(nums[i]<nums[i-1]){
                down[i]=up[i-1]+1;
                up[i]=up[i-1];
            }else{
                //相等的时候别忘了继承前面节点的状态
                down[i]=down[i-1];
                up[i]=up[i-1];
            }
        }
        return Math.max(up[nums.length-1],down[nums.length-1]);
    }
}