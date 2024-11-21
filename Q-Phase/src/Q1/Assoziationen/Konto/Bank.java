package Q1.Assoziationen.Konto;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
       Bank bank = new Bank();
       bank.bankMenu();
    }

    public void bankMenu(){
        Scanner scan = new Scanner(System.in);
        String name;

        System.out.println("Kunde 1:");
        System.out.print("Name des KontoInhabers: ");
        name = scan.nextLine();

        Kunde k1 = new Kunde(name);
        k1.kontoAnlegen();

        System.out.println();

        System.out.println("Kunde 2:");
        System.out.print("Name des KontoInhabers: ");
        name = scan.next();
        Kunde k2 = new Kunde(name);
        k2.kontoAnlegen();

        System.out.println();

        System.out.println("Kontouebesicht:");
        k1.kontoDatenAusgeben();
        k2.kontoDatenAusgeben();
    }
}
