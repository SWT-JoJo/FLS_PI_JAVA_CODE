package Arrays.Part2;

import java.util.Scanner;

public class Sportfest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] sportfest = {{"9:30 Uhr", "Diskuswurf", "Nebenplatz", "Jugendmeisterschaft"},
                {"10:00 Uhr", "5-km-Lauf", "Stadion - Laufbahn", "Offener Lauf"},
                {"11:00 Uhr", "Halbmarathon", "Waldgebiet", "Teilnahme ab 18 Jahren"},
                {"12:00 Uhr", "Stabhochsprung", "Stadion - Hochsprunganlage", "Nur Frauen"},
                {"13:00 Uhr", "Weitsprung", "Stadion - Weitsprunganlage", "Keine"},
                {"14:00 Uhr", "Fußball", "Stadion - Fußballplatz", "Teilnahme nur für Mitglieder des Vereines"}};

        System.out.print("Geben sie die Disziplin ein: ");
        String input =  scan.nextLine();

        for(int i = 0; 0 < sportfest.length;i++){
            if(input.equalsIgnoreCase(sportfest[i][1])){
                System.out.println("Infos zur Gesuchten Disziplin: ");
                for(int k = 0; k < sportfest[i].length;k++){
                    System.out.println(sportfest[i][k]);
                }
                break;
            }
        }
    }
}
