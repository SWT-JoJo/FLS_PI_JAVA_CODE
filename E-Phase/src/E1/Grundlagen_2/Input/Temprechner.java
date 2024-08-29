package E1.Grundlagen_2.Input;
import java.util.Scanner;
public class Temprechner {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Bitte geben sie eine Grad Celsius zahl ein: ");
        double celsius = scan.nextDouble();

        double fahrenheit = (celsius * 1.8 + 32);
        double kelvin  = (celsius  + 273.15);

        System.out.println("");
        System.out.println("In Fahrenheit: " + ((int)(fahrenheit + 100) / 100.0) + "°F");
        System.out.println("In Kelvin: " + ((int)(kelvin + 100) + "°K"));

        scan.close();

        
    }
}
