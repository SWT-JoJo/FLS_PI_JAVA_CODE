package Q3.Threads.ThreadsMitRunnableWiederholung;

public class MainThread {
    public static void main(String[] args) {

        Thread t1 = new Thread(new CounterThread(10));
        Thread t2 = new Thread(new CounterThread(20));
        Thread t3 = new Thread(new CounterThread(30));

        try {
            t1.start();
            Thread.sleep(100);
            t2.start();
            Thread.sleep(100);
            t3.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (t1.isAlive() || t2.isAlive() || t3.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
