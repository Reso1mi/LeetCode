public class Pow50{
    public static void main(String[] args) {
        System.out.println(fastPow(4,-1));
    }

    public static double fastPow(double x,int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        double res=fastPow(x,n/2);
        if(n%2==0){
            return res*res;
        }
        return res*res*x;
    }

}