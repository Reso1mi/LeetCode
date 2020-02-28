//1、除枚举方式外, 其他方法都会通过反射或者序列化的方式破坏单例
public enum SingleTonEnum{
    INSTANCE;
}