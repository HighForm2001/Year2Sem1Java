package assignmentcode;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class StudentMenu extends JFrame implements ActionListener {
    private final Button v_schedule, v_class, edit, feedback, rate, exit;
    private final Panel p1;
    public StudentMenu(){
        setSize(500,500);
        setLocation(500,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        p1 = new Panel();
        p1.setLayout(new GridLayout(3,2,5,5));
        v_schedule = new Button("View Schedule");
        v_class = new Button("View Class");
        edit = new Button("Edit Info");
        feedback = new Button("Give Feedback");
        rate = new Button("Ratings");
        exit = new Button("Logout");
        v_schedule.addActionListener(this);
        v_class.addActionListener(this);
        edit.addActionListener(this);
        feedback.addActionListener(this);
        rate.addActionListener(this);
        exit.addActionListener(this);
        add(p1);
        p1.add(v_schedule);
        p1.add(v_class);
        p1.add(edit);
        p1.add(feedback);
        p1.add(rate);
        p1.add(exit);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            setVisible(false);
            AssignmentCode.current_student = null;
            AssignmentCode.login.setVisible(true);
        } else if(e.getSource()==v_schedule){
            if(AssignmentCode.current_student.getSportID() != null){
                Student s = AssignmentCode.current_student;
                JOptionPane.showMessageDialog(null,"Centre : "+s.getCentre()+"\nSport No. :"+s.getSportID()+"\nSport :"+s.getSportNamec()+"\nSchedule Time :"+s.getTime()+"\nCoach :"+s.getCoach().getName()+"\nPrice :"+s.getPrice());
            }else{
                JOptionPane.showMessageDialog(v_schedule, "Please register for a class before checking the Schedule");
            }
        }else if(e.getSource()==v_class){
            if(AssignmentCode.current_student.getSportID() != null){
                Student s = AssignmentCode.current_student;
                JOptionPane.showMessageDialog(v_class,"Sport No. : "+s.getSportID()+"\nSport :"+s.getSportNamec()+"\nCoach :"+s.getCoach()+"Price :"+s.getPrice());
            }else{
                PageRegister_Class x = new PageRegister_Class();
                x.x.setVisible(true);
            }
        } else if(e.getSource()==edit){
            try{
                if(AssignmentCode.current_student == null)
                    throw new NoStudentLogInException();
                if(AssignmentCode.current_student.getSportID() == null){
                    JOptionPane.showMessageDialog(edit, "Please register for a class before editing your profile.");
                }else{
                    Modify4 editable = new Modify4();
                    editable.x.setVisible(true);
                }
            }catch(NoStudentLogInException ex){
                System.out.println(ex);
            }
        } else if(e.getSource()==rate){
            if(AssignmentCode.current_student.getSportID() != null){
                String [] values = {"1","2","3","4","5"};
                Object selected = JOptionPane.showInputDialog(null, "Ratings:", "Selection", JOptionPane.DEFAULT_OPTION, null, values, "0");
                if ( selected != null ){
                    int selectedRate = Integer.parseInt(selected.toString());
                    StudentFunction.rate(selectedRate);
                }else{
                    JOptionPane.showMessageDialog(null,"Cancelled rating." );
                }
            }else{
                JOptionPane.showMessageDialog(rate,"Please register for a class before rating your coach.");
            }
        }else{      //feedback
            //System.out.println(AssignmentCode.current_student.getSportID());
            if(AssignmentCode.current_student.getSportID() != null){
                Student s = AssignmentCode.current_student;
                String input = JOptionPane.showInputDialog("Feedback: ");
                try{
                StudentFunction.feedback(input,s.getCoach().getName());
                }catch(Exception exp){
                       System.out.println(exp);
                }
            }else{
                JOptionPane.showMessageDialog(feedback,"Please register for a class before giving feedback");
            }
        }
    }
}

