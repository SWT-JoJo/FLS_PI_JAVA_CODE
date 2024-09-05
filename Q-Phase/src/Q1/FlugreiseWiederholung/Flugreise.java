package Q1.FlugreiseWiederholung;

public class Flugreise {
    private boolean[] sitzplatzliste;
    private String fluggeselschaft;
    private String flugzeugtyp;
    private String kennung;

    public Flugreise(int anzSitzplätze, String fluggeselschaft, String flugzeugtyp, String kennung){
        sitzplatzliste = new boolean[anzSitzplätze];
        this.fluggeselschaft = fluggeselschaft;
        this.flugzeugtyp = flugzeugtyp;
        this.kennung = kennung;
    }

    public void datenausgabe(){
        System.out.println("Die Daten für Ihren Flug lauten: \n");
        System.out.println("Fluggeselschaft:\t"     + fluggeselschaft);
        System.out.println("Flugzeugtyp:\t\t"       + flugzeugtyp);
        System.out.println("Flug-Kennung:\t\t"      + kennung);
        System.out.println("Anz. Sitzplätze:\t"     + sitzplatzliste.length);
    }

    private boolean pruefenObSitzplatzFrei(int sitznummer){
        boolean temp;

        //überprüen ob der Sitz ungebucht ist (Frei ist /false)
        if(!sitzplatzliste[sitznummer]){
            temp = true;
        }
        else{
            temp  = false;
        }


        return  temp;
    }

    public boolean sitzplatzreservierung(int sitznummer){
        boolean status;
        if(pruefenObSitzplatzFrei(sitznummer-1)){
            status = true;
            sitzplatzliste[sitznummer -1 ] = true;
        }
        else {
            status = false;
        }

        return status;
    }



}
