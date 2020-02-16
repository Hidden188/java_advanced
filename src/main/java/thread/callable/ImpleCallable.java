package thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ImCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("子线程启动了");
		return "子线程";
	}

}

public class ImpleCallable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<String> future = executor.submit(new ImCallable());
		System.out.println("主线程启动");
		String str = future.get();
		System.out.println("str: " + str);
	}
}