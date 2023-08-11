import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactListApp {
    public static Input input = new Input();
    public static Path contactFilePath = Paths.get("src/contacts.txt");
    public static void main(String[] args) throws IOException {
        trigger();
    }

    public static void displayMenu() {
        System.out.printf("""
                |1.| View contacts.
                |2.| Add a new contact.
                |3.| Search a contact by name.
                |4.| Delete an existing contact.
                |5.| Exit.
                Enter an option (1, 2, 3, 4 or 5):
                """
        );
    }

    public static void trigger() throws IOException {
//        ArrayList list = createArray();
        //display menu here
        displayMenu();
        int userMenuSelection = input.getInt(1, 5);

        switch (userMenuSelection) {
            case 1 -> viewContacts();
            case 2 -> addNewContact();
            case 3 -> searchContact();
            case 4 ->  deleteContact();
            case 5 -> System.out.println("Good day!");
            default -> System.out.println("Error. Invalid selection");
        }
    }

    public static ArrayList createArray(String newName, String newNumber) {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            List<String> contactListFile = Files.readAllLines(
                    Paths.get("src/contacts.txt")
            );
            for (String text : contactListFile) {
                String[] result = text.split(" ");
                String name = result[0];
                String number = result[1] + result[2];
                contacts.add(new Contact(name, number));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(contacts);
        return contacts;
    }
    public
    static ArrayList<Contact>  createArray() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            List<String> contactListFile = Files.readAllLines(
                    Paths.get("src/contacts.txt")
            );
            for (String text : contactListFile) {
                String[] result = text.split(" ");
                String name = result[0];
                String number = result[1] + result[2];
                contacts.add(new Contact(name, number));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }


    public static void viewContacts() {
        try {
            List<String> lineOfTexts = Files.readAllLines(
                    Paths.get("src/contacts.txt")
            );
            for (String text : lineOfTexts) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addNewContact() {
        try {
            System.out.println("Enter new contact name: ");
            String contactName = input.getString();
            String newContactPhoneNumber = validatePhoneLength();
            createArray(contactName, newContactPhoneNumber);
//            for(Contact contact : createArray()){
//                System.out.println(contact.getName());
//                System.out.println(contact.getNumber());
//            }
            String newContact = contactName + " " + newContactPhoneNumber;

            Files.write(contactFilePath, Collections.singletonList(newContact), StandardOpenOption.APPEND);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String validatePhoneLength() {
        System.out.println("Enter new contact phone number: ");
        int contactNumber = input.getInt();
        String contactPhone = String.valueOf(contactNumber);
        String formattedPhone = "";
        if (contactPhone.length() == 10) {
            String firstThree = contactPhone.substring(0, 3);
            String secondThree = contactPhone.substring(3, 6);
            String lastFour = contactPhone.substring(6, 10);
            formattedPhone = "(" + firstThree + ") " + secondThree + "-" + lastFour;
            return formattedPhone;
        } else if (contactPhone.length() == 7) {
            String firstThree = contactPhone.substring(0, 3);
            String lastFour = contactPhone.substring(3, 7);
            formattedPhone = firstThree + "-" + lastFour;
            return formattedPhone;

        } else {
            System.out.println("Phone number has incorrect number of digits.");
            return validatePhoneLength();
        }

    }

    public static String searchContact() {
        System.out.println("Enter contact name");
        String searchQuery = input.getString();
        String request = "";
        try {
            List<String> lineOfTexts = Files.readAllLines(
                    Paths.get("src/contacts.txt")
            );
            for (String text : lineOfTexts) {
                if (text.contains(searchQuery)){
                    request = text;
                }
            }
                if (request.length() == 0) {
                    System.out.println("No contact was found.");
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(request);
        return request;
    }

//    public static void deleteContact() {
//        String contactToDelete = searchContact();
//        System.out.println("Are you sure you want to delete contact? (Y/N)");
//        boolean userInput = input.yesNo();
//        ArrayList<Contact> contacts =  createArray();
//        if(userInput){
//            for(Contact contact : createArray()) {
//                String name = contact.getName();
//           contacts.removeIf(Contact -> contact.getName().equalsIgnoreCase(name));
//                System.out.println(contact.getName());
//
//            }
//        }
//
//
//    }

    public static void deleteContact() throws IOException {
        ArrayList<Contact> contacts =  createArray();
        System.out.println("Enter the contact name to delete");
        String contactToDelete = input.getString();
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(contactToDelete)) {
                contacts.remove(contact);
                break;
            }
        }
        System.out.println(contacts);
       updateTxtFile(contacts);
    }

    static void updateTxtFile(ArrayList<Contact> contacts) throws IOException {
        ArrayList<String> stringContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            String stringContact = contact.getName() + " " + contact.getNumber();
            stringContacts.add(stringContact);
            Files.write(contactFilePath, stringContacts, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

        }
    }

//ending curly brace
}
