public class SingleTonInnerClass{

    //私有化构造器
    private SingleTonInnerClass(){}

    private static class SingleTonHolder{
        static{
            //当getInctance静态方法 访问SingleTonHolder的静态变量
            //的时候才会初始化内部类,所以也是属于懒汉式,并且是线程安全的
            System.out.println("Inner class");
        }
        private static SingleTonInnerClass instance=new SingleTonInnerClass();
    }

    static{
        //先初始化外部类
        System.out.println("SingleTon Outer class");
    }

    public static SingleTonInnerClass getInstance(){
        return SingleTonHolder.instance;
    }
}