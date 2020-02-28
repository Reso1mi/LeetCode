import java.util.*;
import java.util.concurrent.*;
/*
产生死锁必须具备以下四个条件？
1.互斥条件：该资源任意时刻自由一个线程占用
2.请求与保持条件：一个线程因为请求资源而阻塞，其他线程获取资源保持不变
3.不剥夺条件：线程已获得的资源在未使用完之前不能被其他线程强行剥夺，只能自己使用完毕后才释放资源
4.循环等待条件：若干线程之间形成一种头尾相接的循环等待资源关系

如何避免死锁？
只要打破其中一个条件就可以了
互斥条件：无法打破，不互斥就不叫锁了
请求与保持条件：一次性获取所以的资源
不剥夺条件：占用部分资源的线程进一步申请其他资源的时候，如果申请不到可以主动释放它占用的资源
循环等待条件：按照顺序申请资源，释放则反序

银行家算法
设Request i是进程Pi的请求向量，如果Request i[j]=K，表示进程P i需要K个R j类型的资源。
当P i发出资源请求后，系统按下述步骤进行检查：
(1) 如果Request i[j]≤Need[i,j]，便转向步骤(2)；否则认为出错，因为它所需要的资源数已超过它所宣布的最大值。
(2) 如果Request i[j]≤Available[j]，便转向步骤(3)；否则，表示尚无足够资源，Pi须等待。
(3) 系统试探着把资源分配给进程P i，并修改下面数据结构中的数值：
    Available[j]:= Available[j]-Request i[j]；
    Allocation[i,j]:= Allocation[i,j]+Request i[j]；
    Need[i,j]:= Need[i,j]-Request i[j]；
(4) 系统执行安全性算法，检查此次资源分配后系统是否处于安全状态。若安全，才正式将资源分配给进程Pi，
以完成本次分配；否则，将本次的试探分配作废，恢复原来的资源分配状态，让进程Pi等待。
 */
public class DeadLock{

    private static Object resourceA=new Object();

    private static Object resourceB=new Object();

    public static void main(String[] args) {
        Thread A=new Thread(()->{
            synchronized(resourceA){
                System.out.println("Thread A acquire resourceA");
                try{
                    TimeUnit.SECONDS.sleep(2);
                }catch(InterruptedException e){}
                synchronized(resourceB){
                    System.out.println("Thread A acquire resourceB");
                    System.out.println("A do some thing");
                }
            }
        });
        Thread B=new Thread(()->{
            synchronized(resourceB){
                System.out.println("Thread B acquire resourceB");
                try{
                    TimeUnit.SECONDS.sleep(2);
                }catch(InterruptedException e){}
                synchronized(resourceA){
                    System.out.println("Thread B acquire resourceA");
                    System.out.println("B do some thing");
                }
            }
        });
        A.start();
        B.start();
    }
}
