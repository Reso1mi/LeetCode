public class CountPrimes204{
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        boolean[] prime=new boolean[n];
        int res=0;
        for(int i=2;i<n;i++){
            if(!prime[i]){
                res++;
                for(int j=2*i;j<n;j+=i){
                    prime[j]=true;
                }
            }
        }
        return res;
    }

    public int countPrimes(int n) {
        boolean[] prime=new boolean[n];
        //为了不那么别扭
        Arrays.fill(prime,true);
        for(int i=2;i*i<n;i++){
            if(prime[i]){
                //从i*i开始,i*(i-1)已经被前面的统计了
                for(int j=i*i;j<n;j+=i){
                    prime[j]=false;
                }
            }
        }
        int res=0;
        for(int i=2;i<prime.length;i++){
            if(prime[i]) res++;
        }
        return res;
    }
}