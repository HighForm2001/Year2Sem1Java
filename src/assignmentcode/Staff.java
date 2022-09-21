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
class Staff {
    private String ID;
    private String password;
    
    public Staff(String ID, String password){
        this.ID = ID;
        this.password = password;
    }
    public boolean comparePassword(String password){
        return this.password.equals(password);
    }
    public boolean compareID(String id){
        return this.ID.equals(id);
    }
    @Override
    public String toString(){
        return ID + password;
    }
}
