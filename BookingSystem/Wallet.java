package BookingSystem;
/**
 * File: Wallet.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

public class Wallet {
    // check verification for enough funds 
    // check balance    
    // card numbers, expiration date, and balance, keep track of funds 
    private String cardNumber;
    private String cvc;
    private String expDate;
    private int balance;

    public Wallet(String cardNum, String cvcString, String expiration, int amount){
        this.cardNumber = cardNum;
        this.cvc = cvcString;
        this.expDate = expiration;
        this.balance = amount;
    }

    public boolean checkSufficientFunds(int price){
        if (this.balance < price){
            return false;
        }

        return true;
    }

    public void setCardNumber(String cardNum){
        this.cardNumber = cardNum;
    }

    public void setCardExpDate(String date){
        this.expDate = date;
    }

    public void setCardCvc(String cvcString){
        this.cvc = cvcString;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public int getBalance() {
        return this.balance;
    }
    
    public String getCardNumber(){
        return this.cardNumber;
    }

    public String getCardCvc(){
        return this.cvc;
    }
    
    public String getCardExpDate(){
        return this.expDate;
    }
    
}