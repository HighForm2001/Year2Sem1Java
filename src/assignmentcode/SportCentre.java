/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

/**
 *
 * @author JYChin
 */
public class SportCentre {
    private String ID;
    private String name;
    private String address;
    public SportCentre(String ID, String name, String address){
        this.ID = ID;
        this.name = name;
        this.address = address;
    }
    public String getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String toString(){
        return "ID: " + ID + "\nName: " + name + "\nAddress: " + address;
    }
}
