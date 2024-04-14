package Methoden;

import java.util.Scanner;

public class TicTacToe {
    int player1Score;
    int player2Score;
    int drawCounter;
    int roundsplayed;
    int currentPlayersTurn = 1;
    boolean playing = true;
    int turns = 0;
    char[][] board = new char[3][3];
    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        ttt.resetBoard();
        ttt.menu();
    }
    public void menu(){


        Scanner scan = new Scanner(System.in);

        System.out.println("Wilkommen");
        System.out.print("Namen für Spieler 1 eingeben: ");
        String playerOneName = scan.next();
        System.out.print("Namen für Spieler 2 eingeben: ");
        String playerTwoName = scan.next();

        System.out.println("Das Spiel kann nun beginnen \n");

        while (playing){
            printBoard();
            turn(playerOneName, playerTwoName);
            checkWinCondition(playerOneName, playerTwoName);
        }

        System.out.println("Aktueller Punktestand");
        System.out.println(playerOneName +":\t" + player1Score);
        System.out.println(playerTwoName +":\t" + player1Score);
        System.out.println("Draws:\t" + player1Score);
    }

    public  void printBoard(){
        int zeile = 1;
        System.out.println("Das aktuelle Spielfeld:");
        System.out.println("\t1\t2\t3");
        for(int i = 0; i < board.length; i++){
            System.out.print(zeile);
            for (int j = 0; j < board[i].length; j++){
                System.out.print("\t" + board[i][j]);
            }
            zeile ++;
            System.out.println();
        }
    }

    public void resetBoard(){
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = '0';
            }
        }
    }

    public void turn(String playername1 , String playername2){
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int y = 0;

        char playerSymbol = '0';
        if (currentPlayersTurn == 1) {
            System.out.print(playername1);
            currentPlayersTurn = 2;
            playerSymbol = 'A';
        }
        else if (currentPlayersTurn == 2){
            System.out.print(playername2);
            currentPlayersTurn = 1;
            playerSymbol = 'B';
        }
        System.out.println(" bitte coordinaten eingeben: ");

        do {
            if(board[y][x] == 'A' ||board[y][x] == 'B'   && x < 0 || x > 2 &&  y < 0 ||  y > 2 ){
                System.out.println("ERROR: INVALID INPUT TRY AGAIN!\n");
            }
            System.out.print("Zeile (Y): ");
            y = scan.nextInt() -1;
            System.out.print("Spalte (X): ");
            x = scan.nextInt() -1;
        }while (board[y][x] == 'A' ||board[y][x] == 'B'   && x < 0 || x > 2 &&  y < 0 ||  y > 2 ) ;

        board[y][x] = playerSymbol;
        turns ++;
    }

    void checkWinCondition(String player1Name,String player2Name){
        if(turns >= 3){
            if(board[0][0] == board[0][1] && board[0][0] == board[0][2] || board[1][0] == board[1][1] && board[1][0] == board[1][2] ||board[2][0] == board[2][1] && board[2][0] == board[2][2] ||
                board[0][0] == board[1][0] && board[0][0] == board[2][0] ||board[0][1] == board[1][1] && board[0][1] == board[2][1] || board[0][2] == board[1][2] && board[0][2] == board[2][2] ||
                board[0][0] == board[1][1] && board[0][0] == board[2][2] || board[0][2] == board[1][1] && board[0][2] == board[0][2]) {

            playing = false;

            if (currentPlayersTurn == 1) {
                System.out.println(player2Name + " hat die Runde gewonnen");
                player2Score++;
            } else {
                System.out.println(player1Name + " hat die Runde gewonnen");
                player1Score++;
            }
            turns = 0;
            }
        }
    }


}
