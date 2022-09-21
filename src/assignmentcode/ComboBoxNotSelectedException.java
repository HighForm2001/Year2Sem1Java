/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

import java.awt.Component;

/**
 *
 * @author JYChin
 */
public class ComboBoxNotSelectedException extends Exception{
    public ComboBoxNotSelectedException(Component cmpt){
        super(cmpt.getName() + " has not been selected.");
    }
}
