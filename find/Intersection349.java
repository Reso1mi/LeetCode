import java.util.*;
public class Intersection349{
    public static void main(String[] args) {

    }
    /*
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [9,4]
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        ArrayList<Integer> res=new ArrayList<>();
        int index=0;
        for (int a:nums1 ) {
            s1.add(a);
        }

        for (int i=0;i<nums2.length;i++) {
            if(s1.contains(nums2[i])){
                res.add(nums2[i]);
                s1.remove(nums2[i]);
            }
        }
        
        int [] res2=new int[res.size()];
        for (int i=0;i<res.size();i++) {
            res2[i]=res.get(i);
        }
        return res2;
    }
}