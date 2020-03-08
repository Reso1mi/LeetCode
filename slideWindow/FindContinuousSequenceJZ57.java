import java.util.*;
public class FindContinuousSequenceJZ57{
    public static void main(String[] args) {

    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res=new ArrayList<>();
        int left=1,right=2;
        int sum=0;
        //9 right最多到5
        while(left<=right && right<=(target+1)/2){
            //等差数列前n项和
            int n=right-left+1;
            sum=left*n+n*(n-1)/2;
            if(sum>target){
                left++; //剔除一个小的
            }else if(sum<target){
                right++; //添加一个大的
            }else{ //build结果集
                res.add(build(left,right));
                left++;//窗口左移,剔除一个小的
                right++; //回头重写发现这里还可以优化,右边界也可以扩大
            }
        }
        return res.toArray(new int[0][0]);
    }

    public int[] build(int left,int right){
        int[] res=new int[right-left+1];
        for(int i=left;i<=right;i++){
            res[i-left]=i;
        }
        return res;
    }
}