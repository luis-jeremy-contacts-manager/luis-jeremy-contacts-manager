package util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;


    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }

    public boolean yesNo() {
        return this.getString().trim().toLowerCase().startsWith("y");

    }

    public int getInt(int min, int max) {
        int userInput = this.getInt();

            if (userInput >= min && userInput <= max) {
                return userInput;

            } else {

                System.out.println("Invalid input. Please enter a valid number.");
                return this.getInt(min, max);
            }

    }

    public int getInt() {
        try {
            return Integer.parseInt(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a whole number");
            return this.getInt();
        }
    }

    public double getDouble() {
        try {
            return Double.parseDouble(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a number");
            return this.getDouble();
        }
    }
    public double getDouble(double min, double max) {
        double userInput = this.getDouble();

        if (userInput >= min && userInput <= max) {
            return userInput;

        } else {

            System.out.println("Invalid input. Please enter a valid number.");
            return this.getDouble(min, max);
        }
    }



}

