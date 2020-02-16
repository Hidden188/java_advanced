package thread.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("触发了定时器");
            }
        }, 0, 1000);
    }
}
