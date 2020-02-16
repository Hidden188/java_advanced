/*package myUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.ofbiz.base.lang.JSON;
import org.ofbiz.entity.Delegator;
import org.ofbiz.service.DispatchContext;

public class TestMain implements Runnable {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

    *//**
     * 使用java线程测试并发操作
     *//*
    public static Map<String, Object> threadTesting(DispatchContext dctx, Map<String, Object> context) {
        Delegator delegator = dctx.getDelegator();
        // 锁住所有线程，等待并发执行
        final CountDownLatch begin = new CountDownLatch(1);
        final ExecutorService exec = Executors.newFixedThreadPool(10000);
        for (int index = 0; index < 70000; index++) {
            final int NO = index + 1;
            System.out.println("激活线程" + NO);
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 等待，所有一起执行
                        begin.await();
                        // 开始模拟登录等待。。。
                        Thread.sleep((long) (Math.random() * 10000));
                        //System.out.println("运行线程No." + NO + "：" + JSON.from(SupplierFactoryKpiConfService.findCoustructedKpiConfList(delegator, null)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.submit(run);
        }
        System.out.println("开始执行");
        // begin减一，开始并发执行
        begin.countDown();
        // 关闭执行
        exec.shutdown();
        return new HashMap<>();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 闭锁，可以实现计数器递减
        TestMain test = new TestMain();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(test);
        }
    }

    final AtomicInteger number = new AtomicInteger();
    volatile boolean bol = false;

    @Override
    public void run() {
        System.out.println(number.getAndIncrement());
        synchronized (this) {
            try {
                if (!bol) {
                    System.out.println(bol);
                    bol = true;
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("并发数量为：" + number.intValue());
        }
    }

}
*/