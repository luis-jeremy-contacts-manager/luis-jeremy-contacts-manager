import util.Input;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ContactListApp {


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
        Input input = new Input();
        Path contactFilePath = Paths.get("src/contacts.txt");
        displayMenu();
        int userMenuSelection = input.getInt(1, 5);

        switch(userMenuSelection) {
            case 1 -> viewContacts();
            case 2 -> addNewContact();
            case 3 -> searchContact();
            case 4 ->  deleteContact();
            case 5 -> System.out.println("Good day!");;
            default -> System.out.println("Error. Invalid selection");
        };


    }

    public static ArrayList viewContacts() {
        try {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
