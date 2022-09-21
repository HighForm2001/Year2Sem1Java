package assignmentcode;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PageRegister_Class implements ActionListener{
    public JFrame x;
    private final JButton payment,back;
    private final JLabel centre,sportIDc,sportNamec,time,day,coach,price,title;
    private JTextField sportName_t,price_t;
    private final JComboBox centre_c,sportID_c,time_c,coach_c,day_c;
    private final JPanel pb1,pb2,button_panel,top_panel;
    private String dayChoose;
    public PageRegister_Class(){
        x = new JFrame();
        x.setSize(800, 400);
        x.setLocation(300, 100);
        x.setLayout(new BorderLayout());
        pb1 = new JPanel();
        pb2 = new JPanel();
        pb1.setLayout(new GridLayout(7,1));
        pb2.setLayout(new GridLayout(7,1));
        button_panel = new JPanel();
        top_panel = new JPanel();
        button_panel.setLayout(new FlowLayout());
        centre = new JLabel("Centre:",JLabel.LEFT);
        sportNamec = new JLabel("Sport Chosen:",JLabel.LEFT);
        sportIDc = new JLabel("Sport ID chosen:",JLabel.LEFT);
        time = new JLabel("Time:",JLabel.LEFT);
        day = new JLabel("Day:",JLabel.LEFT);
        coach = new JLabel("Coach:",JLabel.LEFT);
        price = new JLabel("Price(per month):",JLabel.LEFT);
        title = new JLabel("Class Registration:");
        sportName_t = new JTextField(15);
        price_t = new JTextField(5);
        
        coach_c = new JComboBox<>();
        String [] centreStr = {"A","B","C"}; 
        centre_c = new JComboBox(centreStr);
        centre_c.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                addCoachtoBox();
                coach_c.invalidate();
            }
        });
        
        String [] sportIDStr = {"A01","A02","A03","A04","A05","A06","A07","A08","A09"}; 
        sportID_c = new JComboBox(sportIDStr);
        sportID_c.setSelectedIndex(-1);
        sportID_c.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    if(ie.getItem().toString().equals("A01")){
                        sportName_t.setText("ARCHERY");
                        price_t.setText("250");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A02")){
                        sportName_t.setText("BADMINTON");
                        price_t.setText("150");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A03")){
                        sportName_t.setText("CRICKET");
                        price_t.setText("150");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A04")){
                        sportName_t.setText("FOOTBALL");
                        price_t.setText("150");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A05")){
                        sportName_t.setText("GYMNASTICS");
                        price_t.setText("250");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A06")){
                        sportName_t.setText("SWIMMING");
                        price_t.setText("250");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A07")){
                        sportName_t.setText("TENNIS");
                        price_t.setText("250");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A08")){
                        sportName_t.setText("TABLE_TENNIS");
                        price_t.setText("250");
                        addCoachtoBox();
                    }
                    else if(ie.getItem().toString().equals("A09")){
                        sportName_t.setText("VOLLEYBALL");
                        price_t.setText("150");
                        addCoachtoBox();
                    }
                    coach_c.invalidate();
                    sportName_t.invalidate();
                    price_t.invalidate();
                }
            }
        });
        
        String [] dayStr = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}; 
        day_c = new JComboBox(dayStr);
        day_c.setSelectedIndex(-1);
        
        day_c.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    if(ie.getItem().toString().equals("Monday")){
                        dayChoose = day_c.getSelectedItem().toString();
                    }
                    else if(ie.getItem().toString().equals("Tuesday")){
                        dayChoose = day_c.getSelectedItem().toString();
                    }
                    else if(ie.getItem().toString().equals("Wednesday")){
                        dayChoose = day_c.getSelectedItem().toString();
                    }
                    else if(ie.getItem().toString().equals("Thursday")){
                        dayChoose = day_c.getSelectedItem().toString();
                    }
                    else if(ie.getItem().toString().equals("Friday")){
                        dayChoose = day_c.getSelectedItem().toString();
                    }
                    else if(ie.getItem().toString().equals("Saturday")){
                        dayChoose = day_c.getSelectedItem().toString();
                    }
                    else if(ie.getItem().toString().equals("Sunday")){
                        dayChoose = day_c.getSelectedItem().toString();
                    }
                    day_c.invalidate();
                }
            }
        });
        
        String [] timeStr = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}; 
        time_c = new JComboBox(timeStr);
        payment = new JButton("Payment");
        back = new JButton("Back");
        
        payment.addActionListener(this);
        back.addActionListener(this);
        x.add(pb2,BorderLayout.CENTER);
        x.add(pb1,BorderLayout.WEST);
        x.add(button_panel,BorderLayout.SOUTH);
        x.add(top_panel,BorderLayout.NORTH);
        x.setVisible(false);
        
        pb1.add(centre);
        pb2.add(centre_c);
        pb1.add(sportNamec);
        pb2.add(sportName_t);
        pb1.add(sportIDc);
        pb2.add(sportID_c);
        pb1.add(price);
        pb2.add(price_t);
        pb1.add(day);
        pb2.add(day_c);
        pb1.add(coach);
        pb2.add(coach_c);
        button_panel.add(back);
        button_panel.add(payment);
        top_panel.add(title);
        price_t.setEditable(false);
        sportName_t.setEditable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            AssignmentCode.current_student = null;
            x.setVisible(false);
            AssignmentCode.login.setVisible(true);
        }else{
            if(!allFilled()){
                JOptionPane.showMessageDialog(null, "Please fill in all the information to register");
            }else{
                classRegister();
                
            }
        }
    }
    
    private boolean allFilled(){
        return !(sportName_t.getText().trim().isEmpty() || centre_c.getSelectedIndex() == -1 || sportID_c.getSelectedIndex() == -1 ||
                time_c.getSelectedIndex() == -1 || coach_c.getSelectedIndex() == -1 || price_t.getText().trim().isEmpty() );
    }
    
    private void classRegister(){
        Student spare = AssignmentCode.current_student;
        String sportName = sportName_t.getText();
        boolean flag = true;
        for(int i=0; i<AssignmentCode.allStudent.size(); i++){
            Student s = AssignmentCode.allStudent.get(i);
            if(!sportName.equals(Sport.values())){
                JOptionPane.showMessageDialog(x,"Use the correct input for Sports Name");
                flag = false;
                break;
            }//else if()
        }
        if(flag){
            Coach teachStudent = null;
            for(int i = 0 ; i < AssignmentCode.allCoach.size(); i ++){
                if(AssignmentCode.allCoach.get(i).getName().equals(coach_c.getSelectedItem().toString())){
                    teachStudent = AssignmentCode.allCoach.get(i);
                    break;
                }
            }
            if(teachStudent == null){
                JOptionPane.showMessageDialog(null, "Coach not found");
            }else{
                if(teachStudent.bookClass(dayChoose)){
                    
                    Student s = new Student(spare.getID(),spare.getName(),spare.getPassword(),Gender.valueOf(spare.getGender().toString()),
                                            centre_c.getSelectedItem().toString(), sportID_c.getSelectedItem().toString(),Sport.valueOf(sportName_t.getText()),time_c.getSelectedItem().toString(),
                                            spare.getContact(),spare.getAddress(),Double.parseDouble(price_t.getText()),teachStudent);

                    AssignmentCode.allStudent.add(s);
                    AssignmentCode.registree.remove(AssignmentCode.current_student);
                    AssignmentCode.current_student = s;
                    payment();
                    StudentFunction.registerClass();
                    StudentFunction.register();
                    x.setVisible(false);
                    AssignmentCode.menu_student.setVisible(true);
                }else
                    JOptionPane.showMessageDialog(null,"This coach's slot for this moment has run out.\nPlease look for the other slots.");
            }
        }else{
            JOptionPane.showMessageDialog(x,"Please try again");
        }
    }
    
    private void addCoachtoBox(){
        coach_c.removeAllItems();
        if(centre_c.getSelectedIndex() != -1 && sportID_c.getSelectedIndex() != -1){
            for(int i = 0; i < AssignmentCode.allCoach.size(); i ++){
                if(AssignmentCode.allCoach.get(i).getCentre().getName().equals(centre_c.getSelectedItem().toString())){
                    if(AssignmentCode.allCoach.get(i).getSportID().equals(sportID_c.getSelectedItem().toString()))
                            coach_c.addItem(AssignmentCode.allCoach.get(i).getName());
                }
            }
        }
        
    }
   
    
    private void payment(){
        try{
            int payment;
            if(price_t.getText().equals("150")){
                payment = Integer.parseInt(price_t.getText());
                while (true){
                    int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Your payment is RM"+payment+". \nEnter the correct amount:"));
                    if(a<1){
                        throw new NegativeAmountException();
                    }
                    if(a>=payment){
                        JOptionPane.showMessageDialog(null, "Payment done!\n"+
                            "Your changes is RM"+(a-payment)+".");
                        break;
                    } else{
                        payment = payment-a;
                        JOptionPane.showMessageDialog(null, "You need to pay more RM"+payment+".\n"+"You must make full payment!");
                    }
                }
            }else if (price_t.getText().equals("250")){
                payment = Integer.parseInt(price_t.getText());
                while (true){
                    int a = Integer.parseInt(JOptionPane.showInputDialog(null, "Your payment is RM"+payment+". \nEnter the correct amount:"));
                    if(a<1){
                        throw new NegativeAmountException();
                    }
                    if(a>=payment){
                        JOptionPane.showMessageDialog(null, "Payment done!\n"+
                            "Your changes is RM"+(a-payment)+".");
                    
                        break;
                    } else{
                        payment = payment-a;
                        JOptionPane.showMessageDialog(null, "You need to pay more RM"+payment+".\n"+"You must make full payment!");
                    }
                }
            }
        } catch(NegativeAmountException ex){
            JOptionPane.showMessageDialog(null,"Please try again!");
        }
    }
}
