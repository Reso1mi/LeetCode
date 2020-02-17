import java.util.*;
public class LastRemainingJZ62{
    public static void main(String[] args) {

    }

    /*链表模拟解法
    0 1 2 3 4 5 m=3
    3 4 5 0 1*/
    public int lastRemaining(int n, int m) {
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++)
            queue.addLast(i);
        while(queue.size()>1){
            for(int i=0;i<m;i++){
                int temp=queue.removeFirst();
                if(i!=m-1){
                    queue.addLast(temp);
                }
            }
        }
        return queue.getFirst();
    }
    /*
        0 ~ n-1 每次kill第k个人
        k=(m-1)%n

        kill k之后, 在n-1个人中重建新索引
        原始索引   新的index
        k+1         0
        k+2         1
        k+3         2
        ...         ...
        n-1         n-k-2
        0           n-k-1
        1           n-k
        2           n-k+1
        ...         ...
        k-1         n-2

        新索引(x) ---> 原始索引(y)
        y=(x+k+1)%n  eg. (n-2+k+1)%n=(n+k-1)%n=k-1
        设在n-1个人中最后剩下的人是 f(n-1,m)按照上面的公式转换成原始索引就是
        f(n,m)=(f(n-1,m)+k+1)%n
     */
    //数学解法
    public int lastRemaining(int n, int m) {
        int last=0;//一个人的时候存活者index f(1,m)=0
        for(int i=2;i<=n;i++){ //枚举人数
            last=(last+m)%i;
        }
        return last;
    }
}