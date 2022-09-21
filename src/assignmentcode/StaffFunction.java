/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentcode;

import java.util.Comparator;
public  class StaffFunction {
    static class IDComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2){
            return o1.getID().compareTo(o2.getID());
        }
    }
    static class NameComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2){
            return o1.getName().compareTo(o2.getName());
        }
    }
    static class SportIDComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2){
            return o1.getSportID().compareTo(o2.getSportID());
        }
    }
    static class SportCentreIDComparator implements Comparator<User>{
        @Override
        public int compare(User o1, User o2){
            return o1.getCentre().getID().compareTo(o2.getCentre().getID());
        }
    }
    static class RatingComparator implements Comparator<Coach>{
        @Override
        public int compare(Coach c1, Coach c2){
            return Integer.compare(c1.getRating(), c2.getRating());
        }
    }
    static class SalaryComparator implements Comparator<Coach>{
        @Override
        public int compare(Coach c1, Coach c2){
            return Integer.compare(c1.getHourlyRate(),c2.getHourlyRate());
        }
    }
}
