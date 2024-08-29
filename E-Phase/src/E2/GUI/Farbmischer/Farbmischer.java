package E2.GUI.Farbmischer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.*;

public class Farbmischer {

    static public int redcode = 0;
    static public int greencode = 0;
    static public int bluecode = 0;
    static Color ccolor = new Color(0,0,0);

    public static void main(String[] args) {
        GUI();
    }

    public static void GUI(){
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 1));
        frame.setSize(500 , 800);
        JPanel color = new JPanel(new BorderLayout());

        JLabel hexText = new JLabel(String.format("#%02X%02X%02X", redcode, greencode, bluecode), SwingConstants.CENTER);
        hexText.setFont(new Font("Arial", Font.BOLD, 16));
        hexText.setForeground(Color.BLACK);
        color.add(hexText, BorderLayout.CENTER);

        JPanel mixer = new JPanel(new BorderLayout());

        JPanel textPannel = new JPanel(new GridLayout(3, 1 ));
        JPanel scrollbarPannel  = new JPanel(new GridLayout(3, 1 ));
        JPanel intwertePannel  = new JPanel(new GridLayout(3, 1 ));

        Label redText = new Label("Rot");
        Label greenText = new Label("Grün");
        Label blueText = new Label("Blau");


        Label redIntText = new Label(String.valueOf(redcode));
        Label greenIntText = new Label(String.valueOf(greencode));
        Label blueIntText = new Label(String.valueOf(bluecode));

        JScrollBar red = new JScrollBar();
        red.setOrientation(Adjustable.HORIZONTAL);
        red.setMinimum(0);
        red.setMaximum(265);
        int IDK = 200;
        red.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                redcode = red.getValue();
                redIntText.setText(String.valueOf(redcode));
                ccolor = new Color(redcode, greencode, bluecode);
                color.setBackground(ccolor);
                hexText.setText(String.format("#%02X%02X%02X", redcode, greencode, bluecode));
                if(redcode >= IDK || greencode >= IDK || bluecode >= IDK){
                    hexText.setForeground(Color.black);
                }
                else {
                    hexText.setForeground(Color.WHITE);
                }
            }
        });

        JScrollBar green = new JScrollBar();
        green.setOrientation(Adjustable.HORIZONTAL);
        green.setMinimum(0);
        green.setMaximum(265);
        green.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                greencode = green.getValue();
                greenIntText.setText(String.valueOf(greencode));
                ccolor = new Color(redcode, greencode, bluecode);
                color.setBackground(ccolor);
                hexText.setText(String.format("#%02X%02X%02X", redcode, greencode, bluecode));
                if(redcode >= IDK || greencode >= IDK || bluecode >= IDK){
                    hexText.setForeground(Color.black);
                }
                else {
                    hexText.setForeground(Color.WHITE);
                }
            }
        });
        JScrollBar blue = new JScrollBar();
        blue.setOrientation(Adjustable.HORIZONTAL);
        blue.setMinimum(0);
        blue.setMaximum(265);
        blue.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                bluecode = blue.getValue();
                blueIntText.setText(String.valueOf(bluecode));
                ccolor = new Color(redcode, greencode, bluecode);
                color.setBackground(ccolor);
                hexText.setText(String.format("#%02X%02X%02X", redcode, greencode, bluecode));
                if(redcode >= IDK || greencode >= IDK || bluecode >= IDK){
                    hexText.setForeground(Color.black);
                }
                else {
                    hexText.setForeground(Color.WHITE);
                }
            }
        });






        textPannel.add(redText);
        scrollbarPannel.add(red);
        intwertePannel.add(redIntText);

        textPannel.add(greenText);
        scrollbarPannel.add(green);
        intwertePannel.add(greenIntText);

        textPannel.add(blueText);
        scrollbarPannel.add(blue);
        intwertePannel.add(blueIntText);

        mixer.add(textPannel , BorderLayout.WEST);
        mixer.add(scrollbarPannel, BorderLayout.CENTER);
        mixer.add(intwertePannel, BorderLayout.EAST);

        JButton randomColor = new JButton("Random Color");
        randomColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {randomColorr();
                ccolor = new Color(redcode, greencode, bluecode);
                color.setBackground(ccolor);

                redIntText.setText(String.valueOf(redcode));
                greenIntText.setText(String.valueOf(greencode));
                blueIntText.setText(String.valueOf(bluecode));

                red.setValue(redcode);
                green.setValue(greencode);
                blue.setValue(bluecode);

                hexText.setText(String.format("#%02X%02X%02X", redcode, greencode, bluecode));
                if(redcode >= 150 || greencode >= 150 || bluecode >= 150 ){
                    hexText.setForeground(Color.black);
                }
                else {
                    hexText.setForeground(Color.WHITE);
                }
            }
        });



        frame.add(color);
        frame.add(mixer);
        frame.add(randomColor);

        frame.setVisible(true);
    }

    public static void randomColorr(){
        redcode = (int) (Math.random() * 255);
        greencode = (int) (Math.random() * 255);
        bluecode = (int) (Math.random() * 255);
    }




}
