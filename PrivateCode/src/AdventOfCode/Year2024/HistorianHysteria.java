package AdventOfCode.Year2024;

public class HistorianHysteria {
   public int[] array1 = new int[1];
    public static void main(String[] args) {
        HistorianHysteria hh = new HistorianHysteria();
        hh.verarbeitung();
    }

    public int[] sort(int[] zahlen){
        for(int i = zahlen.length -1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(zahlen[j] > zahlen[j +1]){
                    int temp = zahlen[j +1];
                    zahlen[j+1] = zahlen[j];
                    zahlen[j] = temp;
                }
            }
        }

       return zahlen;
    }

    public void verarbeitung(){
        int temp;
        for(int i = 0; i > array1.length; i++){

        }
    }

}
