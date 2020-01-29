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


    //双指针, 回顾的时候发现这个解法有点不好理解
    public static int trap3(int []height){
      if (height == null || height.length <= 1) return 0;
      int left = 0;
      int right = height.length - 1;
      int left_max = 0;
      int right_max = 0;
      int res = 0;
      while (left < right) {
        if (height[left] < height[right]) {
                if (height[left] < left_max) //当前左边元素 比右边最大值小，比左边最大值小是个“凹点”
                res += left_max - height[left]; 
                else left_max = height[left];
                left++;
            } else {
                if (height[right] < right_max) //当前左边元素 比左边最大值小，比右边最大值小是个“凹点”
                res += right_max - height[right]; 
                else right_max = height[right];
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




    //*****************二愣子做法********************************

    //思路就是找波峰然后链接 
    public static int trap(int[] height) {
      if(height==null||height.length<=1){
         return 0;
     }
        //首先找到波峰，然后找到后面最大的波峰
     int [] bofen=new int[height.length];
     Arrays.fill(bofen,-1);
     int index=-1;
     int sa=height[0];
     int sa2=0;
     for (int i=1;i<height.length;i++) {
         if(height[i]>height[i-1]){
                bofen[++index]=i; //记录波峰
            }
            sa+=height[i];
        }
        printArray(bofen); //1 3 6 7 10 -1 -1 -1 -1 -1 -1 -1
        for (int i=0,j=0;i<bofen.length-1 && bofen[i]!=-1;) {
            //找到后面比它大的第一个,或者比它小的最大的一个
            int max=i+1;
            j=i+1;
            while( bofen[j]!=-1 && height[bofen[j]]<height[bofen[i]]){
                max=height[bofen[j]]>=height[bofen[max]]?j:max;
                j++;
            }
            if( bofen[j]==-1){
                //没有大于当前波峰的，取最大的
                sa2+= ((bofen[max]-bofen[i])*height[bofen[max]]+height[bofen[i]]);
                System.out.println("1:"+sa2);
                i=max+1;
            }else{
                sa2+= ((bofen[j]-bofen[i])*height[bofen[i]]);
                System.out.println("2:"+sa2);
                i=j;
            }
        }
        //加上左右波峰的左右的面积
        for (int i=0;i<bofen[0];i++) {
            sa2+=height[i];
        }

        for (int i=bofen[index]+1;i<height.length;i++) {
            sa2+=height[i];
        }

        //System.out.println(sa2+","+sa);
        return sa2-sa;
    }



    public static int trap2(int[] height) {
      if(height==null||height.length<=1){
         return 0;
     }
        //首先找到波峰，然后找到后面最大的波峰
        //int [] bofen=new int[height.length];
     List<Integer> bofen=new ArrayList<>();
     int sa=height[0];
     int sa2=0;
     for (int i=1;i<height.length;i++) {
         if(height[i]>height[i-1]){
                //bofen[++index]=i; //记录波峰
          bofen.add(i);
      }
      sa+=height[i];
  }
  if(bofen.size()==0){
   return 0;
}
for (int i=0,j=0;i<bofen.size()-1;) {
            //找到后面比它大的第一个,或者比它小的最大的一个
   int max=i+1;
   j=i+1;
   while(j<bofen.size()&& height[bofen.get(j)]<height[bofen.get(i)]){
      max=height[bofen.get(j)]>=height[bofen.get(max)]?j:max;
      j++;
  }
  if(j==bofen.size()){
                //没有大于当前波峰的，取最大的
      sa2+= ((bofen.get(max)-bofen.get(i)-1)*height[bofen.get(max)]+height[bofen.get(i)]);
                //System.out.println("1:"+sa2);
      i=max;
  }else{
      sa2+= ((bofen.get(j)-bofen.get(i))*height[bofen.get(i)]);
                //System.out.println("2:"+sa2);
      i=j;
  }
}
        //加上左右波峰的左右的面积
for (int i=0;i<bofen.get(0);i++) {
   sa2+=height[i];
}

for (int i=bofen.get(bofen.size()-1);i<height.length;i++) {
   sa2+=height[i];
}
        //System.out.println(sa2+","+sa);
return sa2-sa;
}


public static void printArray(int[] arr) {
   if (arr == null) {
      return;
  }
  for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
  }
  System.out.println();
}
}