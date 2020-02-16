package thread;

import java.util.ArrayList;
import java.util.List;

class UserThread extends Thread {
    private List<UserDao> list;
    
    public UserThread(List<UserDao> list) {
        this.list = list;
    }
    
    @Override
    public void run() {
        for (UserDao userDao : list) {
            System.out.println(userDao.getId() + "; " + userDao.getName() + "; " + userDao.getAge());
            // 其他线程操作
        }
    }
}

public class ThreadDemo {

    // 用户初始化，创建n个用户
    private static List<UserDao> userInie() {
        List<UserDao> userDaoList = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            UserDao userDao = new UserDao();
            userDao.setId("user" + i);
            userDao.setName("name" + i);
            userDaoList.add(userDao);
        }
        return userDaoList;
    }
    
    public static void main(String[] args) {
        /**
         * 1 初始化用户
         * 2 分配每个线程可以发多少条短信
         * 3 计算一共需要多少个线程
         * 4 写程序、执行程序
         */
        List<UserDao> userList = userInie();
        int userThreadPage = 100;
        List<List<UserDao>> threadLists = ListUtils.splitList(userList, userThreadPage);
        for (List<UserDao> threadList : threadLists) {
            UserThread userThread = new UserThread(threadList);
            userThread.start();
        }
    }
}
