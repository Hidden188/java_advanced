package thread;

public class ExtendsThread extends Thread {

	ExtendsThread() {
		// 创建第二个线程
		super("Demo Thread");
		System.out.println("children thread:" + this);
		start();
	}
	
	// 第二个线程入口
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("children thread:" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("children exception");
			}
			System.out.println("Exiting children thread.");
		}
	}
	
	public static void main(String[] args) {
		new ExtendsThread(); // 创建一个新的子线程
		// 创建一个新的主线程
		for (int i = 0; i < 10; i++) {
			System.out.println("main thread:" + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("main exception");
			}
			System.out.println("Exiting main thread");
		}
	}

}
