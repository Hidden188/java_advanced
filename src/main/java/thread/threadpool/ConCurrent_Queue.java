package thread.threadpool;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConCurrent_Queue {

	public static void main(String[] args) {
		// 阻塞队列最大好处，是防止队列容器溢出，防止丢失数据
		// ConcurrentLinkedDeque是非阻塞队列，是无界队列
		ConcurrentLinkedDeque<String> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
		concurrentLinkedDeque.offer("Mark");
		concurrentLinkedDeque.offer("Luke");
		concurrentLinkedDeque.offer("John");
		// 获取队列
		System.out.println(concurrentLinkedDeque.poll());
		System.out.println(concurrentLinkedDeque.poll());
		System.out.println(concurrentLinkedDeque.poll());
		System.out.println(concurrentLinkedDeque.poll());
		// 获取队列个数
		System.out.println(concurrentLinkedDeque.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
