package com.AddressBook;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Program.");
    }
}

class ContactPerson{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phoneNumber;

    //Default Constructor
    public ContactPerson(){

    }

    //Parameterized Constructor
    public ContactPerson(String firstName, String lastName, String address, String city, String state, int zip, int phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    //getter and setter methods
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return  address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setZip(int zip){
        this.zip = zip;
    }

    public int getZip(){
        return zip;
    }

    public void setPhoneNumber(){
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "ContactPerson ( " +
                " First Name : " + firstName + "," +
                " LastName : " + lastName + "," +
                " Address : " + address + "," +
                " City : " + city + "," +
                " State : " + state + "," +
                " Zip : " + zip + "," +
                " PhoneNumber : " + phoneNumber +
                ")";
    }

}

