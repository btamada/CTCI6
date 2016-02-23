/**
 * Created by Bryan Tamada on 1/23/16.
 */
public class Multithreading extends Thread {

    public void run() {
        try {
            for(int i = 0; i < 5; ++i) {
                Thread.sleep(5000);
                if(Thread.currentThread().isDaemon()) System.out.println("This is a daemon thread...");
                else System.out.println("This is a user thread...");
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... foobar) {
        Multithreading m1 = new Multithreading();
        Multithreading m2 = new Multithreading();
        Multithreading m3 = new Multithreading();

        m1.setDaemon(true);

        m1.start();
        m2.start();
        m3.start();
    }

}
