package Q1.BinaereSuche;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharSearchGUI {

    private JFrame frame;
    private JTextField searchField;
    private JTextArea outputArea;
    private JButton searchButton;
    private JButton toggleButton; // Button to switch between dark and light mode
    private String[] haustiere = {"Hund", "Katze", "Vogel", "Hamster", "Kaninchen", "Meerschweinchen", "Papagei"};
    private char[] buchstaben = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private int durchlauf;
    private boolean ersteSuche = true;
    private JPanel searchPanel;
    private JPanel outputPanel;
    private JPanel contentPanel;  // Container panel to hold both search and output panels
    private boolean isDarkMode = true; // Track the current mode

    public CharSearchGUI() {
        frame = new JFrame("Binäre Suche");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);  // Center the window

        // Create the content panel
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Create the search panel
        searchPanel = new JPanel();
        searchPanel.setBackground(Color.DARK_GRAY);
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Align to left

        // Create the toggle button for dark/light mode
        toggleButton = new JButton("Toggle Light/Dark Mode");
        toggleButton.setFocusable(false);
        toggleButton.setBackground(new Color(100, 100, 100));
        toggleButton.setForeground(Color.WHITE);
        toggleButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        toggleButton.setFocusPainted(false); // Remove focus border
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleTheme();
            }
        });

        // Create the search field
        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 24));
        searchField.setPreferredSize(new Dimension(350, 50));  // Fixed height
        searchField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        searchField.setMargin(new Insets(10, 10, 10, 10)); // Add padding inside the text field

        // Create a search button with an icon
        searchButton = new JButton(new ImageIcon("path_to_your_search_icon.png")); // Replace with your icon path
        searchButton.setFocusable(false);
        searchButton.setPreferredSize(new Dimension(50, 50));  // Fixed size button
        searchButton.setBackground(new Color(66, 133, 244)); // Google blue color
        searchButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        searchButton.setFocusPainted(false); // Remove focus border

        // Add the search field and button to the search panel
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(toggleButton); // Add toggle button next to the search bar

        // Output area for search results
        outputPanel = new JPanel();
        outputPanel.setBackground(Color.DARK_GRAY);
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setVisible(false); // Initially hidden

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));
        outputArea.setText("----| Starten Sie eine Suche |----\n");
        outputArea.setBackground(Color.DARK_GRAY);
        outputArea.setForeground(Color.WHITE);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        // Add both panels to the content panel
        contentPanel.add(searchPanel);
        contentPanel.add(outputPanel);

        frame.add(contentPanel, BorderLayout.CENTER);

        // Set initial theme
        updateTheme();

        // Action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchField.getText();
                outputArea.setText(""); // Clear the output area
                durchlauf = 0;  // Reset the count of iterations

                if (ersteSuche) {
                    // After the first search, we can keep both panels visible
                    firstSearchDone();
                }

                // Execute search
                if (searchQuery.length() == 1) {
                    buchstabensuche(searchQuery.charAt(0));
                } else {
                    wortSuche(searchQuery);
                }
            }
        });

        frame.setVisible(true);
    }

    private void firstSearchDone() {
        // Move the search panel to the top and show the output panel
        outputPanel.setVisible(true); // Show output panel
        searchPanel.setPreferredSize(new Dimension(frame.getWidth(), 70));  // Adjust height
        searchPanel.revalidate();
        searchPanel.repaint();

        ersteSuche = false;  // Mark that the first search has been completed
    }

    private void toggleTheme() {
        isDarkMode = !isDarkMode; // Toggle the mode
        updateTheme(); // Update the theme
    }

    private void updateTheme() {
        if (isDarkMode) {
            // Dark mode colors
            searchPanel.setBackground(Color.DARK_GRAY);
            outputPanel.setBackground(Color.DARK_GRAY);
            outputArea.setBackground(Color.DARK_GRAY);
            outputArea.setForeground(Color.WHITE);
            searchField.setBackground(new Color(60, 60, 60));
            searchField.setForeground(Color.WHITE);
            searchButton.setBackground(new Color(66, 133, 244)); // Google blue color
            searchButton.setForeground(Color.WHITE);
            toggleButton.setBackground(new Color(100, 100, 100));
            toggleButton.setForeground(Color.WHITE);
        } else {
            // Light mode colors
            searchPanel.setBackground(Color.LIGHT_GRAY);
            outputPanel.setBackground(Color.LIGHT_GRAY);
            outputArea.setBackground(Color.LIGHT_GRAY);
            outputArea.setForeground(Color.BLACK);
            searchField.setBackground(Color.WHITE);
            searchField.setForeground(Color.BLACK);
            searchButton.setBackground(Color.BLUE);
            searchButton.setForeground(Color.WHITE);
            toggleButton.setBackground(Color.LIGHT_GRAY);
            toggleButton.setForeground(Color.BLACK);
        }

        // Repaint the components to apply the new colors
        searchPanel.repaint();
        outputPanel.repaint();
        outputArea.repaint();
        searchField.repaint();
        searchButton.repaint();
        toggleButton.repaint();
    }

    private void buchstabensuche(char buchstabe) {
        StringBuilder protocol = new StringBuilder();
        boolean found = false;
        int foundIndex = -1;
        int min = 0;
        int max = buchstaben.length - 1;
        int mid;

        do {
            durchlauf++;
            mid = (max + min) / 2;
            protocol.append(durchlauf)
                    .append(". Erste Position: ")
                    .append(min)
                    .append(" Letzte Position: ")
                    .append(max)
                    .append(" ---> Mitte: ")
                    .append(mid)
                    .append("\n");

            if (buchstaben[mid] == buchstabe) {
                foundIndex = mid;
                found = true;
            } else if (buchstaben[mid] < buchstabe) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        } while (!found && min <= max);

        // Display protocol and result
        outputArea.append("----| Protokol-Suche |----\n");
        outputArea.append(protocol.toString());
        outputArea.append("\n----| Suchergebnis |----\n");
        outputArea.append("Der Buchstabe befindet sich an Position " + (foundIndex + 1) + " (Index: " + foundIndex + ") im Array\n");
        outputArea.append("Durchläufe: " + durchlauf + "\n");
    }

    private void wortSuche(String haustier) {
        StringBuilder protocol = new StringBuilder();
        boolean found = false;
        int foundIndex = -1;
        int min = 0;
        int max = haustiere.length -  1;
        int mid;

        do {
            durchlauf++;
            mid = (max + min) / 2;
            protocol.append(durchlauf)
                    .append(". Erste Position: ")
                    .append(min)
                    .append(" Letzte Position: ")
                    .append(max)
                    .append(" ---> Mitte: ")
                    .append(mid)
                    .append("\n");

            if (haustier.compareTo(haustiere[mid]) == 0) {
                foundIndex = mid;
                found = true;
            } else if (haustier.compareTo(haustiere[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        } while (!found && min <= max);

        // Display protocol and result
        outputArea.append("----| Protokol-Suche |----\n");
        outputArea.append(protocol.toString());
        outputArea.append("\n----| Suchergebnis |----\n");
        outputArea.append("Das Haustier befindet sich an Position " + (foundIndex + 1) + " (Index: " + foundIndex + ") im Array\n");
        outputArea.append("Durchläufe: " + durchlauf + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CharSearchGUI();
            }
        });
    }
}