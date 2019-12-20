public class CountArrangement526{
    public static void main(String[] args) {
        CountArrangement526 c=new CountArrangement526();
        System.out.println(c.countArrangement(10));
    }

    public int countArrangement(int N) {
        cache=new Integer[N+1];
        boolean[] visit=new boolean[N+1];
        return countArrangement(N,visit,1);
    }
    
    private Integer[] cache;

    //可以做记忆化的版本
    //md。记忆化出了问题下面的代码是错的,这个递归里面的变量不是只有index, visit的状态是不一样的
    public int countArrangement(int N,boolean[] visit,int index) {
        if (index > N) {
            return 1;
        }
        // if (cache[index]!=null) {
        //     return cache[index];
        // }
        int res=0;
        for (int i=1;i<=N;i++) {
            if (!visit[i] && (index%i==0 || i%index==0)) {
                visit[i]=true;
                res+=countArrangement(N,visit,index+1);
                visit[i]=false;
            }
        }
        return cache[index]=res;
    }

    private int res=0;
    //第i个位置的元素可以被i整除
    //i能被第i个位置的元素整除(反过来)
    public void countArrangement2(int N,boolean[] visit,int index) {
        if (index > N) {
            res++;
            return;
        }
        for (int i=1;i<=N;i++) {
            if (!visit[i] && (index%i==0 || i%index==0)) {
                visit[i]=true;
                countArrangement2(N,visit,index+1);
                visit[i]=false;
            }
        }
    }
}