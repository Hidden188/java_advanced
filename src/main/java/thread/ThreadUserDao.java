package thread;

class Input extends Thread {
	private ThreadUserDao threadUserDao;

	public Input(ThreadUserDao threadUserDao) {
		this.threadUserDao = threadUserDao;
	}

	@Override
	public void run() {
		int count = 0;
		while (true) {
			try {
				synchronized (threadUserDao) {
					if (!threadUserDao.flag) {
						threadUserDao.wait();
					}
					if (count == 0) {
						threadUserDao.name = "翠花";
						threadUserDao.sex = "女";
					} else {
						threadUserDao.name = "二狗子的二哥的干儿子";
						threadUserDao.sex = "男";
					}
					count = (count + 1) % 2;
					threadUserDao.flag = true;
					threadUserDao.notify();
				}
			} catch (Exception e) {

			}
		}
	}
}

class Output extends Thread {
	ThreadUserDao threadUserDao;

	public Output(ThreadUserDao threadUserDao) {
		this.threadUserDao = threadUserDao;
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (threadUserDao) {
					if (threadUserDao.flag) {
						threadUserDao.wait();
					}
					System.out.println(threadUserDao.name + "," + threadUserDao.sex);
					threadUserDao.flag = true;
					threadUserDao.notify();
				}
			} catch (Exception e) {

			}
		}
	}
}

public class ThreadUserDao {

	public String name;
	public String sex;
	public Boolean flag = false;

	public static void main(String[] args) {
		ThreadUserDao threadUserDao = new ThreadUserDao();
		Thread input = new Input(threadUserDao);
		Thread output = new Output(threadUserDao);
		input.start();
		output.start();
	}
}
