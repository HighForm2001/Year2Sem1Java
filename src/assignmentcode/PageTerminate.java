/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author JYChin
 */
public class PageTerminate extends MotherBoard implements ActionListener{
    private final JButton terminate, back;
    private JTable table;
    private JScrollPane sp;
    String[] title = {"ID", "Name", "Gender", "Date Joined", "Date Terminated", "Contact", "Address", "Hourly Rate", "Sport Code", "Sport Name", "Rating", "Sport Centre"};
    String[][] content = new String[AssignmentCode.allCoach.size()][title.length];
    public PageTerminate(String name){
        super(name);
        loadCoachArray();
        createTable();
         add(sp, BorderLayout.CENTER);
        
        terminate = new JButton("Terminate this coach");
        back = new JButton("Back");
        add(terminate,BorderLayout.SOUTH);
        add(back, BorderLayout.EAST);
        back.addActionListener(this);
        terminate.addActionListener(this);
       // terminate.setBounds(new Rectangle(getWidth()/2-10, getHeight()-10, getWidth()/5, getHeight()/10));
      //  back.setBounds(new Rectangle(getWidth()/2+10,getHeight()-10,getWidth()/5,getHeight()/10));
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == back)
            dispose();
        else if(e.getSource() == terminate){
            terminator(table.getSelectedRow());
        }
    }
    public void terminator(int row){
        Coach a = AssignmentCode.allCoach.get(row);
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String strDate = dateFormat.format(date);
        try{
        int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to terminate this person?","Warning",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
           a.setDateTerminated(strDate);
           SystemFunction.writeCoachFile(AssignmentCode.coach_file);
           loadCoachArray();
           createTable();
           SystemFunction.refresh(this);
        }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Coach file is missing");
        }
    }
    private void loadCoachArray(){
        for(int i = 0; i < AssignmentCode.allCoach.size(); i ++){
            Coach a = AssignmentCode.allCoach.get(i);
            content[i] = a.toArray();
        }
    }
    private void createTable(){
        table = new UneditableTable(content, title);
        sp = new JScrollPane(table);
       
    }
    
}
