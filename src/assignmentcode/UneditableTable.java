/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

import javax.swing.JTable;

/**
 *
 * @author JYChin
 */
public class UneditableTable extends JTable{
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
    public UneditableTable(String[][] content, String[] title){
        super(content, title);
    }
}
