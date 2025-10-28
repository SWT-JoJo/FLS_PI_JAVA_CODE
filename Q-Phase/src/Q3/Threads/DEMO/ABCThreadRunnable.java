package Q3.Threads.DEMO;

public class ABCThreadRunnable implements Runnable {

    public void run() {

        for (char i = 'a'; i <= 'z'; i++) {
            System.out.println(i);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }
    }
/*
    public void start() {
        run();
    }
*/

}
