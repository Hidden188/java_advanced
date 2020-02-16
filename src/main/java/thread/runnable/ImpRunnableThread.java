package thread.runnable;

public class ImpRunnableThread implements Runnable {

	private String message;
	
	public ImpRunnableThread(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(message);
		}
	}

	public static void main(String[] args) {
		Thread thread = new Thread(new ImpRunnableThread("hello"));
		thread.start();
	}

}
