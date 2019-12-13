import java.util.*;
public class MaximalRectangle85{
    public static void main(String[] args) {
        MaximalRectangle85 m= new MaximalRectangle85();
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(m.maximalRectangle(matrix));
    }

    //没写好,写的麻烦了
    public int maximalRectangleSilly(char[][] matrix) {
        if (matrix==null || matrix.length<=0) {
            return 0;
        }
        //初始化height数组,在末尾添加一个元素(默认0)让所有元素可以出栈
        int[][] height=new int[matrix.length][matrix[0].length+1];
        for (int i=0;i<matrix[0].length;i++) {
            height[0][i]=matrix[0][i]-48; //初始化第一层
        }
        int max=maxArea(height[0]);
        //记录每一层的height
        for (int i=1;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                if (matrix[i][j]=='1' && matrix[i-1][j] =='1') {
                    height[i][j]=height[i-1][j]+1;
                }else{
                    height[i][j]=matrix[i][j]-48;
                }
            }
            max=Math.max(max,maxArea(height[i]));
        }
        return max;
    }

    public int maxArea(int[] height){
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for (int i=0;i<height.length;i++) {
            while(!stack.isEmpty() && height[stack.peek()]>=height[i]){
                int cur=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek();
                // (i-1)-(left+1)+1
                max=Math.max(max,(i-left-1)*height[cur]);
            }
            stack.push(i);
        }
        return max;
    }


    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length<=0) {
            return 0;
        }
        //初始化height数组,在末尾添加一个元素(默认0)让所有元素可以出栈
        int[] height=new int[matrix[0].length+1];
        int max=0;
        //记录每一层的height
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                height[j]=matrix[i][j]=='1'?height[j]+1:0;
            }
            max=Math.max(max,maxArea(height));
        }
        return max;
    }

    //84题分治的思路
    public int maxArea(int[] heights) {
        if (heights==null || heights.length<=0) {
            return 0;
        }
        return largestRectangleArea(heights,0,heights.length-1);
    }

    public int largestRectangleArea(int[] heights,int left,int right) {
        if (left>right) {
            return 0;
        }
        int minIndex=left;
        boolean up=true;
        boolean down=true;
        for (int i=left+1;i<=right;i++) {
            if (heights[i]<heights[i-1]) {
                up=false;
            }
            if (heights[i]>heights[i-1]) {
                down=false;
            }
            minIndex=heights[i]<heights[minIndex]?i:minIndex;
        }
        if (up) {
            int maxArea=-1;
            for (int i=left;i<=right;i++) {
                maxArea=Math.max(maxArea,(right-i+1)*heights[i]);
            }
            return maxArea;
        }
        if (down) {
            int maxArea=-1;
            for (int i=right;i>=left;i--) {
                maxArea=Math.max(maxArea,(i-left+1)*heights[i]);
            }
            return maxArea;
        }
        return Math.max(heights[minIndex]*(right-left+1),Math.max(largestRectangleArea(heights,minIndex+1,right),largestRectangleArea(heights,left,minIndex-1)));
    }

    public static void printArray(int[] nums){
        for (int i=0;i<nums.length;i++) {
            System.out.print(nums[i]+" ");
        }
    }
}