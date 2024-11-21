package Q1.Vererbung.Tier;

public class HundTester {
    public static void main(String[] args) {
        HoellenHund hoellenHund = new HoellenHund(34, 800, 33);
        System.out.println("Name: " + hoellenHund.name);
        System.out.println("Verderbheit: " + hoellenHund.verderbtheit);
        System.out.println("Hechenfrequenz: " + hoellenHund.hechelfrequenz);
        System.out.println("anzSeelen: " + hoellenHund.anzSeelen);
        System.out.println("verderblichkeisfaktor: " + hoellenHund.verderblichkeitsfaktor);
        System.out.println("Gefährlichkeit: " + hoellenHund.gefaehlichkeit);
    }
}
