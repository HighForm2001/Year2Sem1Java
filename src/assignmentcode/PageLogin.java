
package assignmentcode;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PageLogin extends MotherBoard implements ActionListener{
    private final JButton login, guest, register;
    private final JLabel name,password;
    private JComboBox selection;
    private JTextField fill_text, fill_password;
    private JPanel top, mid, bottom;
    public PageLogin(){
        super("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,240);
        setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
        //Initial buttons and labels
        guest = new JButton("Guest");
        login = new JButton("Log in");
        register = new JButton("Register");
        name = new JLabel("ID: ");
        password = new JLabel("Password: ");
        fill_text = new JTextField(30);
        fill_password = new JTextField(30);
        String[] category = {"Staff", "Student"};
        selection = new JComboBox(category);
        top = new JPanel(new BorderLayout());
        mid = new JPanel(null);
        mid.add(name);
        mid.add(fill_text);
        mid.add(password);
        mid.add(fill_password);
        name.setBounds(95, 35, 25, 20);
        password.setBounds(50, 65, 100, 20);
        fill_text.setBounds(120,35,100,20);
        fill_password.setBounds(120,65,100,20);
//        name.setSize(50,30);
//        password.setSize(50,30);
        bottom = new JPanel(new BorderLayout());
        top.add(selection, BorderLayout.CENTER);
        add(top, BorderLayout.NORTH);

        bottom.add(guest,BorderLayout.WEST);
        bottom.add(login,BorderLayout.CENTER);
        bottom.add(register,BorderLayout.EAST);
        add(mid, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        //add component

        //Present GUI
        setVisible(true);
        //assign actionlistener
        guest.addActionListener(this);
        register.addActionListener(this);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(fill_text.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(fill_text, "Please enter your ID before login");
                }else if(fill_password.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(fill_password, "Please fill in your password before log in");
                }else{
                    boolean id = false;
                    boolean password = false;
                    if(selection.getSelectedItem().equals("Staff")){
                        for(int i = 0; i < AssignmentCode.allStaff.size(); i ++){
                            Staff a = AssignmentCode.allStaff.get(i);
                            if(a.compareID(fill_text.getText().trim()))
                                id = true;
                            if(a.comparePassword(fill_password.getText()))
                                password = true;
                            if(id && password){
                                setVisible(false);
                                AssignmentCode.start_staff.setVisible(true);
                                AssignmentCode.current_staff = a;
                                break;
                            }
                            id = false; password = false;
                        }
                    }else{
                        for(int i = 0; i < AssignmentCode.allStudent.size(); i ++){
                            Student a = AssignmentCode.allStudent.get(i);
                            if(a.getPassword().equals(fill_password.getText()))
                                password = true;
                            if(a.getID().equals(fill_text.getText()))
                                id = true;
                            if(id && password){
                                setVisible(false);
                                AssignmentCode.current_student = a;
                                AssignmentCode.menu_student.setVisible(true);
                                System.out.println(a.getSportID());
                                break;
                                
                            }
                            id = false; password = false;
                            for(int j = 0; i < AssignmentCode.registree.size(); i ++){
                            Student b = AssignmentCode.registree.get(i);
                            if(b.getPassword().equals(fill_password.getText()))
                                password = true;
                            if(b.getID().equals(fill_text.getText()))
                                id = true;
                            if(id && password){
                                setVisible(false);
                                AssignmentCode.current_student = b;
                                AssignmentCode.menu_student.setVisible(true);
                                System.out.println(b.getSportID());
                                break;
                            }
                            id = false; password = false;
                        }
                        }
                        
                        
                    }
                    if(!id||!password)
                        JOptionPane.showMessageDialog(fill_text,"ID or password are incorrect");

                }
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == guest){
            ViewAll va = new ViewAll();
            va.x.setVisible(true);
        }else if(ae.getSource() == register){
            setVisible(false);
            PageRegister_Student registerStudent = new PageRegister_Student();
            registerStudent.x.setVisible(true);
        }
    }
    
}
