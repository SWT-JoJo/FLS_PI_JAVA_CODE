### Aufgabe 1:

1.1)

```java
import java.util.Date;  //Imports sind in der Klausur nicht nötig, es wird von ausgegangen, dass diese berreits da sind :)

public class Buchung() {
    private Date buTag;
    private String text;
    private double betrag;


    public Buchung(String text, double betrag) {
        this.text = text;
        this.betrag = betrag;
        buTag = new Date();
        
    }
    
    public  String toString(){
        return "Buchungnstag: "  + buTag.toString() + " Betrag: " + betrag + " Text: " + text;
    }
}
```

1.2)

```java
import java.util.ArrayList;
import java.util.List;

public class Konto() {
    private String iban;
    private int pin;
    private double kontostand;
    private List<Buchung> buchungen;

    public Konto(String iban, int pin) {
        this.iban = iban;
        this.pin = EBVerwaltung.generierePin();
        kontostand = 0.0;
        buchungen = new List<>();

    }

    private void hinzufuegenBuchung(Buchung b) {
        buchungen.add(b);
    }

    private List<Buchung> sucheBuchungen(String begriff){
        List<Buchung> temp = new List<Buchung>();
        for(Buchung b : buchungen){
            if(b.getText().contains(begriff)){
                temp.add(b);
            }
        }
    }
}
```


### Aufgabe 2
