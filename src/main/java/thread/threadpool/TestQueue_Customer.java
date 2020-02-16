package thread.threadpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ProducerThread implements Runnable {
	public BlockingQueue<String> blockingQueue;
	public volatile boolean FLAG = true;
	AtomicInteger atomicInteger = new AtomicInteger();

	public ProducerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		System.out.println("run start");
		try {
			while (FLAG) {
				String data = atomicInteger.incrementAndGet() + "";
				boolean offer;
				offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
				if (offer) {
					System.out.println("生产者存入队列成功" + data);
				} else {
					System.out.println("生产者存入队列失败" + data);
				}
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("生产者结束");
	}

	public void stop() {
		this.FLAG = false;
	}
}

class ConsumerThread implements Runnable {
	public BlockingQueue<String> blockingQueue;
	public volatile boolean FLAG = true;
	AtomicInteger atomicInteger = new AtomicInteger();

	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		System.out.println("消费者线程启动");
		try {
			while (FLAG) {
				String data = blockingQueue.poll(2, TimeUnit.SECONDS);
				if (data == null) {
					System.out.println("超过2秒钟，没有获取队列信息");
					FLAG = false;
					return;
				}
				System.out.println("消费者获取到data：" + data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("消费者已经停止。。。");
		}
	}

}

public class TestQueue_Customer {

	public static void main(String[] args) {
		BlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>(10);
		ProducerThread producerThread = new ProducerThread(linkedBlockingDeque);
		ConsumerThread consumerThread = new ConsumerThread(linkedBlockingDeque);
		Thread tp = new Thread(producerThread);
		Thread tc = new Thread(consumerThread);
		tp.start();
		tc.start();
		
	}

}
