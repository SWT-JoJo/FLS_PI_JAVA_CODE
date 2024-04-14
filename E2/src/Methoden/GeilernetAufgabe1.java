package Methoden;
import java.awt.Point;
import java.util.Scanner;

public class GeilernetAufgabe1 {
    public static void main(String[] args) {
        GeilernetAufgabe1 geilernetAufgabe1 = new GeilernetAufgabe1();
        geilernetAufgabe1.idk();
    }
    void idk(){
        Scanner scan = new Scanner(System.in);
        Point p1 = new Point();
        Point p2 = new Point();
        System.out.println("Geben sie die Punkt-Koordinaten ein (KEINE Kommazahlen): ");

        System.out.print("Punkt 1 - X- Wert: ");
        p1.x = scan.nextInt();
        System.out.print("Punkt 1 - Y- Wert: ");
        p1.y = scan.nextInt();
        System.out.print("Punkt 2 - X- Wert: ");
        p2.x = scan.nextInt();
        System.out.print("Punkt 2 - Y- Wert: ");
        p2.y = scan.nextInt();


        int flaeche = flaeche(p1, p2);

        System.out.println("Die Fläche beträgt: " + flaeche);
    }

    public  int flaeche(Point a, Point b){
        int height = Math.abs(b.y - a.y);
        int width = Math.abs(b.x - a.x);
        return (width * height);
    }
}