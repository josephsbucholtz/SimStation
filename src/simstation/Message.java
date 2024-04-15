package simstation;

import javax.swing.*;

public class Message {
    public static void displayStats(String [] messages){
        JFrame frame = new JFrame();
        StringBuilder text = new StringBuilder();
        for (String message : messages) {
            text.append(message).append("\n");
        }
        JOptionPane.showMessageDialog(frame, text);
    }
}
