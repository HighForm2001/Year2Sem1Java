/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

public enum Gender {
    MALE("Male"),FEMALE("Female"),OTHER("Other");
    private final String value;
    private Gender(String x){
        value = x;
    }
    public String getValue(){
        return value;
    }
}
