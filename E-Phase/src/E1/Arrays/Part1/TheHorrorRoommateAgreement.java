package E1.Arrays.Part1;

public class TheHorrorRoommateAgreement {
    public static void main(String[] args) {

        //creation of the Array and saving of the temps
        double[] daytemp = {22.5,22.4,22.3,22.1,21.9,21.8,21.5,21.4,21.6,21.5,21.5,21.6,21.5,22.5};
        double averageTemp = 22.0;
        boolean dayhigher = false;
        String message;
        int verstoesse = 0;
        double tempAverage = 0;

        for(int i = 0; i < daytemp.length; i++){
            tempAverage = tempAverage + daytemp[i];
        }

        tempAverage = (tempAverage/daytemp.length);

        if(tempAverage < (averageTemp - 0.5) || tempAverage < (averageTemp + 0.5)){
            System.out.println("Verstoß gegen 14 Tage abweichung");
            verstoesse ++;
        }


        // Only for Testing
        /*
        System.out.println(tempAverage);
        System.out.println(tempAverage - 0.5);
        System.out.println(tempAverage + 0.5 + "\n\n\n\n\n");
        */


        for(int i = 0; i < daytemp.length; i++){
            if(daytemp[i] < (tempAverage - 0.5) || daytemp[i] > (tempAverage + 0.5)){
                message = "Verstoß gegen +/- 0,5°C am Tag abweichung ";
                dayhigher = true;
                verstoesse ++;
            }
            else { message = "kein Verstoß"; }

            if(dayhigher) {
                if(daytemp[i] < (tempAverage - 0.7) ||daytemp[i] > (tempAverage +0.7)){
                    message = "Verstoß gegen +/- 0,7 °C an zwei aufeinanderfolgenden Tagen";
                    verstoesse ++;
                }
                dayhigher = false;
            } else {message = "kein Verstoß";}

            System.out.println(message);
        }
        System.out.println("Insgesamte Verstöße: " + verstoesse);
    }
}