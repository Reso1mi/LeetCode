import java.util.*;
import java.util.stream.*;

public class ProducerConsumer1{
    /*
    多生产者消费者
    signal/await模型
    */

    //缓存区
    private static List<Integer> buffer=new ArrayList<>();

    //缓冲区的最大值
    private static int MAX=3;

    //当前的缓冲区大小,需要加volatile保证可见性
    private static volatile int size=0;

    //锁
    private static final Object LOCK = new Object();

    //模拟produce数据
    private static int data=0;

    public static void main(String[] args) {
        Stream.of("Produce1","Produce2","Produce3","Produce4","Produce5").forEach(name->{
            new Thread(()->{
                try{
                    produce();
                }catch(Exception e){
                    e.printStackTrace();
                }
            },name).start();
        });
        Stream.of("Consumer1","Consumer2","Consumer3","Consumer4","Consumer5").forEach(name->{
            new Thread(()->{
                try{
                    consumer();
                }catch(Exception e){
                    e.printStackTrace();
                }
            },name).start();
        });
    }

    public static void produce()throws InterruptedException{
        while(true){
            synchronized(LOCK){
                while(size>=MAX){
                    LOCK.wait();
                }
                buffer.add(++data);
                size++;//这里不用加锁,单线程
                System.out.println(Thread.currentThread().getName()+" produce "+ data);
                Thread.sleep(1000);
                LOCK.notifyAll();
            }
        }
    }

    public static void consumer () throws InterruptedException{
        while(true){
            synchronized(LOCK){
                while(size==0){
                    LOCK.wait();
                }
                int temp=buffer.remove(0);
                size--;
                System.out.println(Thread.currentThread().getName()+" consumer "+ temp);
                Thread.sleep(1000);
                LOCK.notifyAll();
            }
        }
    }
}