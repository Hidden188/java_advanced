package thread;

import java.util.ArrayList;
import java.util.List;

public class SaleRailwayTickets implements Runnable {

	private static int count = 3000;

	@Override
	public void run() {
		while (count > 0) {

			try {
				Thread.sleep(6000);
			} catch (Exception e) {
			}

			sale();
		}
	}

	private static void sale() {
		synchronized(SaleRailwayTickets.class) {
		if (count > 0) {
			System.out.println(Thread.currentThread().getName() + "抢到了第" + (3001 - count) + "张火车票");
			count--;
		}}
	}

	public static void main(String[] args) {
		SaleRailwayTickets saleRailwayTickets = new SaleRailwayTickets();
		List<Thread> threadList = new ArrayList<>();
		for (int i = 1; i < 10000; i++) {
			threadList.add(new Thread(saleRailwayTickets, "窗口" + i));
		}
		System.out.println("开始抢票");
		for (int i = 0; i < threadList.size(); i++) {
			Thread thread = threadList.get(i);
			System.out.println("现在打开线程list里面第" + i + "个数据");
			thread.start();
		}
	}

}
