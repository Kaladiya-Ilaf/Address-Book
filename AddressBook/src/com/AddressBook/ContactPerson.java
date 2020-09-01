package com.AddressBook;

public class ContactPerson {
    private String name;
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
    public ContactPerson(String name, String firstName, String lastName, String address, String city, String state, int zip, long phoneNumber){
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    //getter and setter methods
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName() {
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

    public void setPhoneNumber(long newPhoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public long getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "\nDetail : " +
                " \nFirst Name : " + firstName +
                " \nLastName : " + lastName +
                " \nAddress : " + address +
                " \nCity : " + city +
                " \nState : " + state +
                " \nZip : " + zip +
                " \nPhoneNumber : " + phoneNumber + "\n";
    }
}
