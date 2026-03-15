package task_4;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class KeyLogger {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Basic Key Logger");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea area = new JTextArea();
        frame.add(area);

        try {
            FileWriter writer = new FileWriter("keystrokes.txt", true);

            area.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    try {
                        String key = KeyEvent.getKeyText(e.getKeyCode());
                        writer.write("Key Pressed: " + key + "\n");
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
}