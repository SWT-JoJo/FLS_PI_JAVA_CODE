package Q1.Assoziationen.Konto;

import java.util.Scanner;

public class Kunde {
    private final String name;
    private final int kundenNr;
    private Konto meinKonto;
    private  static int autowert = 1000;

    public Kunde(String name){
        this.name = name;
        this.kundenNr = autowert++;  //kundenNr = autowert++; => kundenNr = autowowert; autowert ++;
    }

    public void kontoAnlegen(){
        Scanner scan = new Scanner(System.in);
        //System.out.print("Eingabe KontoNr: ");
        //int newKontoNr = scan.nextInt();
        System.out.print("Eingabe Kontotyp: ");
        String newKontotyp = scan.next();

        meinKonto = new Konto(newKontotyp);
    }

    public void kontoDatenAusgeben(){
        System.out.println(name + "(Kundennummer: " + kundenNr+") hat das " + meinKonto.getKontotyp() +" " + meinKonto.getKontoNr());
    }
}
