/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author JYChin
 */
public class MotherBoard extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    MotherBoard(String name){
        super(name);
        setVisible(false);
        setSize(500,500);
        setLocation(screenSize.width/2 - this.getWidth()/2,screenSize.height/2 - this.getHeight()/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
