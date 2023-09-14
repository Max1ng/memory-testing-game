package m1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIButtons implements ActionListener {

    private Key key;
    private int[] solutionArr;

    // use this to match key to GUI class
    public GUIButtons(Key key) {
        this.key = key;
        this.solutionArr = key.solution;
    }

    
    public void actionPerformed(ActionEvent e) {

        if ("Button 0".equals(e.getActionCommand())) {
            System.out.println(solutionArr[0]);
        } else if ("Button 1".equals(e.getActionCommand())) {
            System.out.println(solutionArr[1]);
        }

    }
}