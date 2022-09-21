/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PageRegister_Coach extends MotherBoard implements ActionListener{
    private JLabel id_label, name_label, gender_label, date_join_label, contact_label, address_label, hr_label, sport_code_label, sport_name_label,slot_each_class_label,centre_label ;
    private JTextField id_fill, name_fill, contact_fill, address_fill, sport_name_fill, hr_fill,slot_each_class_fill;
    private JComboBox gender_box, year_join_box, month_join_box, day_join_box, sport_code_box, centre_box;
    private JPanel south, north, centre;
    private JButton register;
    public PageRegister_Coach(String name){
        super(name);
        setSize(500,300);
        setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
        setLayout(new BorderLayout());
        setName("Register");
        initial();
        north = new JPanel();
        centre = new JPanel(null);
        south = new JPanel();
        north.add(id_label);
        north.add(id_fill);
        north.add(name_label);
        north.add(name_fill);
        centre.add(gender_label);
        centre.add(gender_box);
        centre.add(date_join_label);
        centre.add(year_join_box);
        centre.add(month_join_box);
        centre.add(day_join_box);
        centre.add(contact_label);
        centre.add(contact_fill);
        centre.add(address_label);
        centre.add(address_fill);
        centre.add(hr_label);
        centre.add(hr_fill);
        centre.add(sport_code_label);
        centre.add(sport_code_box);
        centre.add(sport_name_label);
        centre.add(sport_name_fill);
        centre.add(slot_each_class_label);
        centre.add(slot_each_class_fill);
        centre.add(centre_label);
        centre.add(centre_box);
        gender_label.setBounds(new Rectangle(10, 15, 50, 20));
        gender_box.setBounds(new Rectangle(60, 15, 100, 20));
        date_join_label.setBounds(new Rectangle(180, 15, 100, 20));
        year_join_box.setBounds(new Rectangle(240,15,80,20));
        month_join_box.setBounds(new Rectangle(330,15,80,20));
        day_join_box.setBounds(new Rectangle(420,15,50,20));
        contact_label.setBounds(new Rectangle(10, 45, 100, 20));
        contact_fill.setBounds(new Rectangle(110, 45, 100, 20));
        address_label.setBounds(new Rectangle(10,75,100,20));
        address_fill.setBounds(new Rectangle(70,75,400,20));
        hr_label.setBounds(new Rectangle(10, 105, 100, 20));
        hr_fill.setBounds(new Rectangle(90, 105, 100, 20));
        sport_code_label.setBounds(new Rectangle(200, 105, 100, 20));
        sport_code_box.setBounds(new Rectangle(280, 105,50, 20));
        sport_name_label.setBounds(new Rectangle(10, 135, 100, 20));
        sport_name_fill.setBounds(new Rectangle(90, 135, 100, 20));
        slot_each_class_label.setBounds(new Rectangle(200, 135, 150, 20));
        slot_each_class_fill.setBounds(new Rectangle(355, 135, 100, 20));
        centre_label.setBounds(new Rectangle(220, 45, 150, 20));
        centre_box.setBounds(new Rectangle(350, 45, 100, 20));
        
        //add(north, BorderLayout.NORTH);
        south.add(register);
        add(north, BorderLayout.NORTH);
        add(centre, BorderLayout.CENTER);
        //add(west, BorderLayout.WEST);
        //add(east, BorderLayout.EAST);
        add(south, BorderLayout.SOUTH);     
        register.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == register){
            if(!allFilled())
                JOptionPane.showMessageDialog(register, "Please fill in all the information to register");
            else
                registration();
            
        }
    }
    private void initial(){
        id_label = new JLabel("Coach ID: ", JLabel.LEFT);
        name_label = new JLabel("Coach Name: ", JLabel.LEFT);
        gender_label = new JLabel("Gender: ", JLabel.LEFT);
        date_join_label = new JLabel("Date Join: ", JLabel.LEFT);
        contact_label = new JLabel("Contact number: ", JLabel.LEFT);
        address_label = new JLabel("Address: ", JLabel.LEFT);
        hr_label = new JLabel("Hourly Rate: ", JLabel.LEFT);
        sport_code_label = new JLabel("Sport Code: ", JLabel.LEFT);
        sport_name_label = new JLabel("Sport Name: ", JLabel.LEFT);
        slot_each_class_label = new JLabel("Slots open for each class: ", JLabel.LEFT);
        centre_label = new JLabel("Sport Centre Name: ", JLabel.LEFT);
        id_fill = new JTextField(8);
        name_fill = new JTextField(20);
        contact_fill = new JTextField(12);
        address_fill = new JTextField(50);
        sport_name_fill = new JTextField(15);
        hr_fill = new JTextField(3);
        sport_name_fill.setEditable(false);
        hr_fill.setEditable(false);
        Gender[] gender = {Gender.MALE, Gender.FEMALE, Gender.OTHER};
        gender_box = new JComboBox(gender);
        slot_each_class_fill = new JTextField(3);
        String[] years = {"2010", "2011", "2012", "2013", "2014", "2015","2016", "2017", "2018", "2019", "2020", "2021"};
        year_join_box = new JComboBox(years);
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
        month_join_box = new JComboBox(months);
        month_join_box.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    System.out.println(day_join_box.getSelectedIndex());
                    if((ie.getItem().toString().equals("Jan")||ie.getItem().toString().equals("Mar"))||ie.getItem().toString().equals("May")||ie.getItem().toString().equals("Jul")||
                        ie.getItem().toString().equals("Aug")||ie.getItem().toString().equals("Oct")||ie.getItem().toString().equals("Dec")){
                    if(day_join_box.getItemCount() < 31){
                        if(day_join_box.getItemCount() == 28){
                            day_join_box.addItem("29");
                            day_join_box.addItem("30");     
                        }else if(day_join_box.getItemCount() == 29){
                            day_join_box.addItem("30");
                        }
                        day_join_box.addItem("31");
                    }
                }else if(ie.getItem().toString().equals("Feb")){
                    try{
                        if(year_join_box.getSelectedIndex() == -1)
                            throw new ComboBoxNotSelectedException(year_join_box);
                        if(Integer.parseInt(year_join_box.getSelectedItem().toString())%4 == 0){
                            if(day_join_box.getItemCount() > 29){
                                if(day_join_box.getItemCount() == 31){
                                    day_join_box.removeItem("31");
                                }
                                day_join_box.removeItem("30");
                            }else if(day_join_box.getItemCount() == 28){
                                day_join_box.addItem("29");
                            }
                        }else{
                            if(day_join_box.getItemCount() > 28){
                                if(day_join_box.getItemCount() == 31){
                                    day_join_box.removeItem("30");
                                    day_join_box.removeItem("31"); 
                                }else if(day_join_box.getItemCount() == 30){
                                    day_join_box.removeItem("30");
                                }
                                day_join_box.removeItem("29");
                            }
                        }
                    }catch(ComboBoxNotSelectedException e){
                        System.out.println(e);
                    }
                }else{
                    if(day_join_box.getItemCount() < 30){
                        if(day_join_box.getItemCount() == 28){
                            day_join_box.addItem("29");
                        }
                        day_join_box.addItem("30");
                    }else if(day_join_box.getItemCount() > 30){
                        day_join_box.removeItem("31");
                    }
                }
            SystemFunction.refresh(day_join_box);}}});
        String[] sport_code = {"A01","A02","A03","A04","A05","A06","A07","A08","A09"};
        sport_code_box = new JComboBox(sport_code);
        register = new JButton("Register!");
        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        sport_code_box.setSelectedIndex(-1);
        sport_code_box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    if(ie.getItem().toString().equals("A01")){
                        sport_name_fill.setText("ARCHERY");
                        hr_fill.setText("100");
                        slot_each_class_fill.setText("10");
                    }
                    else if(ie.getItem().toString().equals("A02")){
                        hr_fill.setText("100");
                        sport_name_fill.setText("BADMINTON");
                        slot_each_class_fill.setText("10");
                    }
                    else if(ie.getItem().toString().equals("A03")){
                        sport_name_fill.setText("CRICKET");
                        hr_fill.setText("200");
                        slot_each_class_fill.setText("10");
                    }
                    else if(ie.getItem().toString().equals("A04")){
                        sport_name_fill.setText("FOOTBALL");
                        hr_fill.setText("200");
                        slot_each_class_fill.setText("20");
                    }
                    else if(ie.getItem().toString().equals("A05")){
                        sport_name_fill.setText("GYMNASTICS");
                        hr_fill.setText("300");
                        slot_each_class_fill.setText("15");
                    }
                    else if(ie.getItem().toString().equals("A06")){
                        sport_name_fill.setText("SWIMMING");
                        hr_fill.setText("300");
                        slot_each_class_fill.setText("5");
                    }
                    else if(ie.getItem().toString().equals("A07")){
                        sport_name_fill.setText("TENNIS");
                        hr_fill.setText("400");
                        slot_each_class_fill.setText("5");
                    }
                    else if(ie.getItem().toString().equals("A08")){
                        sport_name_fill.setText("TABLE_TENNISs");
                        hr_fill.setText("400");
                        slot_each_class_fill.setText("15");
                    }
                    else if(ie.getItem().toString().equals("A09")){
                        sport_name_fill.setText("VOLLEYBALL");
                        hr_fill.setText("500");
                        slot_each_class_fill.setText("15");
                    }
                    sport_name_fill.invalidate();
                    hr_fill.invalidate();
                    slot_each_class_fill.invalidate();
                }
            }
        });
        day_join_box = new JComboBox(days);
        centre_box = new JComboBox();
        for(int i = 0; i < AssignmentCode.allSportCentre.size(); i ++){
            centre_box.addItem(AssignmentCode.allSportCentre.get(i).getName());
        }
        centre_box.setSelectedIndex(-1);
        year_join_box.setSelectedIndex(-1);
        month_join_box.setSelectedIndex(-1);
        day_join_box.setSelectedIndex(-1);
        year_join_box.setName("Year combo box");
        month_join_box.setName("Month combo box");
        day_join_box.setName("Day combo box");
        year_join_box.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                if(ie.getStateChange() == ItemEvent.SELECTED){
                    try{
                        if(month_join_box.getSelectedIndex() == -1)
                            throw new ComboBoxNotSelectedException(month_join_box);
                        if(month_join_box.getSelectedItem().toString().equals("February")){
                            if(Integer.parseInt(ie.getItem().toString()) % 4 == 0){
                                if(day_join_box.getItemCount() == 28)
                                    day_join_box.addItem("29");

                            }else{
                                if(day_join_box.getItemCount() == 29)
                                    day_join_box.removeItem("29");   
                            }
                        }
                    SystemFunction.refresh(day_join_box);
                    }catch(ComboBoxNotSelectedException e){
                        System.out.print(e);
                    }
                }
            }
        });
        KeyAdapter integerOnly = new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c))
                    return;
                e.consume();
            }
        };
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
        id_fill.addKeyListener(integerOnly);
        slot_each_class_fill.addKeyListener(integerOnly);
        contact_fill.addKeyListener(integerOnly);
        name_fill.addKeyListener(stringOnly);
        address_fill.addKeyListener(addressOnly);
    }
            
    
    private boolean allFilled(){
        if(id_fill.getText().isEmpty() || name_fill.getText().trim().isEmpty() || contact_fill.getText().isEmpty() ||
                address_fill.getText().trim().isEmpty() || year_join_box.getSelectedIndex() == -1 || month_join_box.getSelectedIndex() == -1 ||
                day_join_box.getSelectedIndex() == -1 || sport_code_box.getSelectedIndex() == -1 || centre_box.getSelectedIndex() == -1){
            return false;
        }
        return true;
    }
    
    private void registration(){
        for(int i = 0; i < AssignmentCode.allCoach.size(); i ++){
            if(id_fill.getText().equals(AssignmentCode.allCoach.get(i).getID())){
                if(AssignmentCode.allCoach.get(i).getGender().equals(Gender.MALE))
                    JOptionPane.showMessageDialog(register, "An user with this ID is registered.\n His name is: " + AssignmentCode.allCoach.get(i).getName());
                else
                    JOptionPane.showMessageDialog(register, "An user with this ID is registered. \nHer name is: " + AssignmentCode.allCoach.get(i).getName());
                return;
            }
        }
        int slots = Integer.parseInt(slot_each_class_fill.getText());
        String dateJoin = day_join_box.getSelectedItem().toString() + "-" + month_join_box.getSelectedItem().toString() + "-" + year_join_box.getSelectedItem().toString();
        int hrRate = Integer.parseInt(hr_fill.getText());
        Sport sport = Sport.valueOf(sport_name_fill.getText());
        SportCentre centre = null;
        for(int i = 0; i < AssignmentCode.allSportCentre.size(); i++){
            if(centre_box.getSelectedItem().equals(AssignmentCode.allSportCentre.get(i).getName()))
                centre = AssignmentCode.allSportCentre.get(i);
        }
        Coach newCoach = new Coach(id_fill.getText(), name_fill.getText(),Gender.valueOf(gender_box.getSelectedItem().toString()),
                dateJoin,"NA",contact_fill.getText(),address_fill.getText(),hrRate,sport_code_box.getSelectedItem().toString(),sport,-1,centre,
                slots,0);
        AssignmentCode.allCoach.add(newCoach);
        try{
            SystemFunction.writeCoachFile(AssignmentCode.coach_file);
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"Coach file not found");
        }
        
    }
}
