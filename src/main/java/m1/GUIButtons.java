package m1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUIButtons implements ActionListener {

    private JButton[] buttons;
    private Key key;
    private int[] solutionArr;

    // use this to match key to GUI class
    public GUIButtons(Key key, JButton[] buttons) {
        this.key = key;
        this.solutionArr = key.solution;
        this.buttons = buttons;
    }

    int temp = -1;
    int prevButton = -1;
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < buttons.length; i++) {
            if (("Button " + i).equals(e.getActionCommand())) {
                buttons[i].setEnabled(false);
                System.out.println(solutionArr[i]);
                if (match(i)) {
                    buttons[i].setBackground(new Color(0x000000));
                    buttons[prevButton].setBackground(new Color(0x000000));
                }
                if (prevButton != -1) {
                    buttons[prevButton].setEnabled(true);
                }

                prevButton = i;
                break;
            }
        }    
    }

    public boolean match(int input) {
            if (temp == -1) {
                temp = solutionArr[input];
                return false;
            }
            else {
                if (temp == solutionArr[input]) {
                    System.out.println("Match");
                    temp = -1;
                    return true;
                }
                else {
                    System.out.println("Not Match");
                    temp = -1;
                    return false;
                }
            }
        }
}