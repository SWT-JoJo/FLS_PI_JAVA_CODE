````java
import java.util.ArrayList;

public class PerleVerwaltung {
    private ArrayList<Person> personen; 

    public PerleVerwaltung() {
        personen = new ArrayList<>(); 
        String temp = "";
        temp    }

    public Kunde anmelden(String email, String pw) {
        Kunde tempKunde;
        boolean kfound = false;
        for (Person tempPerson : personen) {
            if (tempPerson.getEmail().equals(email) && tempPerson instanceof Kunde) {
                Kunde temp = (Kunde) tempPerson;

                if (temp.getPasswort().equals(pw)) {
                    tempKunde == temp;
                    kfound = true;
                } else {
                    System.out.println("Passwort oder Emailadresse sind Falsch");
                }
            }
        }
        
        if(kfound){
            return tempKunde;
        } else {
            System.out.println("Kein Kunde zu den Angaben gefunden :)");
            return null;
        }
    }

    public Kunde registriereKunden(String name, String plz, String email, String pw) {
        Kunde tempKunde = new Kunde(name, plz, email, pw);
        personen.add(tempKunde);
        return tempKunde;
    }
}
````