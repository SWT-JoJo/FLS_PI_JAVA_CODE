package Q3.Socket.ChatServerWithOneClient.GUIBYAI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

//THIS GUI IS POWERD BY CHATGPT
public class ChatClientGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private String host = "localhost";
    private int port = 8080;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatClientGUI::new);
    }

    public ChatClientGUI() {
        setTitle("Chat Client");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();
        sendButton = new JButton("Senden");

        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        setVisible(true);

        connectToServer();
    }

    private void connectToServer() {
        appendText("System: Verbinde mit " + host + ":" + port + " ...");

        new Thread(() -> {
            try {
                socket = new Socket(host, port);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                appendText("System: Verbindung hergestellt!\n");

                String message;
                while ((message = in.readLine()) != null) {
                    appendText("Server: " + message);
                    if (message.contains("over")) {
                        appendText("System: Server beendet die Verbindung.");
                        closeConnection();
                        break;
                    }
                }

            } catch (IOException e) {
                appendText("System: Verbindung konnte nicht hergestellt werden.");
            }
        }).start();
    }

    private void sendMessage() {
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
            if (socket != null) socket.close();
            sendButton.setEnabled(false);
            inputField.setEditable(false);
        } catch (IOException e) {
            appendText("System: Fehler beim Schließen der Verbindung.");
        }
    }
}
