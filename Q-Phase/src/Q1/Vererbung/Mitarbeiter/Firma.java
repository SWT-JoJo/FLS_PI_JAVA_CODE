package Q1.Vererbung.Mitarbeiter;

public class Firma {
    public static void main(String[] args) {
            Mitarbeiter ma1 = new Mitarbeiter();
            System.out.println("Mitarbeiter 1:");
            ma1.kennung();
            System.out.println("--------------------------" );

            System.out.println("Angestellter 1:");
            Angestellter an1 = new Angestellter();
            an1.kennung();
            an1.arbeitsplatz();
            System.out.println("--------------------------" );

            System.out.println("Angestellter 2:");
            Angestellter an2 = new Angestellter();
            an2.kennung("Hans-Dampf KG");
            an2.setEinkommen(3000);
            an2.abrechnung();
            System.out.println("--------------------------" );


        System.out.println("__________________________________________________________________________________");
        System.out.println("Arbeiter 1");
        Arbeiter ab1 = new Arbeiter();
        ab1.kennung("Ha  ns-Dampf KG");
        ab1.seteinkommen(); //ohne Stunden und lohn
        ab1.abrechnung();
        System.out.println("-----------------------");
        System.out.println("Arbeiter 2");
        Arbeiter ab2 = new Arbeiter();
        ab2.kennung("Hans-Dampf KG");
        ab2.seteinkommen(80); //nur Stunden
        ab2.abrechnung();
        System.out.println("-----------------------");
        System.out.println("Arbeiter 3");
        Arbeiter ab3 = new Arbeiter();
        ab3.kennung("Hans-Dampf KG");
        ab3.seteinkommen(15, 120); //mit Stunden und lohn
        ab3.abrechnung();
        System.out.println("-----------------------");

        System.out.println("__________________________________________________________________________________");
        System.out.println("AkkortArbeiter 1");
        Akkordarbeiter ak1 = new Akkordarbeiter();
        ak1.kennung();
        ak1.einkommen(500, 10, 0.16);
        ak1.abrechnung();
        System.out.println("-----------------------");




    }
}
