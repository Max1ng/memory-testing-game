package m1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame{
    
    GUI() {

        //Create the window
        this.setTitle("Memory Tester 👍");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when press x
        this.setResizable(false);
        this.setSize(800, 800);
        this.setVisible(true);
        
        //Set icon of the window
        ImageIcon icon = new ImageIcon("MemoryIcon.png");
        this.setIconImage(icon.getImage());

        //Background color 
        this.getContentPane().setBackground(new Color(0x26172e)); 

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        GUIButtons buttons = new GUIButtons();

        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("Button " + (i + 1));
            button.setForeground(new Color(0x000000));
            button.addActionListener(buttons);
            buttonPanel.add(button);
        }

        this.add(buttonPanel);

    }

    
}