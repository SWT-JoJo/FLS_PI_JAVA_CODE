package Q3.Threads.ThreadsMitRunnableWiederholung;

public class CounterThread implements Runnable{
    int counter;
    int id;
    static int idgen = 0;

    public CounterThread(int counter) {
        this.counter = counter;
        id = idgen;
        idgen ++;
    }

    @Override
    public void run(){

        System.out.println("Thread " + id + " is started....\n" );

        try {
            for (int i = 0; i < counter; i++) {
                System.out.println("Thread " + id + " sagt die Zahl: " + i +"\n");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
