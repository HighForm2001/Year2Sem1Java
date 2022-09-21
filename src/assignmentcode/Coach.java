package assignmentcode;
public class Coach extends User{
    private String dateJoin;
    private String dateTerminated;
    private int hourlyRate;
    private int rating;
    private int mondayClass;
    private int tuesdayClass;
    private int wednesdayClass;
    private int thursdayClass;
    private int fridayClass;
    private int saturdayClass;
    private int sundayClass;
    private int RatedStudentNumber;
    
    public Coach(){
        super();
    }
    public Coach(String coachID, String Name, Gender gender, String dateJoin, String dateTerminated, String contact, String address, int hourlyRate, String sportCode, Sport sportName, int rating, SportCentre centre,
            int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday, int studentNumber) {
            super(coachID, Name, gender, contact, address, sportName, sportCode, centre);
            this.dateJoin = dateJoin;
            this.dateTerminated = dateTerminated;
            this.hourlyRate = hourlyRate;
            this.rating = rating;
            mondayClass = monday;
            tuesdayClass = tuesday;
            wednesdayClass = wednesday;
            thursdayClass = thursday;
            fridayClass = friday;
            saturdayClass = saturday;
            sundayClass = sunday;
            this.RatedStudentNumber = studentNumber;
    }       
    public Coach(String coachID, String Name, Gender gender, String dateJoin, String dateTerminated, String contact, String address, int hourlyRate, String sportCode, Sport sportName, int rating, SportCentre centre,
            int slots, int studentNumber) {
            super(coachID, Name, gender, contact, address, sportName, sportCode, centre);
            this.dateJoin = dateJoin;
            this.dateTerminated = dateTerminated;
            this.hourlyRate = hourlyRate;
            this.rating = rating;
            mondayClass = slots;
            tuesdayClass = slots;
            wednesdayClass = slots;
            thursdayClass = slots;
            fridayClass = slots;
            saturdayClass = slots;
            sundayClass = slots;
            this.RatedStudentNumber = studentNumber;
    }   
    public String getDateJoin() {
        return dateJoin;
    }
    public String getDateTerminated() {
        return dateTerminated;
    }
    public int getHourlyRate() {
        return hourlyRate;
    }
    public int getRating() {
        return rating;
    }

    public int getMondayClass() {
        return mondayClass;
    }

    public int getTuesdayClass() {
        return tuesdayClass;
    }

    public int getWednesdayClass() {
        return wednesdayClass;
    }

    public int getThursdayClass() {
        return thursdayClass;
    }

    public int getFridayClass() {
        return fridayClass;
    }

    public int getSaturdayClass() {
        return saturdayClass;
    }

    public int getSundayClass() {
        return sundayClass;
    }
    public boolean bookClass(String day){
        if(day.equals("Monday")){
            if(mondayClass == 0){
                return false;
            }else
                mondayClass --;
        }else if(day.equals("Tuesday")){
            if(tuesdayClass ==0){
                return false;
            }
            else
                tuesdayClass --;
        }else if(day.equals("Wednesday")){
            if(wednesdayClass == 0){
                return false;
            }else
                wednesdayClass --;
        }else if(day.equals("Thursday")){
            if(thursdayClass == 0){
                return false;
            }else
                thursdayClass --;
        }else if(day.equals("Friday")){
            if(fridayClass == 0){
                
            }else
                fridayClass --;
        }else if(day.equals("Saturday")){
            if(saturdayClass == 0){
                return false;
            }else
                saturdayClass --;
        }else{
            if(sundayClass == 0){
                return false;
            }else
                sundayClass --;
        }
        return true;
    }

    public void setCoachID(String coachID) {
        this.ID = coachID;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setDateJoin(String dateJoin) {
        this.dateJoin = dateJoin;
    }
    public void setDateTerminated(String dateTerminated) {
        this.dateTerminated = dateTerminated;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public void setSportCode(String sportCode) {
        this.sportCode = sportCode;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setCentre(SportCentre centre){
        this.centre = centre;
    }
    public String toString(){
        return ID + name + centre + gender;
    }
    public String[] toArray(){
        String[] details = {ID, name, gender.toString(), dateJoin, dateTerminated, contact, address, Integer.toString(hourlyRate), sportCode, sport.toString(), Integer.toString(rating), centre.getName(), centre.getID()};
        return details;
    }
    public int getRatedStudentNumber(){
        return RatedStudentNumber;
    }
    public void addStudent(){
        RatedStudentNumber ++;
    }
}
