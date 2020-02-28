public class SingleTonLazy{
    
    private static SingleTonLazy instance=null;

    //私有化构造器
    private SingleTonLazy(){
        if (instance !=null){
            throw new RuntimeException("实例已经存在，请通过 getInstance()方法获取");
        }
    }

    //不加锁多线程下会有问题
    public synchronized static SingleTonLazy getInstance(){
        if(instance==null){ 
        	//这里没有重排序的问题,因为整个方法是加锁的
            instance=new SingleTonLazy(); 
        }
        return instance;
    }
}