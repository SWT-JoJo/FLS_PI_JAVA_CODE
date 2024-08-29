package E2.GUI.FirstApp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EasyButton {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        JLabel text = new JLabel("Klick mich");
        frame.add(text, BorderLayout.NORTH);

        JButton button = new JButton("KlickMich");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("Der Button wurde geklickt");
            }
        });
        frame.add(button, BorderLayout.SOUTH);



        frame.setSize(100 , 200);
        frame.setVisible(true);
    }
}
