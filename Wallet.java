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

    Wallet(String cardNum, String cvcString, String expiration, int amount){
        this.cardNumber = cardNum;
        this.cvc = cvcString;
        this.expDate = expiration;
        this.balance = amount;
    }

    public boolean checkBalance(int price){
        if (this.balance < price){
            return false;
        }

        return true;
    }
    
}
