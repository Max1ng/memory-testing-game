package m1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

        // make top text field
        JTextField textField = new JTextField("Heya! Thanks for playing!");
        textField.setPreferredSize(new Dimension(700, 50));
        textField.setBackground(new Color(0x26172e));
        textField.setForeground(new Color(0xFFFFFF));
        Font font = new Font("Arial", Font.PLAIN, 24);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setFocusable(false);

        // make bottom text field to display what was clicked
        JTextField textField2 = new JTextField("Number behind square: ");
        textField2.setPreferredSize(new Dimension(700, 50));
        textField2.setBackground(new Color(0x26172e));
        textField2.setForeground(new Color(0xFFFFFF));
        textField2.setFont(font);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setEditable(false);
        textField2.setFocusable(false);

        // make the buttons
        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("Button " + i);
            button.setForeground(new Color(0x26172e));
            button.setBackground(new Color(0x26172e));
            // set name of button action
            button.setActionCommand("Button " + i);
            button.setText("");

            buttonPanel.add(button);
            buttonArray[i] = button;
        }

        GUIButtons buttons = new GUIButtons(key, buttonArray, textField2);

        for (int i = 0; i < 16; i++) {
            buttonArray[i].addActionListener(buttons);
        }
        this.add(textField2, BorderLayout.SOUTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(textField, BorderLayout.NORTH);
        this.pack();

    }

}