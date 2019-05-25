public class MaxArea11 {


    public static void main(String[] args) {



    }


    public int maxArea(int[] height) {
        int len=height.length;
        if(len==0){
            return 0;
        }
        int head=0,tail=len-1;
        int max=Integer.MIN_VALUE;
        while(head<len){
            tail=len-1;
            while(head!=tail){
                int minHight=height[tail]>height[head]?height[head]:height[tail];
                max=max>(tail-head)*minHight ? max:(tail-head)*minHight;
                if(height[head]<=height[tail]){
                    break;
                }else{
                    tail--;
                }
            }
            head++;
        }
        return max;
    }


    public int maxArea(int[] height) {
        int len=height.length;
        if(len==0){
            return 0;
        }
        int left=0,right=len-1;
        int max=Integer.MIN_VALUE;
        while(left<right) {
            int minHight=height[left]>height[right]?height[right]:height[left];
            max=max>(right-left)*minHight ? max:(right-left)*minHight;
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}