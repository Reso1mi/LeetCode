import java.util.*;
public class Main12_8{
    public static void main(String[] args) {
       Main12_8 m=new Main12_8();
       int[] nums={2,3,5,7,11};
       System.out.println(m.smallestDivisor(nums,11));
    }

    public int subtractProductAndSum(int n) {
        String num=String.valueOf(n);
        int sum=0;
        int chen=1;
        for (int i=0;i<num.length();i++) {
            sum+=num.charAt(i)-48;
            chen*=num.charAt(i)-48;
        }
        return chen-sum;
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        boolean[] visit=new boolean[groupSizes.length];
        List<List<Integer>> res=new LinkedList<>();
        for (int i=0;i<groupSizes.length;i++) {
            if (visit[i]) {
                continue;
            }
            List<Integer> list= new LinkedList<>();
            list.add(i);
            for (int j=i+1;j<groupSizes.length;j++) {
                if (visit[j]) {
                    continue;
                }
                if (list.size()==groupSizes[i]) {
                    break;
                }
                if (groupSizes[j]==groupSizes[i]) {
                    list.add(j);
                    visit[j]=true;
                }
            }
            res.add(list);
        }
        return res;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int sum=0;
        for (int i=0;i<nums.length;i++) {
            sum+=nums[i];
        }
        int min=Integer.MAX_VALUE;
        for (int i=nums.length;i>=0;i--) {
            int res=sum/(threshold-i);
            if(check(nums,res,i)){
                min=Math.min(min,res);
            }
        }
        return min;
    }

    public boolean check(int[] nums,int n,int count){
        int temp=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]%n!=0) {
                temp++;
            }
            if (temp>count) {
                return false;
            }
            System.out.println(n);
            System.out.println(nums[i]+","+temp);
        }
        return temp==count;
    }
}