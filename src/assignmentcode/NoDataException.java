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
public class NoDataException extends Exception{
    public NoDataException(String text){
        super("No data for this group: " + text);
    }
}
