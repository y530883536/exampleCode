package multithreading;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;

public class MainApp {
    public static void main(String[] args) throws Exception{
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date());
            }
        },0,1000);
    }
}
