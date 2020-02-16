package thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NewCall call = new NewCall();
        FutureTask<String> futureTask = new FutureTask<>(call);
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println("线程返回结果为：" + result);
    }

    private static class NewCall implements Callable {
        @Override
        public String call() throws Exception {
            System.out.println("执行了call方法");
            return "这是线程的返回值";
        }
    }
}
