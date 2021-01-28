package Java_Basic.thread;

import java.util.concurrent.*;

public class Ex1 {

    public static void main(String[] args) {
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //锁对象，不是同一对象不同步
        executorService.execute(() -> e1.func1());
        executorService.execute(() -> e2.func1());
        //锁对象 同一对象同步
        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e1.func2());
        //锁类 同一个类同步
        executorService.execute(() -> e1.func3());
        executorService.execute(() -> e2.func3());
    }
}
