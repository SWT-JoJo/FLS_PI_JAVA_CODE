package Q1.ArrayListen.Schule;
import java.util.Scanner;

public class Verwaltung {

    public static void main(String[] args) {
        Verwaltung vw = new Verwaltung();
        vw.eingabe();
    }

    public  void eingabe() {
        Scanner scan = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("*           Verwaltung            *");
        System.out.println("***********************************");
        System.out.println();

        System.out.print("Geben sie den Klassennamen ein: ");
        Klasse k1 = new Klasse(scan.next());
        System.out.println("Klasse erfolgreich erstellt\n");


        System.out.print("Geben sie nun den Namen des Tutors ein: ");
        String newTutorName = scan.next();
        System.out.print("Geben sie nun das Kürzel des Tutors ein: ");
        String newTutorKuerzel = scan.next();
        k1.setMeinTutor(new Tutor(newTutorName, newTutorKuerzel));
        System.out.println("Tutor erfolgreich zugewiesen");
        System.out.println();

        System.out.print("Geben sie nun an, wie viele Schüler sie der Klasse hinzufügen wollen: ");
        int addStudents = scan.nextInt();
        for (int i = 0; i < addStudents; i++ ){
            System.out.print("Geben sie den Namen des Schuelers ein: ");
            k1.neueSchüler(scan.next());
        }
        System.out.println("Alle Schueler erfolgreich hinzugefügt");
        System.out.println();
        System.out.println();
        ausgabe(k1);

    }

    public  void ausgabe(Klasse klasse) {
        Scanner scan = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("*          Klassenliste           *");
        System.out.println("***********************************");
        System.out.println();

        System.out.println("Klassenbezeichnung: " + klasse.getName());
        System.out.println("Tutor: " + klasse.getMeinTutor().getName() + " (" + klasse.getMeinTutor().getKuerzel()+")");

        System.out.println("Alle Schüler der Klasse "+ klasse.getName() + " :" );
        klasse.ausgabe();

    }
}