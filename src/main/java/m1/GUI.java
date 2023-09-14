package m1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

public class GUI extends JFrame {

    GUI() {

        
        Key key = new Key();

        GUIButtons buttons = new GUIButtons(key);

        // create window
        this.setTitle("Memory Tester 👍");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when press x
        this.setResizable(false);
        this.setSize(800, 800);
        this.setVisible(true);

        // set window icon
        ImageIcon icon = new ImageIcon("MemoryIcon.png");
        this.setIconImage(icon.getImage());

        // set background color
        this.getContentPane().setBackground(new Color(0x26172e));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        // make the buttons
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("Button " + i);
            button.setForeground(new Color(0x26172e));
            button.setBackground(new Color(0x26172e));
            button.addActionListener(buttons);
            //set name of button action
            button.setActionCommand("Button " + i);
            button.setText("");
            buttonPanel.add(button);

        }

        this.add(buttonPanel);

    }

}