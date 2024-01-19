package Datentypen;

public class NotenRechner {
    public static void main(String[] args){
        int klausur1, klausur2, test1, test2, anzahl;   // Vairablen werden deklariert
        double notenschnitt;                                // ""

        // Variablen verden Initalisiert (Wert zuweisen)
        klausur1 = 2;         
        klausur2 = 3;   
        test1 = 4;  
        test2 = 2;
        anzahl = 6;

        // Der Durchschnitt wird berrechnit mit beide klausuren mal 2 und dann alle zahlen addiert.
        // Das Ergebniss dann durch die Anzahl teilen 

        // Lösung 1 : In die rechnung reinfach ein double einfügen hier anstatt "Klausur*2" schreibt man "Klausur*2.0"
        // Lösung 2: Typcast-ing, vor der Rechnung in klammern den Gewünschte Datentypen reinschreiben hier "(double)"

        notenschnitt = (double) /* Typecast: (Double) */ (klausur1*2.0 + klausur2*2.0 + test1 +test2)/anzahl;

        // Ergebnisse ausgeben
        System.out.println("1.Klausur: " + klausur1);
        System.out.println("2.Klausur: " + klausur2);
        System.out.println("1.Test: " + test1);
        System.out.println("2.Test: " + test2);
        System.out.println("________________________");
        System.out.println("Notenschnitt = " + ( (int) ((notenschnitt * 100) + 0.5) / 100.0 ));

        int note;
        note = (int) (notenschnitt + 0.5);   // gibt der Variable Note den wer notenschnitt und typcasted ihn als Int und nicht mehr als Doule dabei werde die nachkommastellen abgescnitten
       
        System.out.println("Zeugnisnote = " +  note);

    }
}