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
            System.out.println("Enter 1 to ADD new contact.\nEnter 2 to EDIT existing contact.\nEnter 3 to DELETE existing contact.\nEnter 0 to EXIT.");

            int userChoice = userInput.nextInt();
            userInput.nextLine();

            switch (userChoice){
                case 1 :
                    addContact(addressBook, userInput);
                    System.out.println(addressBook);
                    break;
                case 2 :
                    editContact(addressBook, userInput);
                    System.out.println(addressBook);
                    break;
                case 3 :
                    deleteContact(addressBook,userInput);
                    System.out.println(addressBook);
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

    private static boolean checkContactExistance(Map<String, ContactPerson> addressBook, String name) {
        boolean isPresent = addressBook.keySet().stream().noneMatch(string -> string.equals(name));
        return  isPresent;
    }

    private static void deleteContact(Map<String, ContactPerson> addressBook, Scanner userInput) {
        System.out.println("\nEnter Contact Name : ");
        String contactName = userInput.nextLine();
        boolean contactPresent = checkContactExistance(addressBook, contactName);

        if(contactPresent == true) {
            System.out.println("Contact doesn't exist.\n");
        }
        else{
            addressBook.remove(contactName);
            System.out.println("Contact Deleted!\n");
        }

    }

    private static void editContact(Map<String, ContactPerson> addressBook, Scanner userInput) {
        System.out.println("Enter Contact Name : ");
        String contactName = userInput.nextLine();
        ContactPerson contactToEdit = addressBook.get(contactName);
        boolean contactPresent = checkContactExistance(addressBook, contactName);

        if(contactPresent == true) {
            System.out.println("Contact doesn't exist.\n");
        }
        else{
            ContactPerson contactPerson = editContactDetail(contactToEdit, contactName, userInput);
            addressBook.put(contactName, contactPerson);
            System.out.println("Contact Edited!\n");
        }
    }

    private static ContactPerson editContactDetail(ContactPerson contactPerson, String contactName, Scanner userInput) {
        boolean exitEdit = false;

        while(!exitEdit){
            System.out.println("Enter 1 to edit ADDRESS\nEnter 2 to edit CITY\nEnter 3 to edit STATE\nEnter 4 to edit ZIP\nEnter 5 to edit PHONE NUMBER\nEnter 0 to EXIT.");

            int editChoice = userInput.nextInt();
            userInput.nextLine();

            switch (editChoice){
                case 1:
                    System.out.println("Enter the new address");
                    String newAddress = userInput.nextLine();
                    contactPerson.setAddress(newAddress);
                    break;
                case 2:
                    System.out.println("Enter the new city");
                    String newCity = userInput.nextLine();
                    contactPerson.setCity(newCity);
                    break;
                case 3:
                    System.out.println("Enter the new state");
                    String newState = userInput.nextLine();
                    contactPerson.setState(newState);
                    break;
                case 4:
                    System.out.println("Enter the new zip");
                    int newZip = userInput.nextInt();
                    contactPerson.setZip(newZip);
                    break;
                case 5:
                    System.out.println("Enter the new phone number");
                    long newPhoneNumber = userInput.nextLong();
                    contactPerson.setPhoneNumber(newPhoneNumber);
                    break;
                case 0:
                    exitEdit = true;
                    break;
                default:
                    System.out.println("Invalid Input.");
            }
        }

        return contactPerson;
    }

    private static void addContact(Map<String, ContactPerson> addressBook, Scanner userInput) {
        System.out.println("Enter number of contacts you want to add :");
        int noOfContacts = userInput.nextInt();

        for (int i = 1; i <= noOfContacts; i++) {
            userInput.nextLine();
            System.out.println("\nEnter detail for contact : " + i);
            ContactPerson contactPerson = createContact(userInput);
            boolean contactPresent = checkContactExistance(addressBook, contactPerson.getName());

            if(contactPresent == true) {
                addressBook.put(contactPerson.getName(), contactPerson);
                System.out.println("Contacts Added!\n");
            }
            else{
                System.out.println("Contact already exists! Contact cannot be added to address book\n");
            }
        }

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
        long phoneNumber = userInput.nextLong();

        String name = firstName + " " +lastName;
        return new ContactPerson(name, firstName, lastName, address, city, state, zip, phoneNumber);
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

