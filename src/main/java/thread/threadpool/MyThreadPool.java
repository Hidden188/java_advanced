package thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

	/**
	 * public ThreadPoolExecutor( int corePoolSize, // 核心线程数，即实际运用线程数 int
	 * maximumPoolSize, // 最大线程数，即最大可创建线程数 
	 * long keepAliveTime, // 存活时间 
	 * TimeUnit unit, // 
	 * BlockingQueue<Runnable> workQueue) { this(corePoolSize,
	 * maximumPoolSize, keepAliveTime, unit, workQueue,
	 * Executors.defaultThreadFactory(), defaultHandler ); }
	 */

	public static void main(String[] args) {
		// 只需要关注前两个参数，第三个参数一般设置为30秒
		// 核心线程数只能小于等于最大线程数
		// 核心线程数就是最大运行线程数，最大线程数是最多可以创建多少个线程
		ThreadPoolExecutor threadPoolE = new ThreadPoolExecutor(1, 2, 0l, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(3));
		// 任务1 创建的线程已经在运行了，参数1
		threadPoolE.execute(new TaskThread("任务一"));
		// 任务2 存放在队列里面，缓存，new LinkedBlockingQueue<Runnable>(3)
		threadPoolE.execute(new TaskThread("任务二"));
		// 任务3 存放在队列里面，缓存，new LinkedBlockingQueue<Runnable>(3)
		threadPoolE.execute(new TaskThread("任务三"));
		// 任务4 存放在队列里面，缓存，new LinkedBlockingQueue<Runnable>(3)
		threadPoolE.execute(new TaskThread("任务四"));
		// 任务5 创建新的线程，参数2
		threadPoolE.execute(new TaskThread("任务五"));
		// 任务6 大于最大线程数，不能创建了
		//threadPoolE.execute(new TaskThread("任务六"));
	}
}

class TaskThread implements Runnable {
	private String threadName;

	public TaskThread(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
//			Thread.currentThread().sleep(2000);
			System.out.println(Thread.currentThread().getName() + threadName);
	}

}
