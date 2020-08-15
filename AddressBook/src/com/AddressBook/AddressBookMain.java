package com.AddressBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Map<String, ContactPerson> addressBook = new HashMap<>();

        System.out.println("Welcome To Address Book Program.");

        operatingAddressBook(addressBook, userInput);

    }

    private static void operatingAddressBook(Map<String, ContactPerson> addressBook, Scanner userInput) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Enter 1 to ADD new contact.\nEnter 0 to EXIT.");
            int userChoice = userInput.nextInt();
            userInput.nextLine();

            switch (userChoice){
                case 1 :
                    addContact(addressBook, userInput);
                    break;
                case 0 :
                    exit = true;
                    System.out.println("BYE!");
                    break;
                default :
                    System.out.println("Inalid input!");
            }
        }
    }

    private static void addContact(Map<String, ContactPerson> addressBook, Scanner userInput) {
        ContactPerson contactPerson = createContact(userInput);
        addressBook.put(contactPerson.getName(),contactPerson);
        System.out.println(addressBook);
    }

    private static ContactPerson createContact(Scanner userInput) {
        System.out.println("Enter First Name : ");
        String firstName = userInput.nextLine();

        System.out.println("Enter Last Name : ");
        String lastName = userInput.nextLine();

        System.out.println("Enter Address : ");
        String address = userInput.nextLine();

        System.out.println("Enter City : ");
        String city = userInput.nextLine();

        System.out.println("Enter State : ");
        String state = userInput.nextLine();

        System.out.println("Enter Zip : ");
        int zip = userInput.nextInt();

        System.out.println("Enter Phone Number : ");
        int phoneNumber = userInput.nextInt();

        String name = firstName + " " +lastName;
        return new ContactPerson(name, firstName, lastName, address,city,state,zip,phoneNumber);
    }


}

class ContactPerson{
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
    public ContactPerson(String name, String firstName, String lastName, String address, String city, String state, int zip, int phoneNumber){
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
        return " Detail : ( " +
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

