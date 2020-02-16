package thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ImpCallableThread implements Callable<Integer> {

	public static void main(String[] args) {
		ImpCallableThread impThread = new ImpCallableThread();
		FutureTask<Integer> ft = new FutureTask<>(impThread);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName()
					+"的循环变量i的值为" + i);
			if(i==20) {
				new Thread(ft, "有返回值的线程").start();
			}
		}
		try {
			System.out.println("子线程的返回值为：" + ft.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		int i = 0;
		for (;i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
		return i;
	}

}
