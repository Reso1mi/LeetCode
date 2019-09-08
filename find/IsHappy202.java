public class IsHappy202{

    public static void main(String[] args) {
        System.out.println(isHappy(3));
    }
    /*
    编写一个算法来判断一个数是不是“快乐数”。

    一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和
    然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1
    那么这个数就是快乐数。
    示例: 
    输入: 19
    输出: true
    解释: 
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
    3 9 81 65 61 37 58 89 145 42 20 4 16 37

     */
    public static boolean isHappy(int n) {
        char[] nums=null;
        int sum=n;
        while(true) {
            nums=String.valueOf(sum).toCharArray();
            sum=0;
            for (int i=0;i<nums.length;i++) {
                sum+=(nums[i]-48)*(nums[i]-48);
            }
            if (sum==4) {
                return false;
            }else if (sum==1) {
                return true;
            }
        }
    }

    public static boolean isHappy(int n) {
        char[] nums=null;
        int sum=n;
        HashSet<Integer> set=new HashSet<>();
        while(true) {
            nums=String.valueOf(sum).toCharArray();
            sum=0;
            for (int i=0;i<nums.length;i++) {
                sum+=(nums[i]-48)*(nums[i]-48);
            }
            if (sum==1) {
                return true;
            }else if (set.contain(sum)){
                return false;
            }else{
                set.add(sum);    
            }
        }
    }
}