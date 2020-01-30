import java.util.*;
public class FindDisappearedNumbers448{
    public static void main(String[] args) {
        FindDisappearedNumbers448 f=new FindDisappearedNumbers448();
        int[] nums={4,3,2,7,8,2,3,1};
        f.findDisappearedNumbers(nums);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //nums[i]=i+1
        //1 2 3 2 3   
        for (int i=0;i<nums.length;i++) {
            while(nums[i]!=i+1 && nums[nums[i]-1]!=nums[i]){
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
                //nums[i]=nums[nums[i]-1];
                //nums[nums[i]-1]=temp;
            }
        }
        List<Integer> res=new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=i+1) {
                res.add(i+1);
            }
        }
        return res;
    }

    //很巧妙
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //nums[i]=i+1
        //5 1 4 2 3
        for (int i=0;i<nums.length;i++) {
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }
        List<Integer> res=new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public void printArray(int[] arr){
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}