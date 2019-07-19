package sword2offer;

/**
 *
 * 1、构造函数不能对外开放，一般为private
 * 2、通过一个静态方法或者枚举返回单例类对象
 * 3、确保单例对象有且只有一个，尤其是在多线程环境下
 * 4、确保单例对象在反序列化的时候，不会重新构建新对象
 */

/**
 * 饥汉模式
 * 优点：实现简单，效率高
 * 缺点：一开始就初始化对象，浪费内存
 */
public class Singleton {

    private Singleton() {
    }

    private static Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 懒汉模式
 * 优点：实现简单
 * 缺点：最简单的单例模式，不能支持多线程，没有实现同步，甚至不能算单例
 */
class Singleton1{
    private static Singleton1 instance ;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 懒汉模式（线程安全）
 * 优点：在第一次调用的时候才初始化，避免内存浪费
 * 缺点：同步等待影响效率
 */
class Singleton2{
    private static Singleton2 instance ;
    private Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 双重锁DCL: 第一次是为了不必要的同步，第二次是在singleton等于null的情况下才创建实例。
 * 优点：DCL资源利用率高，第一次执行getInstance时单例对象才被实例化，效率高
 * 缺点：缺点是第一次加载时反应稍慢一些，在高并发环境下也有一定的缺陷，虽然发生的概率很小。DCL虽然在一定程度解决了资源的消耗和多余的同步，
 *      线程安全等问题，但是他还是在某些情况会出现失效的问题，也就是DCL失效，在《java并发编程实践》一书建议用静态内部类单例模式来替代DCL
 */
class Singleton3{
    private volatile static Singleton3 instance;
    private Singleton3(){}
    public static Singleton3 getInstance(){
        if(instance == null){
            synchronized (Singleton3.class){
                if (instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类单例
 * 优点：加载类的时候不会初始化，只有在第一次调用的时候才会初始化，线程安全，这才是推荐使用的单例模式
 */
class Singleton4{
    private static class SingletonHolder{
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    private Singleton4(){}
    private static Singleton4 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

/**
 * 枚举单例
 * 优点：不仅利用了枚举本身自带的线程安全性，还能避免反序列化
 */
enum Singleton5{
    INSTANCE;
    public void doSomethings(){}
}



