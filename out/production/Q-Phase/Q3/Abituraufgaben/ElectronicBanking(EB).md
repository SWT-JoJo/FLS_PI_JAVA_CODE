### Aufgabe 1:

1.1)

```java
import java.util.Date;  //Imports sind in der Klausur nicht nötig, es wird von ausgegangen, dass diese bereits da sind :)

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
        return "Buchungstag: "  + buTag.toString() + " Betrag: " + betrag + " Text: " + text;
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
        List<Buchung> temp = new List<>();
        for(Buchung b : buchungen){
            if(b.getText().contains(begriff)){
                temp.add(b);
            }
        }
        
        return temp;
    }
}
```


### Aufgabe 2

```Java
import socketio.*;

public class EBServer() {
    private ServerSocket server;
    private int port;
    private EBVerwaltung eb;


    public EBServer(int port, EBVerwaltung eb) {
        this.eb = eb;
        this.port = port;
        server = new ServerSocket(port);

        startServer();
    }

    public void startServer() {
        Konto k;
        Socket clientSocket = server.accept();
        clientSocket.write("+ OK E-Banking");
        String[] clientCommand;
        do {
            String input = clientSocket.read();
            clientCommand = input.split(";");

            if (clientCommand[0].equalsIgnoreCase("anmelden")) {
                k = eb.anmelden(clientCommand[1], clientCommand[2]);
                if (k == null) {
                    clientSocket.write("-ERR: Login Fehlgeschlagen");
                } else {
                    clientSocket.write("+ OK Willkommen");
                }
            } else if (clientCommand[1].equalsIgnoreCase("ueberweisen") && k != null) {
                Konto empfaenger = eb.sucheKonto(clientCommand[2]);

                if (empfaenger == null) {
                    clientSocket.write("-ERR Ungültige IBAN");
                } else {
                    if (eb.ueberweisen(k, empfaenger, clientCommand[2], Double.parseDouble(clientCommand[3]))) {
                        clientSocket.write("+OK Überweisung erfolgt");
                    } else {
                        clientSocket.write("-ERR Überweisung nicht erfolgt");
                    }
                    clientSocket.write("Aktueller Kontostand: " + k.getKontoStand());
                }
            }

        } while (!clientCommand[0].equalsIgnoreCase("quit") || k == null);
    }
}   
```

### Aufgabe 3

3.2)

````java
import socketio.Socket;

import java.util.ArrayList;


//Nur die Änderungen
public class EBServer {

    
    
}

````