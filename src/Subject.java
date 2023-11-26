/**
 * File: Subject.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

interface Subject {

    public void regiser(Observer o);
    public void remove(Observer o);
    public void notifyAllObservers();
    
}
