package Q2.JDBC.FalkonTutorial;

// Wichtige Imports :)
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JDBCTutorial {
    //String url = "jdbc:mysql://localhost:3307/db_biohalle?user=Jonah&password=Xc77!Jo?SQL";
    String neueURL = "jdbc:mysql://localhost:3307/?user=Jonah";
//Aufbau der URL jdbc:mysql://ip:port/datenbank?user=username&passwort=passwort

    Connection con;


    public static void main(String[] args) {
        JDBCTutorial jdbcTutorial = new JDBCTutorial();
        Scanner scan = new Scanner(System.in);

        try {
            jdbcTutorial.startConnection();
        } catch (SQLException e) {
            System.out.println("Keine Verbindung möglich");
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("Feherhafter Input, das Programm wird beendet");
        }

        System.out.println("\n\n");

        while (true) {
            System.out.println("Tabellen in der Datenbank: ");
            try {
                jdbcTutorial.runSQLStatements("SHOW tables");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Geben sie einen SQL befehl ein: ");
            String SQLbefehl = scan.nextLine();

            try {
                jdbcTutorial.runSQLStatements(SQLbefehl);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
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

        System.out.println("Datenbanken: ");

        Statement stm = con.createStatement();

        ResultSet databases = stm.executeQuery("SHOW DATABASES");
        while (databases.next()){
            System.out.println(databases.getString(1));
        }
        System.out.print("Geben sie nun den namen der Datenbank ein, um sich mit ihr zu verbinden: ");
        String db = scan.next();
        stm.execute("use " + db);
    }

    public void runSQLStatements(String statement) throws SQLException {
        Statement stm = con.createStatement();

        if (statement.contains("SELECT") || statement.contains("SHOW") || statement.contains("select") || statement.contains("show")) {
            ResultSet rs = stm.executeQuery(statement);

            // DIESE AUSGABE STAMMT VOM KOLLEGEN CHATGPT :) 
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Spaltenbreiten berechnen
            int[] columnWidths = new int[columnCount];

            // Initial mit Länge der Spaltennamen befüllen
            for (int i = 0; i < columnCount; i++) {
                columnWidths[i] = metaData.getColumnName(i + 1).length();
            }

            // Alle Zeilen vorab lesen und maximale Breite je Spalte bestimmen
            List<String[]> rows = new ArrayList<>();
            while (rs.next()) {
                String[] row = new String[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    String value = rs.getString(i + 1);
                    row[i] = (value != null) ? value : "NULL";
                    if (row[i].length() > columnWidths[i]) {
                        columnWidths[i] = row[i].length();
                    }
                }
                rows.add(row);
            }

            // Titelzeile ausgeben
            for (int i = 0; i < columnCount; i++) {
                System.out.printf("%-" + (columnWidths[i] + 2) + "s", metaData.getColumnName(i + 1));
            }
            System.out.println();

            // Trennlinie (optional, sieht sauberer aus)
            for (int i = 0; i < columnCount; i++) {
                System.out.print("-".repeat(columnWidths[i]) + "  ");
            }
            System.out.println();

            // Datenzeilen ausgeben
            for (String[] row : rows) {
                for (int i = 0; i < columnCount; i++) {
                    System.out.printf("%-" + (columnWidths[i] + 2) + "s", row[i]);
                }
                System.out.println();
            }
        } else {
            try {
                stm.executeUpdate(statement);
                System.out.println("Befehl erfolgreich ausgeführt");
            } catch (SQLException e) {
                System.out.println("Fehler bei der Ausführung");
                throw new RuntimeException(e);
            } catch (RuntimeException e){
                System.out.println("Feher beim Ausführen aufgetreteten");
            }
        }

        System.out.println("");
    }
}

