package assignmentcode;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewAll extends JFrame implements ActionListener{
    public final JFrame x;
    private final JLabel sport_centre_label, schedule_label;
    private final JPanel p_center, p_south, p_table, p_top;
    private final JButton back;
    private final JTable table;
    private final JScrollPane sp;
    public ViewAll(){
        x = new JFrame();
        x.setSize(500, 400);
        x.setLocation(756,350);
        x.setLayout(new BorderLayout());
        p_center = new JPanel();
        p_south = new JPanel();
        p_table = new JPanel();
        p_top = new JPanel();
        p_center.setLayout(new BorderLayout()); 
        p_south.setLayout(new FlowLayout());
        p_table.setLayout(new FlowLayout());
        p_top.setLayout(new GridLayout(2,1));
        sport_centre_label = new JLabel("Sport Centre: A, B, C",JLabel.CENTER);
        schedule_label = new JLabel("Class Held: 6pm to 7pm Daily",JLabel.CENTER);
        back = new JButton("Back");
        back.addActionListener(this);

        String data[][]={ {"Archery","250"},    
                          {"Badminton","150"},    
                          {"Cricket","150"},
                          {"Football","150"},
                          {"Gymnastics","250"},
                          {"Swimming","250"},
                          {"Tennis","250"},
                          {"Table Tennis","250"},
                          {"Volleyball","150"}}; 
        String[] columnNames = { "Sport:", "Price(per month):" };
        table = new UneditableTable(data, columnNames);
        sp = new JScrollPane(table);

        p_top.add(sport_centre_label);
        p_top.add(schedule_label);
        p_table.add(sp);
        p_south.add(back);
        p_center.add(p_table,BorderLayout.CENTER);
        p_center.add(p_top,BorderLayout.NORTH);
        x.add(p_center,BorderLayout.CENTER);
        x.add(p_south,BorderLayout.SOUTH);
        x.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back){ 
            x.setVisible(false);
            AssignmentCode.login.setVisible(true);
            
        }
        
    }
}