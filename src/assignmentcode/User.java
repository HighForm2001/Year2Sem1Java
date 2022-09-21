/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

public class User {
    protected String name;
    protected String ID;
    protected Gender gender;
    protected String address;
    protected String contact;
    protected Sport sport;
    protected String sportCode;
    protected SportCentre centre;
    User(){
        
    }
    User(String ID, String name, Gender gender, String address, String contact, Sport sport, String sportID, SportCentre centre){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
        this.sport = sport;
        this.sportCode = sportID;
        this.centre = centre;
    }
    User(String ID, String name, Gender gender, String address, String contact){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.contact = contact;
    }
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public Sport getSport(){
        return sport;
    }
    public Gender getGender(){
        return gender;
    }
    public String getAddress(){
        return address;
    }
    public String getContact(){
        return contact;
    }
    public String getSportID(){
        return sportCode;
    }
    public String getCentreName(){
        return centre.getName();
    }
    public SportCentre getCentre(){
        return centre;
    }
}