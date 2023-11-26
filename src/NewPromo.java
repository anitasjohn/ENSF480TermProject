/**
 * File: NewPromo.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */


public class NewPromo implements Observer{
    // Can add more classes for different types of promotions
    private Subject newestPromotion;
    private String promotionString;

    NewPromo(Subject newestP){
        this.newestPromotion = newestP;
        newestPromotion.regiser(this);
    }

    public void update(String currentP){
        this.promotionString = currentP;
        sendToRegisteredUsers();
    }    

    public void sendToRegisteredUsers(){
        System.out.println(promotionString);
        // goes through database all reg users and sends promotion string in email.
    }
}
