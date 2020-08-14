public class MinmaxGasDist_LintCode848{
    public static void main(String[] args) {

    }

    public double minmaxGasDist(int[] stations, int k) {
        // Write your code here
        double left = 0;
        double right = 1e8+1;
        double res = right;
        while (right-left >= 1e-6){
            double mid = left+(right-left)/2;
            if (check(stations, k, mid)) {
                res = mid;
                right = mid;
            }else{
                left = mid;
            }
        }
        return res;
    }
    
    public boolean check(int[] stations, int k, double D) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            count += (stations[i]-stations[i-1]) / D;
        }
        return count <= k;        
    }

    //我的憨憨check    
    public boolean check(int[] stations, int k, double D) {
        //int count = 0;
        double last = stations[0];
        for (int i = 1; i < stations.length; i++) {
            while ((double)stations[i]-last > D) {
                last += D;
                k--;
                if (k < 0) {
                    return false;
                }
            }
            last = stations[i];
            //count += (stations[i]-stations[i-1]) / D;
        }
        //return count <= k;
        return true;
    }
}