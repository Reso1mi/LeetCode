public class SumNumsJZ64{
    public static void main(String[] args) {
        
    }

    public int sumNums(int n) {
        int sum = n;
        //逻辑与短路
        boolean ans = (n > 0) && ((sum += sumNums(n - 1)) > 0);
        return sum;
    }
}