import java.util.*;
public class Intersection350{
    public static void main(String[] args) {

    }
    /*
        给定两个数组，编写一个函数来计算它们的交集。

        示例 1:

        输入: nums1 = [1,2,2,1], nums2 = [2,2,2,2,2]
        输出: [2,2]
        示例 2:

        输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出: [4,9]
        说明：

        输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
        我们可以不考虑输出结果的顺序。
        进阶:

        如果给定的数组已经排好序呢？你将如何优化你的算法？
        如果 nums1 的大小比 nums2 小很多，哪种方法更优？
        如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums1.length;i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        ArrayList<Integer> res=new ArrayList<>();
        for (int i=0;i<nums2.length;i++) {
            if (map.containsKey(nums2[i])) {
                if (map.get(nums2[i])!=0) {
                    res.add(nums2[i]);
                    map.put(nums2[i],map.get(nums2[i])-1);
                }
            }
        }
        int []res2=new int[res.size()];
        for (int i=0;i<res2.length;i++) {
            res2[i]=res.get(i);
        }
        return res2;
    }
}