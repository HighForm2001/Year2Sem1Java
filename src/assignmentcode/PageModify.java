package assignmentcode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PageModify extends MotherBoard implements ActionListener{
    private JButton register, back, terminateCoach;
    private JPanel panel1;
    private static MotherBoard page = new MotherBoard("null");
    public PageModify(){
        super("Modify Record");
        setSize(500,100);
        setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
        panel1 = new JPanel();
        back = new JButton("Back");
        //add(back);//, BorderLayout.PAGE_END);
        register = new JButton("Register new coach");
        terminateCoach = new JButton("Terminate coach");
        back.addActionListener(this);
        register.addActionListener(this);
        terminateCoach.addActionListener(this);
        panel1.add(back);
        panel1.add(register);
        panel1.add(terminateCoach);
        add(panel1, BorderLayout.PAGE_START);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){
            setVisible(false);
            page.dispose();
            AssignmentCode.start_staff.setVisible(true);
        }else if(e.getSource() == register){
            if(page.getName().equals("Register")){
                page.setVisible(true);
            }else{
                page.dispose();
                page = new PageRegister_Coach("Register a coach");
                page.setVisible(true);
            }
       }else{
            if(page.getName().equals("Sport")){
                page.setVisible(true);
            }else{
                page.dispose();
                page = new PageTerminate("Terminate coaches");
                page.setVisible(true);
            }
        }
    }
}
