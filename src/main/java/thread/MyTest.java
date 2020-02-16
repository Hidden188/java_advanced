package thread;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

class InputTest extends Thread {
	private ThreadUserDao threadUserDao;

	public InputTest(ThreadUserDao threadUserDao) {
		this.threadUserDao = threadUserDao;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			synchronized (threadUserDao) {
				if (count == 0) {
					threadUserDao.name = "翠花";
					threadUserDao.sex = "女";
				} else {
					threadUserDao.name = "二狗子的二哥的干儿子";
					threadUserDao.sex = "男";
				}
				count = (count + 1) % 2;
			}
		}
	}
}

class OutputTest extends Thread {
	ThreadUserDao threadUserDao;

	public OutputTest(ThreadUserDao threadUserDao) {
		this.threadUserDao = threadUserDao;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (threadUserDao) {

				System.out.println(threadUserDao.name + "," + threadUserDao.sex);
			}
		}
	}
}

public class MyTest {

	public String name;
	public String sex;

	public static void main(String[] args) {
		ThreadUserDao threadUserDao = new ThreadUserDao();
		Thread input = new InputTest(threadUserDao);
		Thread output = new OutputTest(threadUserDao);
		//input.start();
		//output.start();
		/*
		 * TestSuper ts2 = new TestSuper(); System.out.println("ts2: " +
		 * ts2.getNumber()); TestSuper ts = new TestSuper(); System.out.println("ts: " +
		 * ts.getNumber());
		 */
		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]:" + args[i]);
		}
		AtomicInteger atoi = new AtomicInteger();
	}
}

class TestSuper {
	public int getNumber() {
		return super.hashCode();
	}
}
