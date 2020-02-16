package thread;

public class HomeWork01 {

	public static void main(String[] args) {
		/**
		 * 现… 在有T1、T2、T3三个线程，
		 * 你怎样保证T2在T1执行完后执行，T3在T2执行完后执行 
		 */
		Thread thread01 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("我是第一一一个线程：" + i);
				}
			}
		});
		
		Thread thread02 = new Thread(new Runnable() {
			public void run() {
				try {
					thread01.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < 100; i++) {
					System.out.println("我是第二二二个线程：" + i);
				}
			}
		});

		Thread thread03 = new Thread(new Runnable() {
			public void run() {
				try {
					thread02.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (int i = 0; i < 100; i++) {
					System.out.println("我是第三三三个线程：" + i);
				}
			}
		});
		
		thread01.start();
		thread02.start();
		thread03.start();
	}

	/**
	 * 面试题
	 * 1.进程与线程的区别？
	 * 进程是线程的集合，线程是一条执行路径。
	 * 2.为什么要用多线程？
	 * 因为计算机的cpu运行速度远大于内存读写速度的差异，导致cpu闲置，使用多线程就可以提高运行效率。
	 * 3.多线程的创建方式？
	 * ①继承Thread类；②实现Runnable接口；③内部类的方式实现。
	 * 4.继承Thread好还是实现Runnable接口好？
	 * 实现Runnable接口好，因为接口可以实现多个，继承只能有一个，使用Runnable有利于扩展类。
	 * 5.你在哪里用到了多线程？
	 * 短信分批发送；迅雷下载等。
	 */
}
