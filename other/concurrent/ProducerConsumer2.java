import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
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
    private static int MAX=5;

    //锁
    private static ReentrantLock LOCK=new ReentrantLock();

    //condition
    private static Condition producerCondition=LOCK.newCondition();

    private static Condition consumerCondition=LOCK.newCondition();

    private static int size=0;

    //produce数据
    private static int data=0;

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
                producerCondition.await();
            }
            buffer.add(++data);
            size++;
            //Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+" produce "+ data);
            consumerCondition.signalAll();//其实signal就可以了
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            LOCK.unlock();
        }
    }

    public static void consumer () {
        try{
            LOCK.lock();
            while(size==0){
                consumerCondition.await();
            }
            int temp=buffer.remove(0);
            size--;
            //Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+" consumer "+ temp);
            //只唤醒消费者
            producerCondition.signalAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            LOCK.unlock();
        }       
    }
}