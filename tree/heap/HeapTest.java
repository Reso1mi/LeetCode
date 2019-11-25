import java.util.*;
public class HeapTest{
    public static void main(String[] args) {
        int[] nums=generateRandomArray(50000000,500);
        MaxHeap heap=new MaxHeap();
        for (int i=0;i<nums.length;i++) {
            heap.add(nums[i]);
        }
        for (int i=0;i<nums.length;i++) {
            nums[i]=(int)heap.popMax();
        }
        for (int i=1;i<nums.length;i++) {
            if (nums[i-1]<nums[i]) {
                System.out.println("fuxk!!!");
                return;
            }
        }
        System.out.println("sucess!!!!!");
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}