import java.util.*;
public class Trap42{

    public static void main(String[] args) {
        int [] nums={0,1,0,2,1,0,1,3,2,1,2,1};
        //int [] nums={9,1,0};
        System.out.println(trap6(nums));
    }



    //双O(N)动态规划的做法
    public static int trap(int []height){
        if (height==null || height.length<=0) {
            return 0;
        }
        int len=height.length;
        int[] leftMax=new int[len];
        leftMax[0]=height[0];
        int[] rightMax=new int[len];
        rightMax[len-1]=height[len-1];
        int res=0;
        //左右最大柱子包含当前柱子
        for (int i=1;i<len;i++) {
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        for (int i=len-2;i>=0;i--) {
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        for (int i=0;i<len;i++) {
            res+=Math.min(rightMax[i],leftMax[i])-height[i];
        }
        return res;
    }
    
    //双指针对空间的优化
    public static int trap(int []height){
        if (height==null || height.length<=0) {
            return 0;
        }
        int len=height.length;
        int leftMax=0,rightMax=0;
        int left=0,right=len-1,res=0;
        while(left<=right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            //leftMax小于rightMax,那么靠近leftMax的柱子left可以接的雨水就可以确定了
            if (leftMax<rightMax) {
                res+=leftMax-height[left]; 
                left++;
            }else{ //反之leftMax大于rightMax,那么考近rightMax的柱子right可以接的最多的雨水就可以i确定了
                res+=rightMax-height[right];
                right--;
            }
        }
        return res;
    }
    //双指针另外的思路,很好理解
    public static int trap5(int []height){
        int n=height.length,idx=0,lefth=0,righth=0,area=0;
        for(int i=0;i<n;i++) idx=height[idx]<=height[i]?i:idx;
          for(int i=0;i<idx;i++){
              if(height[i]<lefth) area+=lefth-height[i];
              else lefth=height[i];
          }
          for(int i=n-1;i>idx;i--){
              if(height[i]<righth) area+=righth-height[i];
              else righth=height[i];
          }
          return area;
      }

    //单调栈的解法
      public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>(); //栈里面维护一个递减栈
        int res = 0;
        for (int i = 0; i < height.length; i++){
            while (!stack.isEmpty()&& height[stack.peek()] < height[i]) { //当遍历的元素大于栈顶元素
                int tmp = stack.pop(); //栈顶弹出来计算栈顶能接的雨水
                if (stack.isEmpty()) {
                    break;
                }
                //和最大矩形其实很类似,栈中下一个比栈顶大的元素
                res += (Math.min(height[i],height[stack.peek()]) - height[tmp]) * (i - stack.peek() - 1);
            }
            //维护递减序列
            stack.push(i);
        }
        return res;
    }
}