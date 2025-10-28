package Q3.Threads.DEMO.Task;

public class ThreadTester {
  
  public ThreadTester(){
    
    int sleeptime = 100;
    int anzahlDurchlaeufe = 5; 
    
    System.out.println("\n\n\tStarte Ausgabe:\n");
    Zahlenausgabe z1 = new Zahlenausgabe(1, anzahlDurchlaeufe, sleeptime, "\t"); 
    Zahlenausgabe z2 = new Zahlenausgabe(2, anzahlDurchlaeufe, sleeptime, "\t\t"); 
    Zahlenausgabe z3 = new Zahlenausgabe(3, anzahlDurchlaeufe, sleeptime, "\t\t\t"); 
    Zahlenausgabe z4 = new Zahlenausgabe(4, anzahlDurchlaeufe, sleeptime, "\t\t\t\t"); 

    z1.run();
    z2.run();
    z3.run();
    z4.run();
    
    
    System.out.println("\n\tProgramm beendet!");
    
  }
  

  public static void main(String[] args) {
      new ThreadTester();
  }
  
}


class Zahlenausgabe {    
  //Instanzvariablen deklarieren
    int nummer;
    int anzahlDurchlaeufe;
    int sleeptime;
    String tabulator;
  
  
  public Zahlenausgabe(int nummer, int anzahlDurchlaeufe, int sleepTime, String tabulator){
    //Methoden-Rumpf ergänzen
      this.nummer = nummer;
      this.anzahlDurchlaeufe = anzahlDurchlaeufe;
      this.sleeptime = sleepTime;
      this.tabulator = tabulator;
    
  }    
  
  public void run() {
	// Methoden-Rumpf ergänzen
      try {
          for (int i = 0; i < anzahlDurchlaeufe; i++) {
              System.out.println(tabulator + "Z" + nummer + ": " + i);
              Thread.sleep(sleeptime);

          }
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }


  }
  
}
