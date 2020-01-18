public class IsUgly263{
    public boolean isUgly(int num) {
        if (num<=0) {
            return false;
        }
        if(num==1) {
            return true;
        }
        return num%2==0?isUgly(num/2):false || num%3==0?isUgly(num/3):false || num%5==0?isUgly(num/5):false;
    }
}