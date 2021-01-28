
package Java_Basic.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    /**
     * 类似synchronized。但是，ReentrantLock有更灵活的锁定方式，支持公平锁（默认）与不公平锁，而synchronized永远是公平的。
     *
     * 公平锁：操作会排一个队按顺序执行，来保证执行顺序。（会消耗更多的时间来排队）
     * 不公平锁：是无序状态允许插队，jvm会自动计算如何处理更快速来调度插队。（如果不关心顺序，这个速度会更快）
     */
    //参数默认false，不公平锁
    private Lock lock = new ReentrantLock();
    //公平锁
    private Lock lock1 = new ReentrantLock(true);
    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }

    private void function1(){
        //如果已经被lock，则立即返回false不会等待，达到忽略操作的效果
        if (lock.tryLock()) {
            try {
                //操作
            } finally {
                lock.unlock();
            }
        }
    }
}
