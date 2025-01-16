package Q1.SortierAlgorythmen;

public class BubbleSort {
    private int anzahlSchleifendurchlaeufe = 0;
    private int anzahlTauschvorgaenge = 0;


    public int[] bubbleSort(int[] zahlen){
        for(int i = zahlen.length -1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(zahlen[j] > zahlen[j +1]){
                    int temp = zahlen[j +1];
                    zahlen[j+1] = zahlen[j];
                    zahlen[j] = temp;
                    anzahlTauschvorgaenge ++;
                }
            }

            anzahlTauschvorgaenge++;
        }

        return zahlen;
    }


    //Getter

    public int getAnzahlSchleifendurchlaeufe() {
        return anzahlSchleifendurchlaeufe;
    }

    public int getAnzahlTauschvorgaenge() {
        return anzahlTauschvorgaenge;
    }

}
