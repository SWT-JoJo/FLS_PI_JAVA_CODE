package Q2.JDBC.FalkonTutorial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class JDBCGUI extends JFrame {

    private Connection con;
    private JComboBox<String> dbSelector;
    private JTextArea sqlInput;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton connectBtn, executeBtn;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JDBCGUI().setVisible(true));
    }

    public JDBCGUI() {
        setTitle("JDBC SQL GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initLoginView();
    }

    private void initLoginView() {
        JPanel loginPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        usernameField = new JTextField("Jonah");
        passwordField = new JPasswordField();

        connectBtn = new JButton("Verbinden");
        connectBtn.addActionListener(e -> connectToServer());

        loginPanel.add(new JLabel("Benutzername:"));
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Passwort:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(connectBtn);

        getContentPane().add(loginPanel);
    }

    private void connectToServer() {
        try {
            String url = "jdbc:mysql://localhost:3307/";
            String user = usernameField.getText();
            String pw = new String(passwordField.getPassword());

            con = DriverManager.getConnection(url, user, pw);

            // Lade Datenbanken
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SHOW DATABASES");

            dbSelector = new JComboBox<>();
            while (rs.next()) {
                dbSelector.addItem(rs.getString(1));
            }

            JOptionPane.showMessageDialog(this, "Verbindung erfolgreich!");

            initMainView();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Verbindung fehlgeschlagen:\n" + e.getMessage());
        }
    }

    private void initMainView() {
        getContentPane().removeAll();
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JLabel("Datenbank wählen:"), BorderLayout.WEST);
        topPanel.add(dbSelector, BorderLayout.CENTER);

        dbSelector.addActionListener(e -> switchDatabase((String) dbSelector.getSelectedItem()));

        add(topPanel, BorderLayout.NORTH);

        sqlInput = new JTextArea(5, 40);
        executeBtn = new JButton("SQL ausführen");
        executeBtn.addActionListener(e -> executeSQL());

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(new JScrollPane(sqlInput), BorderLayout.CENTER);
        centerPanel.add(executeBtn, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel();
        resultTable = new JTable(tableModel);
        add(new JScrollPane(resultTable), BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    private void switchDatabase(String dbName) {
        try {
            Statement stm = con.createStatement();
            stm.execute("USE " + dbName);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Fehler beim Wechseln der Datenbank:\n" + e.getMessage());
        }
    }

    private void executeSQL() {
        String sql = sqlInput.getText().trim();
        if (sql.isEmpty()) return;

        try (Statement stm = con.createStatement()) {

            if (sql.toLowerCase().startsWith("select") || sql.toLowerCase().startsWith("show")) {
                ResultSet rs = stm.executeQuery(sql);
                ResultSetMetaData meta = rs.getMetaData();

                Vector<String> columnNames = new Vector<>();
                for (int i = 1; i <= meta.getColumnCount(); i++) {
                    columnNames.add(meta.getColumnName(i));
                }

                Vector<Vector<String>> data = new Vector<>();
                while (rs.next()) {
                    Vector<String> row = new Vector<>();
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                        row.add(rs.getString(i));
                    }
                    data.add(row);
                }

                tableModel.setDataVector(data, columnNames);

            } else {
                int result = stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Befehl erfolgreich ausgeführt, " + result + " Zeilen betroffen.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "SQL-Fehler:\n" + e.getMessage());
        }
    }
}
