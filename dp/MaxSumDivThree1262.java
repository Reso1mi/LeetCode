import java.util.*;
public class MaxSumDivThree1262{
    public static void main(String[] args) {
        MaxSumDivThree1262 m=new MaxSumDivThree1262();
        m.maxSumDivThree0(new int[]{2,19,6,16,5,10,7,4,11,6});
    }

    //WRONG ANSWER
    public int maxSumDivThree0(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        int[][] dp=new int[nums.length][3]; 
        //dp[i][k] 0~i 之间/3余k的最大元素和
        dp[0][0]=nums[0]%3==0?nums[0]:Integer.MIN_VALUE;
        dp[0][1]=nums[0]%3==1?nums[0]:Integer.MIN_VALUE;
        dp[0][2]=nums[0]%3==2?nums[0]:Integer.MIN_VALUE;
        for (int i=1;i<nums.length;i++) {
            if (nums[i]%3==0) {
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][0]+nums[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][1]+nums[i]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][2]+nums[i]);
            }
            if (nums[i]%3==1) {
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]+nums[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+nums[i]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+nums[i]);   
            }
            if (nums[i]%3==2) {
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+nums[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]+nums[i]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][0]+nums[i]);   
            }
        }
        printArray(dp);
        return  Math.max(0,dp[nums.length-1][0]);
    }

    //3,6,5,1,8
    //[2,19,6,16,5,10,7,4,11,6]
    public int maxSumDivThree(int[] nums) {
        if (nums==null || nums.length<=0) {
            return 0;
        }
        //dp[i][k] 0~i 之间/3余k的最大元素和
        int[][] dp=new int[nums.length+1][3]; 
        dp[0][0]=0; //初始状态定义
        dp[0][1]=Integer.MIN_VALUE;
        dp[0][2]=Integer.MIN_VALUE;
        for (int i=1;i<=nums.length;i++) {
            if (nums[i-1]%3==0) {
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][0]+nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][1]+nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][2]+nums[i-1]);
            }
            if (nums[i-1]%3==1) {
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]+nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+nums[i-1]);   
            }
            if (nums[i-1]%3==2) {
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+nums[i-1]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][2]+nums[i-1]);
                dp[i][2]=Math.max(dp[i-1][2],dp[i-1][0]+nums[i-1]);   
            }
        }
        printArray(dp);
        return  Math.max(0,dp[nums.length][0]);
    }

    //O(1)空间优化
    public int maxSumDivThree2(int[] nums) {
        int[] dp=new int[3];
        dp[1]=Integer.MIN_VALUE;
        dp[2]=Integer.MIN_VALUE;
        for (int i=1;i<=nums.length;i++) {
            if (nums[i-1]%3==0) {
                dp[0]=Math.max(dp[0],dp[0]+nums[i-1]);
                dp[1]=Math.max(dp[1],dp[1]+nums[i-1]);
                dp[2]=Math.max(dp[2],dp[2]+nums[i-1]);
            }
            if (nums[i-1]%3==1) {
                int temp0=dp[0];
                dp[0]=Math.max(dp[0],dp[2]+nums[i-1]);
                dp[2]=Math.max(dp[2],dp[1]+nums[i-1]); //调整顺序减少变量
                dp[1]=Math.max(dp[1],temp0+nums[i-1]);
            }
            if (nums[i-1]%3==2) {
                int temp0=dp[0];
                dp[0]=Math.max(dp[0],dp[1]+nums[i-1]);
                dp[1]=Math.max(dp[1],dp[2]+nums[i-1]);
                dp[2]=Math.max(dp[2],temp0+nums[i-1]);
            }
        }
        return dp[0];
    }

    //O(NlogN)贪心
    public int maxSumDivThree3(int[] nums) {
        int sum=0;
        List<Integer> one=new ArrayList<>();
        List<Integer> two=new ArrayList<>();
        for (int n:nums) {
            sum+=n;
            if (n%3==1) one.add(n);
            if (n%3==2) two.add(n);
        }
        Collections.sort(one);
        Collections.sort(two);
        if (sum%3==1) { //移除一个余数为1的 或者两个余数为2的
            return Math.max(one.size()>=1?sum-one.get(0):0,two.size()>=2?sum-two.get(0)-two.get(1):0);
        }
        if (sum%3==2) { //移除一个余数为2 或者两个余数为1的
            return Math.max(two.size()>=1?sum-two.get(0):0,one.size()>=2?sum-one.get(0)-one.get(1):0);   
        }
        return sum;
    }

    //好像不太好改喔
    public int maxSumDivThree4(int[] nums) {
        int sum=0;
        int a=0,b=0,c=0,d=0;
        for (int n:nums) {
            sum+=n;
            if (n%3==1) {
                a=Math.min(a,n);
                b=Math.min(b,n)>a?Math.min(b,n):b;
            }
            if (n%3==2) {
                b=Math.min(b,n);
            }
        }
        if (sum%3==1) { //移除一个余数为1的 或者两个余数为2的
            return Math.max(sum-a,sum-c-d);
        }
        if (sum%3==2) { //移除一个余数为2 或者两个余数为1的
            return Math.max(sum-c,sum-a-b);
        }
        return sum;
    }

    public int maxSumDivThree5(int[] nums) {
        int sum=0;
        //大根堆,不行,后面的处理也需要从小到大,比较麻烦
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        for (int n:nums) {
            sum+=n;
            if (n%3==1) {
                pq1.add(n);
                if (pq1.size()>2) pq1.poll();
            }
            if (n%3==2) {
                pq2.add(n);
                if (pq2.size()>2) pq2.poll();
            }
        }
        if (sum%3==1) { //移除一个余数为1的 或者两个余数为2的
            return Math.max(pq1.size()>=1?sum-pq1.poll():0,pq2.size()>=2?sum-pq2.poll()-pq2.poll():0);
        }
        if (sum%3==2) { //移除一个余数为2 或者两个余数为1的
            return Math.max(pq2.size()>=1?sum-pq2.poll():0,pq1.size()>=2?sum-pq1.poll()-pq1.poll():0);
        }
        return sum;
    }


    public void printArray(int[][] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.println("0:"+arr[i][0] +" 1:"+arr[i][1]+" 2:"+arr[i][2]);
        }
        System.out.println();
    }
}