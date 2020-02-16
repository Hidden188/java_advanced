package thread;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestHighConcurrency {
    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

    /**
     * 使用java线程测试并发操作
     */
    public static void thread1() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号里，控制并发的线程数量
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 闭锁，可以实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                System.out.print("运行execute" + count + 1 + "次：");
                // 执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，允许同性，否则线程阻塞等待，知道获取到许可
                try {
                    semaphore.acquire();
                    add();
                    System.out.println(new Date());
                    // 释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 闭锁减1
                countDownLatch.countDown();
            });
        }
        // 线程阻塞，知道闭锁值为0时，阻塞才释放，继续往下执行
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);
        // log.info("count{}" + count);
        // System.out.println("count{}" + count);
    }

    private static void add() {
        count++;
    }

    // 模拟并发登录网址，查看服务器峰值
    public static void getUrl() throws InterruptedException {
        // 锁住所有线程，等待并发执行
        final CountDownLatch begin = new CountDownLatch(1);
        final ExecutorService exec = Executors.newFixedThreadPool(100);
        for (int index = 0; index < 10000; index++) {
            final int NO = index + 1;
            System.out.println("激活线程" + NO);
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 等待，所有一起执行
                        begin.await();
                        // 开始模拟登录等待。。。
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("运行线程No." + NO);
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
    }

    public static void main(String[] args) throws Exception {
        mySecondThread();
    }

    public static void myThread() {
        final CountDownLatch begin = new CountDownLatch(1);
        final ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 1; i < 10; i++) {
            System.out.println("激活第" + i + "线程");
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/newems", "root", "ofbiz");
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("select * from building where input_date<='2014-12-01'");
                        while (rs.next()) {
                            String buildingName = rs.getString("building_name");
                            String buildingAddress = rs.getString("building_address");
                            System.out.println("buildingName:" + buildingName + "  buildingAddress:" + buildingAddress);
                        }
                        if (rs != null) {
                            rs.close();
                        }
                        if (st != null) {
                            st.close();
                        }
                        if (con != null) {
                            con.close();
                        }
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(run);
        }
        System.out.println("开始执行");
        System.out.println(begin.toString());
        begin.countDown();
        executorService.shutdown();
    }
    
    public static int count2222 = 1;
    
    public static void mySecondThread() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(20);
        final CountDownLatch countDownLatch = new CountDownLatch(98);
        for(int i = 1; i <= 98; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    count2222++;
                    System.out.println("count2222:" + count2222);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count2222:" + count2222);
    }
    
    
    
    
    
}
