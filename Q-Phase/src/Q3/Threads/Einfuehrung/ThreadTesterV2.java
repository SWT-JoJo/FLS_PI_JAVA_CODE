package Q3.Threads.Einfuehrung;

public class ThreadTesterV2 {
  
  public ThreadTesterV2(){
    
    int sleeptime = 100;
    int anzahlDurchlaeufe = 5; 
    
    System.out.println("\n\n\tStarte Ausgabe:\n");
    Zahlenausgabe z1 = new Zahlenausgabe(1, anzahlDurchlaeufe, sleeptime, "\t");
    Zahlenausgabe z2 = new Zahlenausgabe(2, anzahlDurchlaeufe, sleeptime, "\t\t"); 
    Zahlenausgabe z3 = new Zahlenausgabe(3, anzahlDurchlaeufe, sleeptime, "\t\t\t"); 
    Zahlenausgabe z4 = new Zahlenausgabe(4, anzahlDurchlaeufe, sleeptime, "\t\t\t\t"); 

    z1.start();
    z2.start();
    z3.start();
    z4.start();

    while(z1.isAlive() || z2.isAlive() || z3.isAlive() || z4.isAlive()){};

    System.out.println("\n\tProgramm beendet!");
    
  }
  

  public static void main(String[] args) {
      new ThreadTesterV2();
  }


  
}


