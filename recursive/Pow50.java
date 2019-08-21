public class Pow50{
    public static void main(String[] args) {
        int a=-2147483648;
        System.out.println(-a);

        System.out.println(fastPow2(2.0,a));
    }

    public static double fastPow2(double x,int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        double res=fastPow2(x,n/2);
        if(n%2==0){
            return res*res;
        }
        return res*res*x;
    }

    public static double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return fastPow(x,n);
    } 
    
    public static double fastPow(double x,int n){
        if(n==0){
            return 1.0;
        }
        double  half=fastPow(x,n/2);
        if(n%2==0)
            return half*half;
        return half*half*x;
    }

}