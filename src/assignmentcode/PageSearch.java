/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author JYChin
 */
public class PageSearch extends MotherBoard implements ActionListener{
    private final JLabel instruction, instruction2;
    private final JButton back, confirm, feedback;
    private final JComboBox selections_show, selections_sort;
    private final String[] combos_sort_coach = {"Coach ID", "Name","Sport ID", "Sport Centre ID", "Ratings", "Pay rate"};
    private final String[] combos_sort_student = {"Student ID", "Student Name", "Sport ID", "Sport Centre ID"};
    private final String[] combos_show = {"Student","Coach","Sport Centre"};
    private final Panel centre, north, group;
    private final Container contentPane = getContentPane();
    private static JScrollPane sp = new JScrollPane(); 
    private static JTable table;
    private static boolean first = true;
    private static JFrame x = new JFrame();
    public PageSearch() {
        super("Search Record");
        setSize(800,150);
        x.setSize(1500,400);
        setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
        x.setLocation(screenSize.width/2 - x.getWidth()/2,screenSize.height/2 - x.getHeight()/2);
        x.setLayout(new BorderLayout());
        instruction = new JLabel("Choose the record you want to show: ", JLabel.LEFT);
        instruction2 = new JLabel("Choose the sorting method: ", JLabel.LEFT);
        selections_show = new JComboBox(combos_show);
        selections_show.setSelectedIndex(-1);
        selections_sort = new JComboBox();
        back = new JButton("Back");
        confirm = new JButton("Confirm");
        feedback = new JButton("Feedback");
        centre = new Panel();
        north = new Panel();
        group = new Panel();
        centre.add(instruction);
        centre.add(selections_show);
        centre.add(instruction2);
        centre.add(selections_sort);
        centre.add(confirm);
        north.add(back);
        north.add(feedback);
        contentPane.add(north);
        contentPane.add(centre);
       group.add(centre, BorderLayout.CENTER);
       add(group, BorderLayout.NORTH);
       add(north, BorderLayout.SOUTH);
        back.addActionListener(this);
        confirm.addActionListener(this);
        selections_show.addActionListener(this);
        feedback.addActionListener(this);
        setInstructionVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //when click button Back
        if(ae.getSource() == back){
            dispose();
            AssignmentCode.start_staff.setVisible(true);
        }
        else if(ae.getSource() == feedback){
            ArrayList<String> feedbacks = SystemFunction.readFeedback();
            for(int i = 0; i < feedbacks.size(); i ++){
                JOptionPane.showMessageDialog(null, "Feedback " + i+1+": \n" + feedbacks.get(i));
            }
        }
        else if(ae.getSource() == confirm){
            if(selections_show.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(confirm, "Please select the records to show before sorting");
            }else if(selections_show.getSelectedIndex() == 0){
                sortStudent(selections_sort.getSelectedIndex());
            }else if(selections_show.getSelectedIndex() == 1){
                sortCoach(selections_sort.getSelectedIndex());           
            }
//            add(sp, BorderLayout.CENTER);
            SystemFunction.refresh(this);
        }
        else if(ae.getSource() == selections_show){
            if(selections_show.getSelectedIndex() == 0){
                    selections_sort.removeAllItems();
                    setInstructionVisible(true);
                    for(int i = 0; i < combos_sort_student.length; i ++)
                        selections_sort.addItem(combos_sort_student[i]);
                    search("Student");
                    if(first){
                        search("Student");
                        first = false;
                    }
            }else if(selections_show.getSelectedIndex() == 1){
                selections_sort.removeAllItems();
                setInstructionVisible(true);
                for(int i = 0; i < combos_sort_coach.length; i ++)
                    selections_sort.addItem(combos_sort_coach[i]);
                search( "Coach");
                if(first){
                    search("Coach");
                    first = false;
                }
            }else if(selections_show.getSelectedIndex() == 2){
                setInstructionVisible(false);
                search("sport centre");
                if(first){
                    search("sport centre");
                    first = false;
                }
            }
            SystemFunction.refresh(this);
        }
    }
    private void setInstructionVisible(boolean flag){
        selections_sort.setVisible(flag);
        instruction2.setVisible(flag);
        confirm.setVisible(flag);
    }
    public static void search(String person){
        if(person.equals("Coach")){
            String[] title = {"ID", "Name", "Gender", "Date Joined", "Date Terminated", "Contact", "Address", "Hourly Rate", "Sport Code", "Sport Name", "Rating", "Sport Centre", "Sport Centre ID"};
            String[][] content = new String[AssignmentCode.allCoach.size()][title.length];
            for(int i = 0; i < AssignmentCode.allCoach.size(); i ++){
                Coach a = AssignmentCode.allCoach.get(i);
                content[i] = a.toArray();
            }
            displaySearch(title, content);
            
        }else if(person.equals("Student")){
            String[] title = {"ID","Name","Gender","Sport ID","Sport Name","Contact","Address", "Sport Centre"};
            String[][] content = new String[AssignmentCode.allStudent.size()][title.length];
            for(int i = 0; i < AssignmentCode.allStudent.size(); i ++){
                Student a = AssignmentCode.allStudent.get(i);
                content[i] = a.toArray();
            }
            displaySearch(title, content);
        }else{
            String[] title = {"ID","Name","Location"};
            String[][] content = new String[AssignmentCode.allSportCentre.size()][title.length];
            for(int i = 0; i < AssignmentCode.allSportCentre.size(); i++){
                SportCentre a = AssignmentCode.allSportCentre.get(i);
                content[i][0] = a.getID();
                content[i][1] = a.getName();
                content[i][2] = a.getAddress();
            }
            displaySearch(title, content);
        }
    }
    public static void displaySearch(String[] title,String[][] content){
        createTable(title, content);
        sp.setViewportView(table);
        x.add(sp, BorderLayout.CENTER);
        x.setVisible(true);
    }
        
    
    public static void sortCoach(int type){
        if(type == 0){
            Collections.sort(AssignmentCode.allCoach, new StaffFunction.IDComparator());
        }else if(type == 1){
            Collections.sort(AssignmentCode.allCoach, new StaffFunction.NameComparator());
        }else if(type == 2){
            Collections.sort(AssignmentCode.allCoach, new StaffFunction.SportIDComparator());
        }else if(type == 3){
            Collections.sort(AssignmentCode.allCoach, new StaffFunction.SportCentreIDComparator());
        }else if(type == 4){
            Collections.sort(AssignmentCode.allCoach, new StaffFunction.RatingComparator());
        }else{
            Collections.sort(AssignmentCode.allCoach, new StaffFunction.SalaryComparator());
        }
        search("Coach");
    }
    public static void sortStudent(int type){
        if(type == 0){
            Collections.sort(AssignmentCode.allStudent, new StaffFunction.IDComparator());
        }else if(type == 1){
            Collections.sort(AssignmentCode.allStudent, new StaffFunction.NameComparator());
        }else if(type == 2){
            Collections.sort(AssignmentCode.allStudent, new StaffFunction.SportIDComparator());
        }else if(type == 3){
            Collections.sort(AssignmentCode.allStudent, new StaffFunction.SportCentreIDComparator());
        }
        search("Student");
    }
    private static void createTable(String[] title, String[][] content){
        table = new UneditableTable(content, title);
        sp = new JScrollPane(table);
    }
}
