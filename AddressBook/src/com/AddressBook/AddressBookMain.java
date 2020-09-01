package com.AddressBook;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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
            System.out.println("Enter 1 to ADD new contact.\nEnter 2 to EDIT existing contact.\nEnter 3 to DELETE existing contact.\nEnter 4 to sort contact.\nEnter 5 to view contact.\nnEnter 5 to search contact.\nEnter 0 to EXIT.");

            int userChoice = userInput.nextInt();
            userInput.nextLine();

            switch (userChoice){
                case 1 :
                    addContact(addressBook, userInput);
                    break;
                case 2 :
                    editContact(addressBook, userInput);
                    break;
                case 3 :
                    deleteContact(addressBook,userInput);
                    break;
                case 4:
                    sortContacts(addressBook, userInput);
                    break;
                case 5:
                    viewContacts(addressBook, userInput);
                    break;
                case 6:
                    searchContact(addressBook, userInput);
                    break;
                case 0 :
                    exit = true;
                    System.out.println("BYE!");
                    break;
                default :
                    System.out.println("Invalid input!");
            }
        }
    }

    private static void searchContact(Map<String, ContactPerson> addressBook, Scanner userInput) {
        boolean exitSearch = false;
        while (!exitSearch){
            System.out.println("Enter 1 to search contacts by Person's City\nEnter 2 to search contacts by Person's State\nEnter 0 to exit viewing");
            int searchChoice = userInput.nextInt();
            userInput.nextLine();

            switch (searchChoice){
                case 1:
                    Map<ContactPerson, String> cityDict = viewContactsByCity(addressBook);
                    System.out.println("Enter City :");
                    String city = userInput.nextLine();
                    searchByCity(cityDict,city);
                    break;
                case 2:
                    Map<ContactPerson, String> stateDict = viewContactsByState(addressBook);
                    System.out.println("Enter State :");
                    String state = userInput.nextLine();
                    searchByState(stateDict,state);
                    break;
                case 0:
                    exitSearch = true;
                    break;
                default:
                    System.out.println("Invalid Input");

            }
        }
    }

    private static void searchByState(Map<ContactPerson, String> stateDict, String state) {
        stateDict.keySet()
                .stream()
                .filter(contact -> contact.getState().equals(state))
                .forEach(System.out::println);
    }

    private static void searchByCity(Map<ContactPerson, String> cityDict, String city) {
        cityDict.keySet()
                .stream()
                .filter(contact -> contact.getCity().equals(city))
                .forEach(System.out::println);
    }

    private static void viewContacts(Map<String, ContactPerson> addressBook, Scanner userInput) {
        boolean exitView = false;

        while(!exitView){
            System.out.println("Enter 1 to view contacts by Person's City\nEnter 2 to view contacts by Person's State\nEnter 0 to exit viewing");
            int viewChoice = userInput.nextInt();
            userInput.nextLine();

            switch (viewChoice){
                case 1 :
                    Map<ContactPerson, String> cityDict = viewContactsByCity(addressBook);
                    cityDict.forEach((K,V)-> {
                        System.out.println(V + ":" + K);
                    });
                    break;
                case 2:
                    Map<ContactPerson, String> stateDict = viewContactsByState(addressBook);
                    stateDict.forEach((K,V)->{
                        System.out.println(V +":"+K);
                    });

                    break;
                case 0:
                    exitView = true;
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    private static Map<ContactPerson, String> viewContactsByState(Map<String, ContactPerson> addressBook) {
        Map<ContactPerson, String> stateDictionary = addressBook.values()
                .stream()
                .collect(Collectors.toMap(Function.identity(),ContactPerson::getState,
                        (e1, e2) -> e1,
                        HashMap::new));
        return stateDictionary;

    }

    private static Map<ContactPerson, String> viewContactsByCity(Map<String, ContactPerson> addressBook) {
            Map<ContactPerson, String> cityDictionary = addressBook.values()
                    .stream()
                    .collect(Collectors.toMap(Function.identity(),ContactPerson::getCity,
                            (e1, e2) -> e1,
                            HashMap::new));
            return cityDictionary;

    }

    private static void sortContacts(Map<String, ContactPerson> addressBook, Scanner userInput) {
        boolean exitSort = false;

        while(!exitSort){
            System.out.println("Enter 1 to sort contacts by Person's Name\nEnter 2 to sort contacts by Person's City\nEnter 3 to sort contacts by Person's State\nEnter 4 to sort contacts by Person's Zip\nEnter 0 to exit sorting");

            int sortChoice = userInput.nextInt();
            userInput.nextLine();

            switch (sortChoice){
                case 1:
                    sortByPersonName(addressBook);
                    break;
                case 2:
                    sortContacts(addressBook, Comparator.comparing(ContactPerson::getCity));
                    break;
                case 3:
                    sortContacts(addressBook, Comparator.comparing(ContactPerson::getState));
                    break;
                case 4:
                    sortContacts(addressBook, Comparator.comparing(ContactPerson::getZip));
                    break;
                case 0:
                    exitSort = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }

    private static void sortContacts(Map<String, ContactPerson> addressBook, Comparator<ContactPerson> comparing) {
        Map<String, ContactPerson> sortedContacts = addressBook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(comparing))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(detail, value)->detail, LinkedHashMap::new));

        sortedContacts.forEach((name,contactPerson)->{
            System.out.println(name);
            System.out.println(contactPerson);
        });
    }

    private static void sortByPersonName(Map<String, ContactPerson> addressBook) {
        Map<String, ContactPerson> sortedContacts = addressBook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(detail,value)-> detail, LinkedHashMap::new));

        sortedContacts.forEach((name,contactPerson)->{
            System.out.println(name);
            System.out.println(contactPerson);
        });
    }

    private static boolean checkContactExistent(Map<String, ContactPerson> addressBook, String name) {
        return  addressBook.keySet().stream().noneMatch(string -> string.equals(name));
    }

    private static void deleteContact(Map<String, ContactPerson> addressBook, Scanner userInput) {
        System.out.println("\nEnter Contact Name : ");
        String contactName = userInput.nextLine();
        boolean contactPresent = checkContactExistent(addressBook, contactName);

        if(contactPresent) {
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
        boolean contactPresent = checkContactExistent(addressBook, contactName);

        if(contactPresent) {
            System.out.println("Contact doesn't exist.\n");
        }
        else{
            ContactPerson contactPerson = editContactDetail(contactToEdit, userInput);
            addressBook.put(contactName, contactPerson);
            System.out.println("Contact Edited!\n");
        }
    }

    private static ContactPerson editContactDetail(ContactPerson contactPerson, Scanner userInput) {
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
            boolean contactPresent = checkContactExistent(addressBook, contactPerson.getName());

            if(contactPresent) {
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


