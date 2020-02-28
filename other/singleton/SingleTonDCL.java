public class SingleTonDCL{
    
    private static volatile SingleTonDCL instance=null;

    //私有化构造器
    private SingleTonDCL(){
        if (instance !=null){
            throw new RuntimeException("实例已经存在，请通过 getInstance()方法获取");
        }
    }

    public static SingleTonDCL getInstance(){
        if(instance==null){
            synchronized(SingleTonDCL.class){
                if(instance==null){
                    //这里会有重排序的问题,instance还没有初始化完成就返回了
                    //所以需要加volatile
                    instance=new SingleTonDCL(); 
                }
            }
        }
        return instance;
    }
}