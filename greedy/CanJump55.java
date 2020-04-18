public class CanJump55{
    public static void main(String[] args) {

    }

    // 暴力TLE 70/75 
    public boolean canJump(int[] nums) {
        if (nums==null || nums.length<=0) return false;
        jump(nums,0);
        return res;
    }

    boolean res=false;

    public void jump(int[] nums,int index) {
        if (index == nums.length-1) {
            res=true;
        }
        if (index >= nums.length) return;
        for (int i=1;i<=nums[index];i++) {
            jump(nums,index+i);
        }
    }

    //提前阻断, 依然TLE  74/75
    public boolean canJump(int[] nums) {
        if (nums==null || nums.length<=0) return false;
        jump(nums,0);
        return res;
    }

    boolean res=false;

    public void jump(int[] nums,int index) {
        if (index == nums.length-1) {
            res=true;
        }
        for (int i=nums[index];i>=1 && index+i<nums.length && !res ;i--) {
            jump(nums,index+i);
        }
    }



    //记忆化
    Boolean[] cache=null;

    public boolean canJump(int[] nums) {
        if (nums==null || nums.length<=0) return false;
        cache=new Boolean[nums.length];
        return jump(nums,0);
    }

    public boolean jump(int[] nums,int index) {
        if (nums[index] >= nums.length-1 -index) {
            return true;
        }
        if (cache[index]!=null) {
            return cache[index];
        }
        for (int i=nums[index];i>=1;i--) {
            if (index+i<nums.length && jump(nums,index+i)) {
                return cache[index]=true;
            }
        }
        return cache[index]=false;
    }

    //MDZZ
    public boolean canJump(int[] nums) {
        int maxIndex=nums[0];
        for (int i=1;i<nums.length-1;i++) {
            if(maxIndex >= nums.length-1) return true;
            if (i>maxIndex) {
                return false;
            }
            maxIndex=Math.max(maxIndex,i+nums[i]);
        }
        return true;
    }
}