package m1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Font;

public class GUI extends JFrame {

    GUI() {

        JButton[] buttonArray = new JButton[16];
        
        Key key = new Key();

        

        // create window
        this.setTitle("Memory Tester 👍");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when press x
        this.setResizable(false);
        this.setSize(700, 800);
        this.setVisible(true);

        // set window icon
        ImageIcon icon = new ImageIcon("MemoryIcon.png");
        this.setIconImage(icon.getImage());

        // set background color
        this.getContentPane().setBackground(new Color(0x26172e));

        // make the button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        buttonPanel.setPreferredSize(new Dimension(700, 700));

        JTextArea textArea = new JTextArea("Hello! Thanks for playing!\nRules: Click lol");
        textArea.setPreferredSize(new Dimension(700, 100));
        textArea.setBackground(new Color(0x26172e));
        textArea.setForeground(new Color(0xFFFFFF));

        Font font = new Font("Arial", Font.PLAIN, 16); // Change the font and size as needed
        textArea.setFont(font);

        centerAlignTextHorizontally(textArea);

        textArea.setEditable(false);
        textArea.setFocusable(false);
        
        // make the buttons
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("Button " + i);
            button.setForeground(new Color(0x26172e));
            button.setBackground(new Color(0x26172e));
            //set name of button action
            button.setActionCommand("Button " + i);
            button.setText("");
            
            buttonPanel.add(button);
            buttonArray[i] = button;
        }

        GUIButtons buttons = new GUIButtons(key, buttonArray);

        for (int i = 0; i < 16; i++) {
            buttonArray[i].addActionListener(buttons);
        }
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(textArea, BorderLayout.NORTH);
        this.pack();

    }

    private void centerAlignTextHorizontally(JTextArea textArea) {
        DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        textArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
    }

}