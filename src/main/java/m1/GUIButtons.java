package m1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;


public class GUIButtons implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        if ("Button 1".equals(e.getActionCommand())) {
            System.out.println("heya!");
        }


        
    }
}