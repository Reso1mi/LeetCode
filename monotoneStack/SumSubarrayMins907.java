public class SumSubarrayMins907{
    public static void main(String[] args) {

    }

    //WRONG ANSWER
    public int sumSubarrayMins(int[] A) {
        Deque<Integer> stack=new ArrayDeque<>();
        int mod=(int)1e9+7;
        int res=0;
        //3 1 2 4 0
        //3+4*1+2*2+1*(3+3)=17
        //4 3 2 1 2 3  6+6=12
        // 1 2 3 4 0
        // 4*1 + 3*2 + 2*3 + 1*4=20
        
        //2,3,3,2,4,3,2,0
        //3*1+3*2+4*1+
        int[] temp=new int[N+1];
        System.arraycopy(A,0,temp,0,N);
        temp[N]=0;A=temp;
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && A[stack.peek()]>A[i]){
                int cur=stack.pop();
                if(stack.isEmpty()){
                    //右边：i-cur-1
                    //左边：cur
                    res=(res+A[cur]*((i-cur-1)*cur+i))%mod;
                }else{
                    res=(res+A[cur]*(i-cur))%mod;
                }
            }
            stack.push(i);
        }
        return res;
    }

    //3 1 2 4 0
    //3+4*1+2*2+1*(3+3)=17
    //4 3 2 1 2 3  6+6=12
    // 1 2 3 4 0
    // 4*1 + 3*2 + 2*3 + 1*4=20
    public int sumSubarrayMins(int[] A) {
        Deque<Integer> stack=new ArrayDeque<>();
        int N=A.length;
        int mod=(int)1e9+7;
        int res=0;
        int[] temp=new int[N+1];
        System.arraycopy(A,0,temp,0,N);
        //末尾加0使所有元素都可以出栈
        temp[N]=0;A=temp; 
        for(int i=0;i<N+1;i++){
            while(!stack.isEmpty() && A[stack.peek()]>A[i]){
                int cur=stack.pop();
                int left=stack.isEmpty()?-1:stack.peek();
                //右边大于cur的个数(i之前)： i-cur-1      
                //左边大于cur的个数(left之后)： cur-(left+1) 
                //res=(res+A[cur]*((i-cur-1)*(cur-left-1)+i-1-left))%mod;
                //(a+1)*(b+1)=ab+a+b+1
                res=(res+A[cur]*(i-cur)*(cur-left))%mod;
            }
            stack.push(i);
        }
        return res;
    }
}