/**
 * File: Login.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

// NOT SINGLETON
// Can possibly convert to Singleton

public class Login {
    private String enteredEmail;
    private String enteredPw;
    private Check loginStrategy;

    public Login(String email, String pw){
        this.enteredEmail = email;
        this.enteredPw = pw;
    }

    public void setLoginStrategy(Check strategy){
        this.loginStrategy = strategy;
    }

    public boolean performStartegy(){
        return loginStrategy.validate(enteredEmail, enteredPw);
    }



}
