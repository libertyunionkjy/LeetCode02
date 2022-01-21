package basicalgorithm;

/**
 * 为什么要使用双重锁检查：加快多个线程获取实例的性能；
 * 为什么要使用volatile字段：禁止指令重排序，如果不使用这个字段的话可能会发生instance还未初始化就被使用的情况
 * 具体可参考：https://segmentfault.com/a/1190000020959908
 */
public class Singleton {
    public static volatile Singleton instance;
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
