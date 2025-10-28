package Q3.Threads.DEMO;

public class Startklasse {

    public static void main(String[] args) {

        //ABCPrinter eins = new ABCPrinter();
        //ABCPrinter zwei = new ABCPrinter();

        /*ABCThreadRunnable eins = new ABCThreadRunnable();
        ABCThreadRunnable zwei = new ABCThreadRunnable();

        Thread one = new Thread(eins);
        Thread two = new Thread(zwei);*/

        ABCPrinterThread one = new ABCPrinterThread();
        ABCPrinterThread two = new ABCPrinterThread();

        one.start();
        two.start();
        //eins.start();
        //zwei.start();

    }
}
