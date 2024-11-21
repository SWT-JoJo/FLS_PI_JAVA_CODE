package Q1.Vererbung.Kreuzfahrten;

public class KreuzfahrtTester {
    public static void main(String[] args) {
        Passagier p1 = new Passagier("Jonah", "Schroeder");
        Bucher b1 = new Bucher("Fabian" , "Sunkel", "fabian.sunkel@gmail.com", "DE21500105174663348731");

        System.out.println("---|Passagier|---");
        System.out.println(p1 + "\n");
        System.out.println("-----|Bucher-|----");
        System.out.println(b1);

    }
}
