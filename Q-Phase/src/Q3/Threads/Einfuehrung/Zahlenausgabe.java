package Q3.Threads.Einfuehrung;


class Zahlenausgabe extends Thread {
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
          System.out.println("Thread " + nummer + " is starting...\n");
          for (int i = 0; i < anzahlDurchlaeufe; i++) {
              System.out.println(tabulator + "Z" + nummer + ": " + i + "\n");
              Thread.sleep(sleeptime);

          }
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }

  }

}
