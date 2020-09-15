//lowbit初体验
import java.util.*;

public class CountSmaller315 {

    public static void main(String[] args) {
        CountSmaller315 c = new CountSmaller315();
        //3 2 4 1
        //1 0 0 0
        //1 0 0 1
        //1 1 0 1
        System.out.println(c.countSmaller(new int[]{5,2,6,1}));
        System.out.println(c.countSmaller(new int[]{6,5,4,3,2,1}));
    }

    int[] tree;
    
    int n = 0;

    public int lowbit(int i) {
        return i & -i;
    }

    //update索引i位置
    public void update(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            i += lowbit(i);
        }
    }

    public int query(int i) {
        int sum = 0;
        //从1开始
        while (i > 0) {
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }

    /*
    暴力的做法: 其实就是桶排序的思想，我们从右向左扫数组，扫描一个就在对应的桶+1，
    同时计算该位置左边的前缀和，就是右边比当前元素小的值，也就是我们需要的结果，
    但是问题是这个`bit`数组是一直在变化的，扫描一个元素就会在bit数组对应的位置上+1，
    每次变化后都需要O(N)来重新计算后缀和，这样整体的复杂度就是O(N^2)，数据量1e5，过不了OJ
    
    所以我们可以用线段树来维护区间和，但是线段树代码量比较大，常数也比较大
    所以这里学一下新科技：**树状数组**，区间查询，单点修改时间复杂度都是logN，且代码简单。
    同时还有一个问题，这里我们直接按照值来定位是不合适的，数据范围比较大，
    直接按照元素值来定位会造成很大空间的浪费，并且题目也不允许开这么大的空间
    所以还需要离散化，因为我们只关系元素之间的大小关系，所以我们转换成每个元素说对应的rank就行了
     */
    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        tree = new int[n+1];
        List<Integer> res = new LinkedList<>();
        int[] rank = new int[n];
        //temp[0]: index temp[1]: val
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i] = new int[]{i, nums[i]};
        }
        //离散化
        Arrays.sort(temp, (t1, t2) -> t1[1]-t2[1]);
        for (int i = 0; i < n; i++) {
            rank[temp[i][0]] = i+1;
        }
        for (int i = n-1; i >= 0; i--) {
            //O(NlogN)构建BIT(可以优化成O(N))
            update(rank[i], 1);
            res.add(0, query(rank[i]-1));
        }
        return res;
    }
}