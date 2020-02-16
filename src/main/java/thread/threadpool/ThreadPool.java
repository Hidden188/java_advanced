package thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    public static void main(String[] args) {
        // 可缓存的线程池重复利用，无限大小
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            // 可执行线程execute启动线程
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("cached--" + Thread.currentThread().getName() + ": " + temp);
                }
            });
        }

        // 可固定长度的线程池
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            // 可执行线程execute启动线程
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("fixed--" + Thread.currentThread().getName() + ": " + temp);
                }
            });
        }

        // 可定时的线程池
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            // 可执行线程schedule启动线程，而execute不能定时
            newScheduledThreadPool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("schedule--" + Thread.currentThread().getName() + ": " + temp);
                }
            }, 3, TimeUnit.SECONDS);
        }

        // 单线程
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            // 可执行线程schedule启动线程，而execute不能定时
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("single--" + Thread.currentThread().getName() + ": " + temp);
                }
            });
        }
        // 这个线程池不会停止，需要手动停止
        newSingleThreadExecutor.shutdown();
    }

}
