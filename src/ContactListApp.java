import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactListApp {
    public static Input input = new Input();

    public static void main(String[] args) {
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

    public static void trigger() {
        ArrayList list = createArray();
//        Input input = new Input();
        Path contactFilePath = Paths.get("src/contacts.txt");
        System.out.println(createArray());
        //display menu here
        displayMenu();
        int userMenuSelection = input.getInt(1, 5);

        switch (userMenuSelection) {
            case 1 -> viewContacts();
            case 2 -> addNewContact();
//            case 3 -> searchContact();
//            case 4 ->  deleteContact();
//            case 5 -> System.out.println("Good day!");;
            default -> System.out.println("Error. Invalid selection");
        }
        ;


    }
    public static ArrayList createArray() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            List<String> contactListFile = Files.readAllLines(
                    Paths.get("src/contacts.txt")
            );
            for (String text : contactListFile) {
                contacts.add(new Contact(text));
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
        System.out.println("Enter new contact name: ");
        String contactName = input.getString();
        System.out.println("Enter new contact phone number: ");
        int contactNumber = input.getInt();
        String contactPhone = String.valueOf(contactNumber);
        String firstThree = contactPhone.substring(0,3);
        System.out.println(firstThree);
    }

//ending curly brace
}
