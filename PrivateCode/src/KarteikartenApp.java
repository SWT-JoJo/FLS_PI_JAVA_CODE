import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KarteikartenApp extends JFrame {

    private static final String URL = "jdbc:mysql://localhost:3306/Tanki";
    private static final String USER = "Admim";
    private static final String PASSWORD = "Admin";

    private JTextField setNameFeld, frageFeld, antwortFeld;
    private JTextArea ausgabeFeld;

    public KarteikartenApp() {
        setTitle("Karteikarten App mit MySQL");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel eingabePanel = new JPanel(new GridLayout(5, 2));
        setNameFeld = new JTextField();
        frageFeld = new JTextField();
        antwortFeld = new JTextField();

        eingabePanel.add(new JLabel("Set-Name:"));
        eingabePanel.add(setNameFeld);
        eingabePanel.add(new JLabel("Frage:"));
        eingabePanel.add(frageFeld);
        eingabePanel.add(new JLabel("Antwort:"));
        eingabePanel.add(antwortFeld);

        JButton speichernButton = new JButton("Karte speichern");
        JButton anzeigenButton = new JButton("Sets anzeigen");
        JButton lernenButton = new JButton("Lernen");

        eingabePanel.add(speichernButton);
        eingabePanel.add(anzeigenButton);
        eingabePanel.add(lernenButton);

        add(eingabePanel, BorderLayout.NORTH);

        ausgabeFeld = new JTextArea();
        ausgabeFeld.setEditable(false);
        add(new JScrollPane(ausgabeFeld), BorderLayout.CENTER);

        speichernButton.addActionListener(e -> karteSpeichern());
        anzeigenButton.addActionListener(e -> setsAnzeigen());
        lernenButton.addActionListener(e -> lernen());

        setVisible(true);
    }

    private void karteSpeichern() {
        String setName = setNameFeld.getText().trim();
        String frage = frageFeld.getText().trim();
        String antwort = antwortFeld.getText().trim();

        if (setName.isEmpty() || frage.isEmpty() || antwort.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte alle Felder ausfüllen.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            int setId = findeOderErstelleSet(conn, setName);

            String insertKarte = "INSERT INTO karten (set_id, frage, antwort) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertKarte)) {
                stmt.setInt(1, setId);
                stmt.setString(2, frage);
                stmt.setString(3, antwort);
                stmt.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Karte gespeichert.");
            frageFeld.setText("");
            antwortFeld.setText("");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Fehler beim Speichern.");
        }
    }

    private int findeOderErstelleSet(Connection conn, String setName) throws SQLException {
        String selectSet = "SELECT id FROM sets WHERE name = ?";
        try (PreparedStatement stmt = conn.prepareStatement(selectSet)) {
            stmt.setString(1, setName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }

        String insertSet = "INSERT INTO sets (name) VALUES (?)";
        try (PreparedStatement stmt = conn.prepareStatement(insertSet, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, setName);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }

        throw new SQLException("Set konnte nicht erstellt werden.");
    }

    private void setsAnzeigen() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT s.name, k.frage, k.antwort FROM sets s JOIN karten k ON s.id = k.set_id ORDER BY s.name";
            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                StringBuilder text = new StringBuilder();
                String aktuellesSet = "";

                while (rs.next()) {
                    String setName = rs.getString("name");
                    if (!setName.equals(aktuellesSet)) {
                        text.append("\nSet: ").append(setName).append("\n");
                        aktuellesSet = setName;
                    }
                    text.append("  Frage: ").append(rs.getString("frage"))
                            .append(" | Antwort: ").append(rs.getString("antwort")).append("\n");
                }

                ausgabeFeld.setText(text.toString());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Fehler beim Anzeigen.");
        }
    }

    private void lernen() {
        String setName = setNameFeld.getText().trim();

        if (setName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte gib den Set-Namen ein.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT frage, antwort FROM karten k JOIN sets s ON k.set_id = s.id WHERE s.name = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, setName);
                ResultSet rs = stmt.executeQuery();

                boolean hatKarten = false;
                while (rs.next()) {
                    hatKarten = true;
                    JOptionPane.showMessageDialog(this, "Frage: " + rs.getString("frage"));
                    JOptionPane.showMessageDialog(this, "Antwort: " + rs.getString("antwort"));
                }

                if (!hatKarten) {
                    JOptionPane.showMessageDialog(this, "Keine Karten in diesem Set.");
                } else {
                    JOptionPane.showMessageDialog(this, "Fertig mit dem Set!");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Fehler beim Lernen.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KarteikartenApp::new);
    }
}
