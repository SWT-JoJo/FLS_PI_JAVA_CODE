package Q1.ArrayListen.Praktikum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PraktikumsVerwaltungMitGUI extends JFrame {

    private Praktikum pk;
    private JTextField praktikumNameField;
    private JTextField studentNameField;
    private JTextField studentNoteField;
    private JTextArea outputArea;
    private JButton addStudentButton;
    private JButton finishButton;

    public PraktikumsVerwaltungMitGUI() {
        setTitle("Praktikums-Verwaltung");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Praktikumsname Panel
        JPanel namePanel = new JPanel();
        namePanel.add(new JLabel("Praktikumsname: "));
        praktikumNameField = new JTextField(20);
        namePanel.add(praktikumNameField);
        JButton startButton = new JButton("Start");
        namePanel.add(startButton);
        add(namePanel, BorderLayout.NORTH);

        // Eingabe für Student und Note
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Student Name:"));
        studentNameField = new JTextField();
        inputPanel.add(studentNameField);
        inputPanel.add(new JLabel("Note:"));
        studentNoteField = new JTextField();
        inputPanel.add(studentNoteField);
        addStudentButton = new JButton("Add Student");
        addStudentButton.setEnabled(false);
        inputPanel.add(addStudentButton);
        add(inputPanel, BorderLayout.CENTER);

        // Ausgabe Panel
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Abschluss Panel
        finishButton = new JButton("Finish");
        finishButton.setEnabled(false);
        add(finishButton, BorderLayout.SOUTH);

        // Action Listeners
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String praktikumName = praktikumNameField.getText();
                pk = new Praktikum(praktikumName);
                addStudentButton.setEnabled(true);
                finishButton.setEnabled(true);
                outputArea.setText("Praktikum '" + praktikumName + "' gestartet.\n");
            }
        });

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = studentNameField.getText();
                double note;
                try {
                    note = Double.parseDouble(studentNoteField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ungültige Note. Bitte geben Sie eine Zahl ein.");
                    return;
                }
                pk.AddStudent(name, note);
                outputArea.append("Student hinzugefügt: " + name + " mit Note: " + note + "\n");
                studentNameField.setText("");
                studentNoteField.setText("");
            }
        });

        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Praktikumsübersicht anzeigen
                StringBuilder overview = new StringBuilder();
                overview.append("-----| Praktikums-Übersicht |-----\n");
                overview.append("Praktikumsname: " + pk.getName() + "\n");
                overview.append("Teilnehmeranzahl: " + pk.getStudenten().size() + "\n");
                overview.append("Durchschnittsnote: " + pk.outputDurchschniitsNote() + "\n\n");
                overview.append("Liste der Teilnehmer:\n");
                overview.append(pk.outputStudenten());

                // Zeige die Übersicht in einem Popup
                JOptionPane.showMessageDialog(null, overview.toString(), "Praktikums-Übersicht", JOptionPane.INFORMATION_MESSAGE);

                // Füge auch die Ausgabe in das Textfeld hinzu
                outputArea.append("\n" + overview);

                // Deaktiviere die Buttons
                addStudentButton.setEnabled(false);
                finishButton.setEnabled(false);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PraktikumsVerwaltungMitGUI gui = new PraktikumsVerwaltungMitGUI();
            gui.setVisible(true);
        });
    }
}
