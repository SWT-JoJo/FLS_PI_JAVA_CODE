package E2.OOP.BMI;

import java.text.DecimalFormat;

public class Patient {
    private String name;
    private char geschlecht;
    private double gewicht;
    private double groeße;


    public Patient(String name, char geschlecht, double gewicht, double groeße){
        this.name = name;
        this.geschlecht = geschlecht;
        this.gewicht = gewicht;
        this.groeße = groeße;
    }

    public double bmiBerechen(){
        return gewicht / Math.pow(groeße, 2);
    }

    public double idealBerechnen(){
        int ideal = 0;
        if(geschlecht == 'm'){
            ideal = 22;
        }
        else if(geschlecht == 'w'){
            ideal = 21;
        }


        return ideal * Math.pow(groeße,2);

    }

    public double idealBorca(){
        return (groeße * 100) - 100;
    }

    public String zustandBestimmen(){
        double bmi = bmiBerechen();
        String status ="";

        if(bmi >= 30){
            status = "Adipositas (Fettleibigkeit";
        }
        else if(bmi >= 25 && geschlecht == 'm' || bmi >= 24 && geschlecht == 'w'){
            status = "Übergewichtig";
        }   
        else if(bmi >= 20 && geschlecht == 'm' || bmi >= 19 && geschlecht == 'w' ){
            status = "Normal";
        }
        else {
            status = "Untergewichtig";
        }
        return status;
    }

    public void ausgeben(){
        DecimalFormat df_zahlen = new DecimalFormat("#,###,###,###,###,##0.##");

        System.out.println("Auswertung ihrer Daten ");
        System.out.println("-----------------------\n");

        System.out.println("Name:\t\t\t\t\t"            + name);
        System.out.println("Ihr BMI:\t\t\t\t"           + df_zahlen.format(bmiBerechen()));
        System.out.println("Ideales Gewicht:\t\t"       + df_zahlen.format(idealBerechnen()) +"kg");
        System.out.println("Idealses Borga Gewicht:\t"  + idealBorca());
        System.out.println("Sie sind:\t\t\t\t"          + zustandBestimmen());
    }
}



