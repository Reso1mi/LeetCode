import java.util.*;
import java.util.concurent.*;
import java.util.stream.*;
/*
多生产者消费者
ReentrantLoc.Condition
signal/await模型
 */
public class ProducerConsumer2{

    //缓存区
    private static List<Integer> buffer=new ArrayList<>();

    //缓冲区的最大值
    private static int MAX=3;

    //锁
    private static ReentrantLock LOCK=new ReentrantLock();

    //condition
    private static Condition producerCondition=LOCK.newCondition();

    private static Condition consumerCondition=LOCK.newCondition();

    private static int size=0;

    //produce数据
    private static int data=1;

    public static void main(String[] args) {
        Stream.of("Produce1","Produce2","Produce3","Produce4","Produce5").forEach(name->{
            new Thread(()->{
                while(true){
                    produce();
                }
            },name).start();
        });
        Stream.of("Consumer1","Consumer2","Consumer3","Consumer4","Consumer5").forEach(name->{
            new Thread(()->{
                while(true){
                    consumer();
                }
            },name).start();
        });
    }

    public static void produce(){
        try{
            LOCK.lock();
            while(size>=MAX){
                LOCK.wait();
            }
            buffer.add(data++);
            size++;
            System.out.println(Thread.currentThread().getName()+" produce "+ data);
            Thread.sleep(1000);
            LOCK.notifyAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            LOCK.unlock();
        }
    }

    public static void consumer () throws InterruptedException{
        LOCK.lock();
        try{
            while(size==0){
                consumerCondition.wait();
            }
            int temp=buffer.remove(0);
            System.out.println(Thread.currentThread().getName()+" consumer "+ temp);
            Thread.sleep(1000);
                //只唤醒消费者
            producerCondition.sigalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            LOCK.unlock();
        }       
    }
}