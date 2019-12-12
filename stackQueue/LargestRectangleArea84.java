public class LargestRectangleArea84{
    public static void main(String[] args) {

    }

    //单调栈最优解法 20ms
    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length<=0) {
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        int maxArea= Integer.MIN_VALUE;
        for (int i=0;i<heights.length;i++) {
            while(!stack.isEmpty() && heights[i]<=heights[stack.peek()]){
                //当前的柱子小于栈顶,说明当前栈顶最多向右扩展到 i-1
                int cur=stack.pop();
                //为空说明向左无法扩展,标为-1不影响结果
                int left=stack.isEmpty()?-1:stack.peek();
                //这里其实是 (i-1)-(left+1)+1
                maxArea=Math.max(maxArea,(i-left-1)*heights[cur]);
            }
            stack.push(i);
        }
        //处理栈中剩下的元素,无法向右扩展,只能向左扩展
        //所以为了让所有的元素都能出栈,我们可以再数组的后面想象添加一个0(也可以直接在原数组中添加一个0)
        while(!stack.isEmpty()){ 
            int cur=stack.pop();
            int left=stack.isEmpty()?-1:stack.peek();
            //这一步很秀,在数组后面再想象一个0出来
            //让栈中元素向右扩张(heights.length-1)-(left+1)+1
            maxArea=Math.max(maxArea,(heights.length-left-1)*heights[cur]);
        }
        return maxArea;
    }

    //分治 480ms
    public int largestRectangleArea(int[] heights) {
        if (heights==null || heights.length<=0) {
            return 0;
        }
        largestRectangleArea(heights,0,heights.length-1);
        return maxArea;
    }

    private int maxArea=Integer.MIN_VALUE;

    public void largestRectangleArea(int[] heights,int left,int right) {
        if (left>right) {
            return;
        }
        int minIndex=left;
        for (int i=left;i<=right;i++) {
            minIndex=heights[i]<heights[minIndex]?i:minIndex;
        }
        maxArea=Math.max(heights[minIndex]*(right-left+1),maxArea);
        largestRectangleArea(heights,left,minIndex-1);
        largestRectangleArea(heights,minIndex+1,right);
    }


/*    public int largestRectangleArea(int[] heights) {
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
        for (int i=left;i<=right;i++) {
            minIndex=heights[i]<heights[minIndex]?i:minIndex;
        }
        return Math.max(heights[minIndex]*(right-left+1),Math.max(largestRectangleArea(heights,minIndex+1,right),largestRectangleArea(heights,left,minIndex-1)));
    }*/


    //分治的优化
    public int largestRectangleArea(int[] heights) {
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
}
