package E2.GUI.Wuerfelspiel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WuefelGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setLayout(new GridLayout(5 , 1));

        //Eingabefelder
        JPanel inputfields = new JPanel(new GridLayout(2,2));
        JLabel playerText1 = new JLabel("Player 1");
        JTextField inputField1 = new JTextField();
        inputField1.setSize(200 , 50);
        JLabel playerText2 = new JLabel("Player 2");
        JTextField inputField2 = new JTextField();
        inputField2.setSize(200 , 50);

        inputfields.add(playerText1);
        inputfields.add(inputField1);
        inputfields.add(playerText2);
        inputfields.add(inputField2);

        //Lable
        JLabel randomText1 = new JLabel("Wüefel: " );
        JPanel feedback = new JPanel();
        JLabel randomText2 = new JLabel("");

        //Button
        JButton wuerfeln = new JButton("Würfeln");
        wuerfeln.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int zahl1 = Integer.parseInt(inputField1.getText());
                int zahl2 = Integer.parseInt(inputField2.getText());
                int wuefel = (int)(Math.random() * 20 + 1);
                randomText1.setText("Würfel: " + wuefel);

                if(zahl1 == wuefel && zahl2 == wuefel){
                    randomText2.setText("Beide Richtig geraten");
                    randomText2.setForeground(Color.WHITE);
                    feedback.setBackground(Color.GREEN);
                } else if (zahl1 == wuefel && zahl2 != wuefel) {
                    randomText2.setText("Player 1 Richtig geraten");
                    randomText2.setForeground(Color.WHITE);
                    feedback.setBackground(Color.GREEN);
                    System.out.println("Player 1  Richtig geraten");

                } else if (zahl2 == wuefel && zahl1 != wuefel) {
                    randomText2.setText("Player 2  Richtig geraten");
                    randomText2.setForeground(Color.WHITE);
                    feedback.setBackground(Color.GREEN);
                    System.out.println("Player 2  Richtig geraten");
                } else {
                    randomText2.setText("Beide Falsch geraten");
                    randomText2.setForeground(Color.BLACK);
                    feedback.setBackground(Color.red);
                }
            }
        });


        //Lable hinzufügen
        frame.add(inputfields);

        frame.add(randomText1);
        frame.add(wuerfeln);
        frame.add(feedback);
        feedback.add(randomText2);


        frame.setVisible(true);
    }
}
