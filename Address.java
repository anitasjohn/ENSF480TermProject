/**
 * File: Address.java
 * Created By: Group 11 (L03 B03)
 * Submission: November 29, 2023
 */

public class Address {

    private String streetAddress;
    private String postalCode;
    private String city;
    private String country;

    Address(String street, String postal, String cityString, String countryString){
        this.streetAddress = street;
        this.postalCode = postal;
        this.city = cityString;
        this.country = countryString;
    }

    public String getAddress(){
        String addressString = streetAddress + ", " + postalCode + ", " + city + ", " + country + "\n";
        return addressString;
    }
    
}
