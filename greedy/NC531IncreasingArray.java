import java.util.*;

//NC531.递增数组 https://www.nowcoder.com/practice/d0907f3982874b489edde5071c96754a
public class NC531IncreasingArray {
    /**
     * 
     * @param array int整型一维数组 array
     * @return long长整型
     */
    public long IncreasingArray (int[] array) {
        // write code here
        long res = 0;
        for (int i = 1; i < array.length; i++){
            if (array[i] <= array[i-1]) {
                res += array[i-1]-array[i]+1;
            }
        }
        return res;
    }
}