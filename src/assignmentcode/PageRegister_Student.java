package assignmentcode;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PageRegister_Student implements ActionListener{
    public JFrame x;
    private final JButton register,back;
    private final JLabel id,name,pw,gender,contact,address;
    private final JTextField id_t,name_t,pw_t,contact_t,address_t;
    private final JComboBox gender_c;
    private final JPanel pb1,pb2,button_panel;
    
    public PageRegister_Student(){
        x = new JFrame();
        x.setSize(800, 400);
        x.setLocation(300, 100);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x.setLayout(new BorderLayout());
        pb1 = new JPanel();
        pb2 = new JPanel();
        pb1.setLayout(new GridLayout(6,1));
        pb2.setLayout(new GridLayout(6,1));
        button_panel = new JPanel();
        button_panel.setLayout(new FlowLayout());
        id = new JLabel("IC No.:",JLabel.LEFT);
        name = new JLabel("Name:",JLabel.LEFT);
        pw = new JLabel("Password:",JLabel.LEFT);
        gender = new JLabel("Gender:",JLabel.LEFT);
        contact = new JLabel("Contact Number:",JLabel.LEFT);
        address = new JLabel("Address:",JLabel.LEFT);
        id_t = new JTextField(8);
        name_t = new JTextField(20);
        pw_t = new JTextField(15);
        contact_t = new JTextField(12);
        address_t = new JTextField(50);
        
        KeyAdapter stringOnly = new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(c >= 65 && c<= 90 || c == 32)
                    return;
                if(c >= 97 && c <= 122)
                    return;
                e.consume();
            }
        };
        
        KeyAdapter integerOnly = new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c))
                    return;
                e.consume();
            }
        };
        KeyAdapter addressOnly = new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c))
                    return;
                if(c >= 65 && c<= 90 || c == 32)
                    return;
                if(c >= 97 && c <= 122)
                    return;
                e.consume();
            }
        };
        
        id_t.addKeyListener(integerOnly);
        name_t.addKeyListener(stringOnly);
        contact_t.addKeyListener(integerOnly);
        address_t.addKeyListener(addressOnly);
        
        Gender [] genderStr = {Gender.MALE, Gender.FEMALE, Gender.OTHER};
        gender_c = new JComboBox(genderStr);
        register = new JButton("Register");
        back = new JButton("Back");
        
        register.addActionListener(this);
        back.addActionListener(this);
        x.add(pb2,BorderLayout.CENTER);
        x.add(pb1,BorderLayout.WEST);
        x.add(button_panel,BorderLayout.SOUTH);
        x.setVisible(false);
        pb1.add(id);
        pb2.add(id_t);
        pb1.add(name);
        pb2.add(name_t);
        pb1.add(pw);
        pb2.add(pw_t);
        pb1.add(gender);
        pb2.add(gender_c);
        pb1.add(contact);
        pb2.add(contact_t);
        pb1.add(address);
        pb2.add(address_t);
        button_panel.add(register);
        button_panel.add(back);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            AssignmentCode.current_student = null;
            x.setVisible(false);
            AssignmentCode.login.setVisible(true);
        }else{
            if(!allFilled()){
                JOptionPane.showMessageDialog(register, "Please fill in all the information to register");
            }else{
                registration();
            }
        }
    }
    
    private boolean allFilled(){
        return !(id_t.getText().trim().isEmpty() || name_t.getText().trim().isEmpty() || pw_t.getText().trim().isEmpty() || 
                contact_t.getText().trim().isEmpty() || address_t.getText().trim().isEmpty() || gender_c.getSelectedIndex() == -1);
    }
    
    private void registration(){
        String id = id_t.getText();
        boolean flag = true;
        for(int i=0; i<AssignmentCode.allStudent.size(); i++){
            Student s = AssignmentCode.allStudent.get(i);
            if(id.equals(s.getID())){
                JOptionPane.showMessageDialog(x,"ID has been used.");
                flag = false;
                break;
            }//else if()
        }
        if(flag){
            Student s = new Student(id,name_t.getText(),pw_t.getText(),
                                    Gender.valueOf(gender_c.getSelectedItem().toString()),
                                    contact_t.getText(),address_t.getText());
            
            AssignmentCode.allStudent.add(s);
            StudentFunction.register();
            JOptionPane.showMessageDialog(null,"Registration successful!");
            x.setVisible(false);
            AssignmentCode.login.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(x,"Please try again");
        }
    }
    
}
