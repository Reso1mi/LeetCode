import java.util.*;
public class FindKthNumber440{
    public static void main(String[] args) {

    }

    //WRONG ANSWER 应该是前序遍历,而不是层序遍历
    public int findKthNumber(int n, int k) {
        Queue<Integer> queue=new LinkedList<>();
        int idx=0;
        for (int i=1;i<=9;i++) {
            queue.clear();
            queue.add(i);
            while(!queue.isEmpty()){
                int cur=queue.poll();
                if(cur>n) break;
                idx++;
                if(idx==k) return cur;
                for(int j=0;j<=9;j++){
                    int temp=cur*10+j;
                    queue.add(temp);
                }
            }
        }
        return n;
    }

    //TLE
    public int findKthNumber(int n, int k) {
        for (int i=1;i<=9;i++) {
            dfs(i,n,k);
        }
        return res;
    }

    int idx=0,res=-1;

    public void dfs(int cur,int n,int k){
        if(res!=-1) return;
        if(cur>n) return;
        idx++;
        if(k==idx){
            res=cur;
            return;
        }
        for (int i=0;i<=9;i++) {
            dfs(cur*10+i,n,k);
        }
    }

    //正解
    public int findKthNumber(int n, int k) {
        long cur=1;
        k--;
        while(k>0){
            long count=getCount(cur,n);
            if(count<=k){ //不在该节点下,切换到相邻节点
                cur++;
                k-=count;
            }else{//在该节点下,切换到子节点
                cur*=10;
                k--;
            }
        }
        return cur;
    }

    //计算cur下有多少个节点
    public long getCount(long cur,int n){
        long next=cur+1;
        long count=0;
        while(cur<=n){
            //12-10=2,所以是n+1
            count+=Math.min(n+1,next)-cur;
            next*=10;
            cur*=10;
        }
        return count;
    }
}