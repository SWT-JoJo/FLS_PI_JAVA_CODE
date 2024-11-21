package Q1.ArrayListen.Praktikum;

import java.util.Scanner;

public class PraktikumsVerwaltung {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("-----| Praktikums-Verwaltung |-----\n");

        System.out.print("Geben sie den Praktikumsnamen ein: ");
        Praktikum pk = new Praktikum(scan.next());

        System.out.println("\nStudenten Hinzufügen");
        boolean neueStudent = true;
        do {
            System.out.print("Name: ");
            String name = scan.next();
            System.out.print("Note: ");
            double note = scan.nextDouble();
            pk.AddStudent(name, note);

            System.out.println();
            System.out.print("Weitern Schüler hinzufügen (1: Ja | Rest: nein): ");
            int temp = scan.nextInt();

            if(temp != 1) {
                neueStudent = false;
            }
        } while (neueStudent);

        System.out.println();
        System.out.println("-----| Praktikums-Übersicht |-----\n");
        System.out.println(pk.getName()+":\n");
        System.out.println("Teilnehmer:\t\t\t" + pk.getStudenten().size());
        System.out.println("Durchschnittsnote:\t" + pk.outputDurchschniitsNote());
        System.out.println(pk.outputStudenten());
    }
}
