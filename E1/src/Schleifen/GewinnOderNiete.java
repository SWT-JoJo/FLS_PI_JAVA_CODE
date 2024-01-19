package Schleifen;

public class GewinnOderNiete {
    public static void main(String[] args) {
        int gewinne = 0;
        int nieten = 0;

        for(int i = 1; i <= 10;){ //Überprüfung ob i (anzahl der würfe) kleiner oder gleich 0 ist
            int würfel = (int) (Math.random() * 6 +1); // Würfeln (Zahl von 1 bis 6 generieren

            if(würfel == 6){ //Überprügen ob 6 gewürfelt wurde
                    System.out.println("Gewinn \t sie haben eine " + würfel); //Gewinn ausgabe
                    gewinne ++;
            } else{
                System.out.println("Niete \t sie haben eine "+ würfel); //Nieten ausgabe
                nieten ++;
            }
            i++;
        }

        System.out.println(" Sie haben so oft Gewonnen: " + gewinne + "und Verloren " + nieten);
    }
}



