package Q3.Socket.ChatServerWithOneClient.GUIBYAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//THIS GUI IS POWERD BY CHATGPT
public class ChatServerGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    private int port = 8080;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatServerGUI::new);
    }

    public ChatServerGUI() {
        setTitle("Chat Server");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        inputField.setEnabled(false);
        sendButton = new JButton("Senden");
        sendButton.setEnabled(false);

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(this::sendMessage);
        inputField.addActionListener(this::sendMessage);

        setVisible(true);

        startServer();
    }

    private void startServer() {
        appendText("System: Server gestartet. Warte auf Verbindung...");

        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                clientSocket = serverSocket.accept();

                appendText("System: Client verbunden!\n");

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Eingabe aktivieren
                SwingUtilities.invokeLater(() -> {
                    inputField.setEnabled(true);
                    sendButton.setEnabled(true);
                });

                String message;
                while ((message = in.readLine()) != null) {
                    appendText("Client: " + message);

                    if (message.contains("over")) {
                        appendText("System: Client beendet die Verbindung.");
                        closeConnection();
                        break;
                    }
                }

            } catch (IOException e) {
                appendText("System: Fehler beim Starten oder Verbinden des Servers.");
            }
        }).start();
    }

    private void sendMessage(ActionEvent e) {
        String message = inputField.getText().trim();
        if (message.isEmpty() || out == null) return;

        out.println(message);
        appendText("Du: " + message);
        inputField.setText("");

        if (message.contains("over")) {
            appendText("System: Verbindung wird beendet...");
            closeConnection();
        }
    }

    private void appendText(String text) {
        SwingUtilities.invokeLater(() -> {
            chatArea.append(text + "\n");
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        });
    }

    private void closeConnection() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (clientSocket != null) clientSocket.close();
            if (serverSocket != null) serverSocket.close();

            SwingUtilities.invokeLater(() -> {
                inputField.setEnabled(false);
                sendButton.setEnabled(false);
            });

            appendText("System: Server beendet.");

        } catch (IOException e) {
            appendText("System: Fehler beim Schließen der Verbindung.");
        }
    }
}
