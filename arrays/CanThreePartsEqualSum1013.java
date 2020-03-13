public class CanThreePartsEqualSum1013{
    public static void main(String[] args) {

    }

    public boolean canThreePartsEqualSum(int[] A) {
        int[] preSum=new int[A.length+1];
        preSum[0]=0;
        for(int i=1;i<=A.length;i++){
            preSum[i]=preSum[i-1]+A[i-1];
        }
        for(int i=1;i<preSum.length-2;i++){
            if(preSum[A.length]-preSum[i]==preSum[i]*2){
                for(int j=i+1;j<preSum.length-1;j++){
                    if(preSum[A.length]-preSum[i]==(preSum[j]-preSum[i])*2){
                        //System.out.println(i+" "+j);
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++) sum+=A[i];
        if(sum%3!=0) return false;
        int count=0,tempSum=0;
        //i到达A.length-1保证有第3段,否则有可能target=0 只分为两段就没了
        for(int i=0;i<A.length-1;i++){ 
            tempSum+=A[i];
            if(tempSum==sum/3){
                ++count;
                if(count==2) return true;
                tempSum=0;
            }
        }
        return false;
    }
}