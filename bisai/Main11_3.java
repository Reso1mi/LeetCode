import java.util.*;
public class Main11_3{
    public static void main(String[] args) {
        int[] nums={1,1,2,1,1};
        numberOfSubarrays(nums,3);
    }

    //xxyyxyxyxx 0011010111
    //xyyxyxxxyx 0110100010
    
    //xyyx  0110
    //yxxy  1001
    
    //xy 01
    //yx 10  
    
    //xxxy
    //xyxx

    //xxxx 0000
    //yyyy 1111
/*    public int minimumSwap(String s1, String s2) {
        if (s1.length!=s2.length) {
            return -1;
        }
        int res=0;
        for (int i=0;i<s1.length;i++) {

        }
    }*/

    //2,2,2,1,2,2,1,2,2,2
    //奇数看作1,偶数看作0,问题转换为求和为k的区间的个数
    //0,0,0,1,0,0,1,0,0,0
    public static int numberOfSubarrays(int[] nums, int k) {
        int res=0;
        int sum=0;
        //HashMap<Integer,Integer> map=new HashMap<>();
        int[] map=new int[100001];
        map[0]=1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]%2==1) {
                sum++;
            }
            if (sum>=k) {
                res+=map[sum-k];
            }
            map[sum]++;
            System.out.println(sum+":"+map[sum]);
        }
        return res;
    }
    
    /*public int numberOfSubarrays(int[] nums, int k) {
        int left=-1,right=-1;
        int count=0,res=0;
        while(left<right && right<nums.length){
            while (count<k && right<nums.length) {
                right++;
                if (nums[right]%2!=0) {
                    count++;
                }
            }
            if (count==k) {
                res++;
            }
            left++;
        }
        return res;
    }*/

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder(s);
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i)>='a' && s.charAt(i)<='z') {
                continue;
            }
            if (s.charAt(i)==')') {
                if (stack.isEmpty()) {
                    sb.replace(i,i+1,"*");    
                }else{
                    stack.pop();
                }
            }
            if (s.charAt(i)=='(') {
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int temp=stack.pop();
            sb.replace(temp,temp+1,"*");
        }
        String res=sb.toString().replace("*","");
        return res;
    }
}