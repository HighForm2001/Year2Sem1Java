/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SystemFunction {
    public static void refresh(MotherBoard page){
        page.setVisible(false);
        page.setVisible(true);
    }
    public static void refresh(Component cmpt){
        cmpt.setVisible(false);
        cmpt.setVisible(true);
    }
    public static void loadStudentFile(ArrayList<Student> list, File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String fline = reader.readLine();
            if(fline==null){
                throw new NoDataException("Student");
            }
            while(fline!=null){
                String name = reader.readLine();
                String password = reader.readLine();
                String gender = reader.readLine();
                String centre = reader.readLine();
                String sportID = reader.readLine();
                String sportName = reader.readLine();
                String time = reader.readLine();
                String contact = reader.readLine();
                String address = reader.readLine();
                String price = reader.readLine();
                String coach = reader.readLine();
                Coach a = getCoach(coach);
                Student b = new Student(fline,name,password,gender,centre,sportID,Sport.valueOf(sportName),
                        time,contact,address,Double.parseDouble(price),a);
                list.add(b);
                reader.readLine();
                fline = reader.readLine();
                
            }
        }catch(FileNotFoundException e){
            System.out.println("student.txt is missing");
        }catch(IOException e){
            System.out.println(e);
        }catch(NoDataException e){
            System.out.println(e);
        }
    }
    public static void loadCoachFile(ArrayList<Coach> list, File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String fline = reader.readLine();
            if(fline == null)
                throw new NoDataException("Coach");
            while(fline!= null){
                String name = reader.readLine();
                String gender = reader.readLine();
                String dateJoin = reader.readLine();
                String dateTerminated = reader.readLine();
                String contact = reader.readLine();
                String address = reader.readLine();
                String hourlyRate = reader.readLine();
                String sportCode = reader.readLine();
                String sport = reader.readLine();
                String rating = reader.readLine();
                String centre = reader.readLine();
                int monday = Integer.parseInt(reader.readLine());
                int tuesday = Integer.parseInt(reader.readLine());
                int wednesday = Integer.parseInt(reader.readLine());
                int thursday = Integer.parseInt(reader.readLine());
                int friday = Integer.parseInt(reader.readLine());
                int saturday = Integer.parseInt(reader.readLine());
                int sunday = Integer.parseInt(reader.readLine());
                int student = Integer.parseInt(reader.readLine());
                reader.readLine();
                SportCentre a = getCentre(centre);
                Coach c = new Coach(fline,name,Gender.valueOf(gender),dateJoin,dateTerminated,contact,address,Integer.parseInt(hourlyRate),
                sportCode,Sport.valueOf(sport),Integer.parseInt(rating),a, monday, tuesday, wednesday, thursday, friday, saturday, sunday,student);
                list.add(c);
                fline = reader.readLine();
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("coach.txt is missing");
        }catch(IOException e){
            System.out.println(e);
        }catch(NoDataException e){
            System.out.println(e);
        }
    }
    public static void loadStaffFile(ArrayList<Staff> list, File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String fline = reader.readLine();
            if(fline==null)
                throw new NoDataException("Staff");
            while(fline!= null){
                String password = reader.readLine();
                Staff a = new Staff(fline,password);
                list.add(a);
                reader.readLine();
                fline = reader.readLine();
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("centre.txt is missing");
        }catch(IOException e){
            System.out.println(e);
        }catch(NoDataException e){
            System.out.println(e);
        }
    }
 
    
    public static void loadSportCentreFile(ArrayList<SportCentre> list, File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String fline = reader.readLine();
            if(fline == null)
                throw new NoDataException("Sport Centre");
            while(fline!= null){
                String name = reader.readLine();
                String address = reader.readLine();
                SportCentre centre = new SportCentre(fline,name,address);
                reader.readLine();
                fline = reader.readLine();
                list.add(centre);
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("centre.txt is missing");
        }catch(IOException | NoDataException e){
            System.out.println(e);
        }
    }
    
    public static Coach getCoach(String coachName){
        Coach a = null;
        try{
            if(AssignmentCode.allCoach.isEmpty())
                throw new NoDataException("Coach");
            if(coachName == null)
                throw new NoDataException("Student");
            for(int i = 0; i < AssignmentCode.allCoach.size(); i++){
                if(coachName.equals(AssignmentCode.allCoach.get(i).getName())){
                    a = AssignmentCode.allCoach.get(i);
                    break;
                }
            }
        }catch(NoDataException e){
            System.out.println(e);
        }
        return a;
        
    }
    public static SportCentre getCentre(String centreName){
        SportCentre a = null;
        try{
            if(AssignmentCode.allSportCentre.isEmpty())
                throw new NoDataException("Sport Centre");
            if(centreName == null)
                throw new NoDataException("Coach");
            for(int i = 0; i < AssignmentCode.allSportCentre.size(); i ++){
                if(centreName.equals(AssignmentCode.allSportCentre.get(i).getName())){
                    a = AssignmentCode.allSportCentre.get(i);
                    break;
                }
            }
        }catch(NoDataException | NullPointerException e){
            System.out.println(e);
        }
        return a;
    }
    public static void writeCoachFile(File file)throws FileNotFoundException{
        try(PrintWriter out = new PrintWriter(file)){
            for(int i = 0; i < AssignmentCode.allCoach.size(); i ++){
                Coach a = AssignmentCode.allCoach.get(i);
                out.println(a.getID());
                out.println(a.getName());
                out.println(a.getGender());
                out.println(a.getDateJoin());
                out.println(a.getDateTerminated());
                out.println(a.getContact());
                out.println(a.getAddress());
                out.println(a.getHourlyRate());
                out.println(a.getSportID());
                out.println(a.getSport());
                out.println(a.getRating());
                out.println(a.getCentreName());
                out.println(a.getMondayClass());
                out.println(a.getTuesdayClass());
                out.println(a.getWednesdayClass());
                out.println(a.getThursdayClass());
                out.println(a.getFridayClass());
                out.println(a.getSaturdayClass());
                out.println(a.getSundayClass());
                out.println(a.getRatedStudentNumber());
                out.println();                
            }
        }
    }
    public static void loadRegistreeFile(ArrayList<Student> list, File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String fline = reader.readLine();
            if(fline==null){
                throw new NoDataException("Student");
            }
            while(fline!=null){
                String name = reader.readLine();
                String password = reader.readLine();
                String gender = reader.readLine();
                String contact = reader.readLine();
                String address = reader.readLine();
                Student a = new Student(fline, name, password, Gender.valueOf(gender), contact, address);
                list.add(a);
                reader.readLine();
                fline = reader.readLine();
                
            }
        }catch(FileNotFoundException e){
            System.out.println("student.txt is missing");
        }catch(IOException e){
            System.out.println(e);
        }catch(NoDataException e){
            System.out.println(e);
        }
    }
    public static ArrayList<String> readFeedback() {
        ArrayList<String> list = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"));
            String fline = reader.readLine();
            String concatenate = "";
            while(fline != null){
                concatenate += fline + "\n";
                concatenate += reader.readLine() + "\n";
                concatenate += reader.readLine() + "\n";
                concatenate += reader.readLine() + "\n";
                list.add(concatenate);
                concatenate = "";
                fline = reader.readLine();
            }
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"No Feedback found");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"IO Exception");
        }
        return list;
    }
}
