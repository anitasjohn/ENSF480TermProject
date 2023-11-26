/**
 * File: Promos.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

import java.util.ArrayList;

public class Promos implements Subject{

    private ArrayList<Observer> observers;
    private String promotionDescription;

    Promos(String promotionString){
        this.promotionDescription = promotionString;
        this.observers = new ArrayList<Observer>();
    }

    public void regiser(Observer o){
        this.observers.add(o);
        o.update(promotionDescription);
    }

    public void remove(Observer o){
        this.observers.remove(o);
    }

    public void notifyAllObservers(){
        for( Observer o : this.observers){
            o.update(promotionDescription);
        }
    }

    public void setPromotion(String promo){
        this.promotionDescription = promo;
        notifyAllObservers();
    }
}