package Q1.Vererbung.VierEck;

public class Viereck {
    protected double laenge;
    protected double hoehe;

    protected double flaechenberrechnung(){
        return laenge * hoehe;
    }

    protected double umfangberrechnung(){
        return (2 * laenge) + (2 * hoehe);
    }
}