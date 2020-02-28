public class SingleTonHungry{
    /*
    线程安全,但是消耗比较大,在类第一次加载的时候就会初始化
    但是也不一定马上会用,一般我们希望用的时候再创建
     */
    private static final SingleTonHungry instance=new SingleTonHungry();

    //私有化构造器
    private SingleTonHungry(){
        if (instance !=null){
            throw new RuntimeException("实例已经存在，请通过 getInstance()方法获取");
        }
    }

    public static SingleTonHungry getInstance(){
        return instance;
    }
}