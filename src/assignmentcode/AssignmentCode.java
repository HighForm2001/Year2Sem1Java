package assignmentcode;


import java.io.File;
import java.util.ArrayList;




public class AssignmentCode{
    public static PageHomeStaff start_staff = new PageHomeStaff();
    public static PageLogin login = new PageLogin();
    public static PageSearch search_staff = new PageSearch();
    public static PageModify modify_staff = new PageModify();
    public static File student_file = new File("student.txt");
    public static File coach_file = new File("coach.txt");
    public static File staff_file = new File("staff.txt");
    public static File schedule_file = new File("schedule.txt");
    public static File sport_file = new File("sport.txt");
    public static File sport_centre_file = new File("centre.txt");
    public static File registree_file = new File("register.txt");
    public static ArrayList<Coach> allCoach = new ArrayList<>();
    public static ArrayList<Student> allStudent = new ArrayList<>();
    public static ArrayList<SportCentre> allSportCentre = new ArrayList<>();
    public static ArrayList<Staff> allStaff = new ArrayList<>();
    public static ArrayList<Student> registree = new ArrayList<>();
    public static StudentMenu menu_student = new StudentMenu();
    public static Student current_student;
    public static Staff current_staff;

    public static void main(String[] args){
        SystemFunction.loadSportCentreFile(allSportCentre, sport_centre_file);
//        for(int i = 0; i < allSportCentre.size(); i ++){
//            System.out.println(allSportCentre.get(i).getName());
//        }
        SystemFunction.loadCoachFile(allCoach, coach_file);
        for(int i = 0; i < allCoach.size(); i ++){
            System.out.println(allCoach.get(i));
            System.out.println(allCoach.get(i).getName());
        }
        SystemFunction.loadStudentFile(allStudent,student_file);
//        for(int i = 0; i < allStudent.size(); i ++){
//            System.out.println(allStudent.get(i));
//        }
        SystemFunction.loadStaffFile(allStaff, staff_file);
//        for(int i = 0; i < allStaff.size(); i ++){
//            System.out.println(allStaff.get(i));
//        }
        SystemFunction.loadRegistreeFile(registree, registree_file);
    }
    
    
    
    
}
