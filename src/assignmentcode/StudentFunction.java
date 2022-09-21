package assignmentcode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StudentFunction {
    public static void register(){
        try{
            PrintWriter p = new PrintWriter("register.txt");
            for(int i=0; i<AssignmentCode.allStudent.size(); i++){
                Student s = AssignmentCode.allStudent.get(i);
                p.println(s.getID());
                p.println(s.getName());
                p.println(s.getPassword());
                p.println(s.getGender());
                p.println(s.getContact());
                p.println(s.getAddress());
                p.println();
            }
            p.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
 
    public static void registerClass(){
        
        try{
            PrintWriter p = new PrintWriter("student.txt");
            for(int i=0; i<AssignmentCode.allStudent.size(); i++){
                Student s = AssignmentCode.allStudent.get(i);
                p.println(s.getID());
                System.out.println(s.getID());
                p.println(s.getName());
                p.println(s.getPassword());
                p.println(s.getGender());
                p.println(s.getCentre());
                p.println(s.getSportID());
                p.println(s.getSportNamec());
                p.println(s.getTime());
                p.println(s.getContact());
                p.println(s.getAddress());
                p.println(s.getPrice());
                p.println(s.getCoach().getName());
                p.println();
            }
            p.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public static void feedback(String text, String coach) throws Exception {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        Student s = AssignmentCode.current_student;
        try { 
            fw = new FileWriter("feedback.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(s.getID());
            pw.println(s.getName());
            pw.println(text);
            pw.println(coach);
            pw.println("");
            System.out.println("Data Successfully appended into file");
            pw.flush();
        } finally {
          try { pw.close();
                bw.close();
                fw.close();
          } catch (Exception ex) {
             System.out.println(ex);
          }
        }
    }    

    public static void rate(int mark){
        Student s =AssignmentCode.current_student;
        Coach studentCoach = s.getCoach();
        int rating = studentCoach.getRating();
        int total = studentCoach.getRatedStudentNumber();
        rating = rating *total;
        rating = rating + mark;
        studentCoach.addStudent();
        total = studentCoach.getRatedStudentNumber();
        double rates = rating/ total;
        if(rates >=4.5)
            studentCoach.setRating(5);
        else if(rates >= 3.5)
            studentCoach.setRating(4);
        else if(rates >= 2.5)
            studentCoach.setRating(3);
        else if(rates >= 1.5)
            studentCoach.setRating(2);
        else if(rates >= 0.5)
            studentCoach.setRating(1);
        else
            studentCoach.setRating(0);
        try{
            SystemFunction.writeCoachFile(AssignmentCode.coach_file);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
