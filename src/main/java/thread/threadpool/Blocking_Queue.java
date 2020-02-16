package thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Blocking_Queue {

	// 存队列的时候，满了就等待，取队列的时候，找不到就等待
	public static void main(String[] args) throws InterruptedException {
		// BlockingQueue是有界队列，
		// 后面的Integer值表示最多可以存放几个队列
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(4);
		blockingQueue.offer("Jowdal"); // 添加非阻塞式队列
		blockingQueue.offer("Simon", 3, TimeUnit.SECONDS);
		System.out.println(blockingQueue.poll());
		System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));
		
		BlockingQueue<String> blockingQueue2 = new LinkedBlockingDeque<>();
		blockingQueue2.offer("");
	}

}
