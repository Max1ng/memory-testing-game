package m1;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Random;

public class GUI extends JFrame {

    GUI() {

        // Create the window
        this.setTitle("Memory Tester 👍");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when press x
        this.setResizable(false);
        this.setSize(800, 800);
        this.setVisible(true);

        // Set icon of the window
        ImageIcon icon = new ImageIcon("MemoryIcon.png");
        this.setIconImage(icon.getImage());

        // Background color
        this.getContentPane().setBackground(new Color(0x26172e));

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        GUIButtons buttons = new GUIButtons();

        int[] buttonNum = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        int[] key = new int[16];

        HashSet<Integer> numList = new HashSet<Integer>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        numList.add(6);
        numList.add(7);
        numList.add(8);
        numList.add(9);
        numList.add(10);
        numList.add(11);
        numList.add(12);
        numList.add(13);
        numList.add(14);
        numList.add(15);
        numList.add(16);
        

        for (int i = 0; i < 16; i++) {
            JButton button = new JButton("Button " + (i + 1));
            button.setForeground(new Color(0x26172e));
            button.setBackground(new Color(0x26172e));
            button.addActionListener(buttons);
            button.setText("");
            buttonPanel.add(button);
            
            

        }

        System.out.println(numList);

        int index = 0;
        Random rand = new Random();
        int randNum;
        //run while hashset has numbers in it
        while (!numList.isEmpty() && index < 16) {

            randNum = rand.nextInt(16) + 1;
            //System.out.println(randNum);
            //if number is in hashset still set key[i] = to that value
            
            if (numList.contains(randNum)) {
                key[index] = randNum;
                index++;
                //remove that number from hashset
                numList.remove(randNum);
            }
            /* else {
                index++;
            } */
        }

        /* for (int x : key) {
            System.out.print(key[x]);
        } */
        this.add(buttonPanel);

    }

}