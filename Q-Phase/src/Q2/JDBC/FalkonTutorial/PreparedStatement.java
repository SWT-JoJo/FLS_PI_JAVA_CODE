package Q2.JDBC.FalkonTutorial;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PreparedStatement {

    Connection con;

    public static void main(String[] args) throws SQLException {
        PreparedStatement prs = new PreparedStatement();
        Scanner scan = new Scanner(System.in);

        try {
            prs.startConnection();
        } catch (SQLException e) {
            System.out.println("Keine Verbindung möglich");
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("Feherhafter Input, das Programm wird beendet");
        }

        System.out.println("\n\n");

        System.out.println("Es werden nun einige Automatisierte Befehle ausgeführt");
        prs.runSQLStatements();
    }

    public void runSQLStatements(){

    }


    public void startConnection() throws SQLException, InputMismatchException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Willkommen im Anmelde Fenster, bitte geben sie ihre Anmeldedaten ein");
        System.out.print("Username: ");
        String user = scan.next();
        System.out.print("Passwort: ");
        String pw = scan.next();
        //String url = "jdbc:mysql://localhost:3307/" + db + "?user=" + user + "&password=" + pw;
        String url = "jdbc:mysql://localhost:3307/";
        con = DriverManager.getConnection(url, user, pw);
        System.out.println("Verbindung erfolgreich hergestellt\n");
    }
}
