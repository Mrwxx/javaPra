package mode;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

    // private构造函数
    private Singleton(){}
    // 内部新建对象
    private static Singleton singleton = new Singleton();
    //对外提供该对象的方法，必须是satatic
    public static Singleton getSingleton(){
        return singleton;
    }

    public static void main(String[] args) {
//        Lock
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try{}
        finally {
            lock.unlock();
        }
//        AbstractQueuedSynchronizer
//        ReadWriteLock
    }
}

