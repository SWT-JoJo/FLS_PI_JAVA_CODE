package Schleifen;

public class IwantThe0 {
    public static void main(String[] args) {

        double zahl = 1;
        long a = 0;
        while (zahl != 0){
            zahl = Math.random();
            System.out.println(zahl + " Versuche: " + a);
            a ++;


        }

        System.out.println("Versuche die es gebraucht hat: " + a);

}
}