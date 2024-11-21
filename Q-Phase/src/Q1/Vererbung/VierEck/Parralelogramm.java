package Q1.Vererbung.VierEck;

public class Parralelogramm extends Viereck{
    private final double winkel;
    public Parralelogramm(double laenge, double hoehe, double winkel){
        super.laenge = laenge;
        super.hoehe = hoehe;
        this.winkel = winkel;
    }

    public double flaecheBerrechnen(){
        return laenge * hoehe * Math.sin(Math.toRadians(winkel));
    }

    public double diagonaleEberrechnen(){

            return Math.sqrt(Math.pow(laenge,2) + Math.pow(hoehe,2) + 2 * laenge * hoehe * Math.cos(Math.toRadians(winkel)));

    }

    public double diagonalefberrechnen(){

        return Math.sqrt(Math.pow(laenge,2) + Math.pow(hoehe,2) - 2 * laenge * hoehe * Math.cos(Math.toRadians(winkel)));

    }
}