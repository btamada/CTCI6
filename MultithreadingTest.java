import java.util.*;
import java.text.DateFormat;

/**
 * Created by Bryan Tamada on 1/7/16.
 */
public class MultithreadingTest extends Thread {

    public void run() {
        for(int i = 1; i <= 3; ++i) {
            System.out.println(activeCount());
            printMsg("Hello World!");
            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Thread getTime = new MultithreadingTest();
        Thread anotherThread = new MultithreadingTest();
        getTime.start();
        getTime.setPriority(0);
        anotherThread.start();
        anotherThread.setPriority(10);
    }

}
