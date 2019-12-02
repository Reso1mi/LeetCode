import java.util.*;
public class NextGreaterElement496{
    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<nums2.length;i++) {
            while(!stack.isEmpty() && nums2[stack.peek()]<nums2[i]){
                map.put(nums2[stack.pop()],nums2[i]);
            }
            stack.add(i);
        }
        int[] res=new int[nums1.length];
        for (int i=0;i<nums1.length;i++) {
            res[i]=map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}