package m1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class GUIButtons implements ActionListener {

    private JButton[] buttons;
    private Key key;
    private int[] solutionArr;
    private JTextField textField2;

    private boolean win = false;

    public boolean won() {
        return win;
    }

    // use this to match key to GUI class
    public GUIButtons(Key key, JButton[] buttons, JTextField textField2) {
        this.key = key;
        this.solutionArr = key.solution;
        this.buttons = buttons;
        this.textField2 = textField2;
    }

    // used to store previous button click number
    int temp = -1;
    // last button pressed
    int prevButton = -1;

    public void actionPerformed(ActionEvent e) {

        // loop through all the buttons to see which was pressed
        for (int i = 0; i < buttons.length; i++) {
            if (("Button " + i).equals(e.getActionCommand())) {
                // disable clicked button so can't be clicked again and matched
                buttons[i].setEnabled(false);
                System.out.println(solutionArr[i]);
                // output number
                textField2.setText("Number: " + solutionArr[i]);

                // true or false if match
                boolean matched = match(i);

                // if match, change color to green and disable clicks
                if (matched) {
                    buttons[i].setBackground(new Color(0x51b56c));
                    buttons[prevButton].setBackground(new Color(0x51b56c));
                    buttons[i].setEnabled(false);
                    buttons[prevButton].setEnabled(false);
                }
                // renable previous button if not match
                if (prevButton != -1 && !matched) {
                    buttons[prevButton].setEnabled(true);
                }

                prevButton = i;
                break;
            }
        }
    }

    // variable to check if game is won
    int done = 0;

    // class to check if two squares are a match
    public boolean match(int input) {
        if (temp == -1) {
            temp = solutionArr[input];
            return false;
        } else {
            if (temp == solutionArr[input]) {
                System.out.println("Match");
                temp = -1;
                done++;

                // if all pairs are matched win!
                if (done >= 8) {
                    textField2.setText("WINNER WINNER CHICKEN DINNER");
                    for (int b = 0; b < buttons.length; b++) {
                        buttons[b].setEnabled(false);
                    }
                }

                return true;
            } else {
                System.out.println("Not Match");
                temp = -1;
                return false;
            }
        }
    }
}