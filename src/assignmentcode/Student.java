package assignmentcode;
public class Student extends User{

    private String password;
    private String time;
    private double price;
    private Coach coach;
    
    public Student(String studentID, String name, String password, Gender gender, String centre, String sportIDc,
                   Sport sportNamec, String time,String contact, String address,double price,Coach coach) {
        super(studentID, name, gender, address, contact, sportNamec, sportIDc, getCentreByName(centre));
        this.password = password;
        this.time = time;
        this.price = price;
        this.coach = coach;
    }
    public Student(String studentID, String name, String password, String gender, String centre, String sportIDc,
                   Sport sportNamec, String time,String contact, String address,double price,Coach coach) {
        
        super(studentID, name, Gender.valueOf(gender), address, contact, sportNamec, sportIDc, getCentreByName(centre));
        this.password = password;
        this.time = time;
        this.price = price;
        this.coach = coach;
    }
    public Student(String studentID, String name, String password, String gender, String centre, String sportIDc,
                   String sportNamec, String time,String contact, String address,double price,Coach coach) {
        
        super(studentID, name, Gender.valueOf(gender), address, contact, Sport.valueOf(sportNamec), sportIDc, getCentreByName(centre));
        this.password = password;
        this.time = time;
        this.price = price;
        this.coach = coach;
    }
    public Student(String ID, String name, String password, Gender gender, String contact, String address){
        super(ID, name, gender, contact, address);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public String getSportNamec() {
        return sport.toString();
    }
    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }
    public Coach getCoach() {
        return coach;
    }

    public void setStudentID(String studentID) {
        this.ID = studentID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setCentre(String centre) {
        this.centre = getCentreByName(centre);
    }
    public void setSportIDc(String sportID) {
        this.sportCode = sportID;
    }
    public void setSportNamec(Sport sportName) {
        this.sport = sportName;
    }
    public void setTime(String time) {
        this.time = time;
    }   
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    private static SportCentre getCentreByName(String centreName){
        for(int i = 0; i < AssignmentCode.allSportCentre.size(); i ++){
            if(AssignmentCode.allSportCentre.get(i).getName().equals(centreName))
                return AssignmentCode.allSportCentre.get(i);
        }
        return null;
    }
    public String[] toArray(){
        String[] details = {ID, name, gender.toString(), sportCode, sport.toString(), contact, address, centre.getName()};
        return details;
    }
    public String toString(){
        return "Student Here:\n" + "Name: " + name + "ID: " + ID;
    }
}
