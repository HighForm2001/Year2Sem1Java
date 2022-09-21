
package assignmentcode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PageHomeStaff extends MotherBoard implements ActionListener {
    private final JButton search,modify,exit;
    private final JPanel panel = new JPanel();
    public PageHomeStaff(){
        super("HomePage");
        setSize(500,100);
        setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
        search = new JButton("Search Records");
        modify = new JButton("Modify Records");
        exit = new JButton("Exit");
        panel.add(search);
        panel.add(modify);
        panel.add(exit);
        add(panel);//, BorderLayout.CENTER);
        search.addActionListener(this);
        modify.addActionListener(this);
        exit.addActionListener(this);
        
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            AssignmentCode.login.setVisible(true);
            AssignmentCode.current_staff = null;
        }
        else if(e.getSource() == search){AssignmentCode.search_staff.setVisible(true);}
        else if(e.getSource() == modify){AssignmentCode.modify_staff.setVisible(true);}
        setVisible(false);
    }
}
