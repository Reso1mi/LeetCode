public class LargestMultipleOfThree5173{
    public static void main(String[] args) {

    }

    public String largestMultipleOfThree(int[] digits) {
        int sum=0;
        int[] freq=new int[10];
        for(int i=0;i<digits.length;i++) {
            sum+=digits[i];
            freq[digits[i]]++;
        }
        if(sum==0) return "0";
        //删除一个余1的或者两个余2的,优先删除一个余1的
        //删除1个得到的结果肯定比删除2个大
        if(sum%3==1){ 
            if(!deleteMin(freq,1)){ 
                deleteMin(freq,2);
                deleteMin(freq,2);
            }
        }
        if(sum%3==2){ //删除一个余2的或者两个余1的
            if(!deleteMin(freq,2)){
                deleteMin(freq,1);
                deleteMin(freq,1);
            }   
        }
        StringBuilder res=new StringBuilder();
        //逆序构建结果
        for(int i=9;i>=0;i--){
            int count=freq[i];
            while(count-- >0){
                res.append(i);
            }
        }
        return res.toString();
    }

    public boolean deleteMin(int[] freq,int y){
        for (int i=y;i<9;i+=3) {
            if (freq[i]!=0) {
                freq[i]--;
                return true;
            }
        }
        return false;
    }
}