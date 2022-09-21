package assignmentcode;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Modify4 implements ActionListener{
    public final JFrame x;
    private final JButton confirm,back;
    private final JLabel id,name,pw,gender,centre,sportIDc,sportNamec,time,coach,contact,address,price,
                    id_t,centre_c,sportID_c,sportName_t,time_c,coach_c,price_t;
    private final JTextField name_t,pw_t,contact_t,address_t;
    private final JComboBox gender_c;
    private final JPanel pb1,pb2,button_panel;
    public Modify4(){
        x = new JFrame();
        x.setSize(800, 400);
        x.setLocation(300, 100);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setLayout(new BorderLayout());
        pb1 = new JPanel();
        pb2 = new JPanel();
        pb1.setLayout(new GridLayout(11,1)); 
        pb2.setLayout(new GridLayout(11,1));
        button_panel = new JPanel();
        button_panel.setLayout(new FlowLayout());
        id = new JLabel("IC No.:",JLabel.LEFT);
        name = new JLabel("Name:",JLabel.LEFT);
        pw = new JLabel("Password:",JLabel.LEFT);
        gender = new JLabel("Gender:",JLabel.LEFT);
        centre = new JLabel("Centre:",JLabel.LEFT);
        sportNamec = new JLabel("Sport Chosen:",JLabel.LEFT);
        sportIDc = new JLabel("Sport ID chosen:",JLabel.LEFT);
        time = new JLabel("Time:",JLabel.LEFT);
        coach = new JLabel("Coach:",JLabel.LEFT);
        contact = new JLabel("Contact Number:",JLabel.LEFT);
        address = new JLabel("Address:",JLabel.LEFT);
        price = new JLabel("Price(per month):",JLabel.LEFT);
        
        id_t = new JLabel(AssignmentCode.current_student.getID());
        centre_c = new JLabel(AssignmentCode.current_student.getCentre().getName());  
        sportName_t = new JLabel(AssignmentCode.current_student.getSportNamec());    
        sportID_c = new JLabel(AssignmentCode.current_student.getSportID());
        time_c = new JLabel(AssignmentCode.current_student.getTime());
        coach_c = new JLabel(AssignmentCode.current_student.getCoach().toString());    
        price_t = new JLabel(String.valueOf(AssignmentCode.current_student.getPrice()));//unknown
        name_t = new JTextField(20);
        pw_t = new JTextField(15);
        contact_t = new JTextField(15);
        address_t = new JTextField(50);
        Gender [] genderStr = {Gender.MALE, Gender.FEMALE, Gender.OTHER};
        gender_c = new JComboBox(genderStr);
        confirm = new JButton("Confirm");
        back = new JButton("Back");
        confirm.addActionListener(this);
        back.addActionListener(this);
        x.add(pb2,BorderLayout.CENTER);
        x.add(pb1,BorderLayout.WEST);
        x.add(button_panel,BorderLayout.SOUTH);
        x.setVisible(true);
        pb1.add(id);
        pb2.add(id_t);
        pb1.add(name);
        pb2.add(name_t);
        pb1.add(pw);
        pb2.add(pw_t);
        pb1.add(gender);
        pb2.add(gender_c);
        pb1.add(centre);
        pb2.add(centre_c);
        pb1.add(sportNamec);
        pb2.add(sportName_t);
        pb1.add(sportIDc);
        pb2.add(sportID_c);
        pb1.add(price);
        pb2.add(price_t);
        pb1.add(time);
        pb2.add(time_c);
        pb1.add(coach);
        pb2.add(coach_c);
        pb1.add(contact);
        pb2.add(contact_t);
        pb1.add(address);
        pb2.add(address_t);
        button_panel.add(confirm);
        button_panel.add(back);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            AssignmentCode.current_student = null;
            x.setVisible(false);
            AssignmentCode.menu_student.setVisible(true);
        }else{
            if(!allFilled()){
                JOptionPane.showMessageDialog(confirm, "Please fill in all the information to register");
            }else{
                confirmation();
            }
        }
    }
    
    private boolean allFilled(){
        return !(name_t.getText().trim().isEmpty() || pw_t.getText().trim().isEmpty() || contact_t.getText().trim().isEmpty() ||
                address_t.getText().trim().isEmpty() || gender_c.getSelectedIndex() == -1);
    }
    
    private void confirmation(){
        Coach teachStudent = null;
        for(int i = 0 ; i < AssignmentCode.allCoach.size(); i ++){
            if(AssignmentCode.allCoach.get(i).getName().equals(coach_c.toString())){
                teachStudent = AssignmentCode.allCoach.get(i);
                break;
            }
        }
        Student s = new Student(id_t.getText(),name_t.getText(),pw_t.getText(),gender_c.getSelectedItem().toString(),
                centre_c.toString(),sportID_c.toString(),sportName_t.getText(),time_c.toString(),
                contact_t.getText(),address_t.getText(),Double.parseDouble(price_t.getText()),teachStudent);
        
        AssignmentCode.allStudent.add(s);
        AssignmentCode.allStudent.remove(AssignmentCode.current_student);
        AssignmentCode.current_student = s;
        StudentFunction.register();
        AssignmentCode.menu_student.setVisible(true);
    }
        
}
