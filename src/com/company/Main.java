package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE


    }

    public static AddressBook book = new AddressBook();

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE + "Welcome to Command Line AddressBook Application" + ConsoleColors.RESET);
        boolean quit = false;

        while (!quit) {
            menu();
            System.out.println("\nPLease enter choice");
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Application quiting..");
                    quit = true;
                    break;
                case 1:
                    if (book.numContacts() < 50) {
                        adddetail();
                    }
                    break;
                case 2:
                    if (book.numContacts() > 0) {
                        System.out.println("Please Enter First name you want to edit");
                        String name = sc.nextLine();
                        book.editdetail(name);
                    } else {
                        System.out.println("Address Book is empty");
                    }
                    break;
                case 3:
                    System.out.println("What is the name of the contact you want to delete?");
                    String searchName = sc.next();
                    book.deleteContact(searchName);
                    break;
                case 4:
                    sortAlphabetic();
                    break;
                case 5:
                    sortZip();
                    break;
                case 6:
                    int count = book.numContacts();
                    if (count == 0) {
                        System.out.println("Address Book is Empty");
                    } else
                        System.out.println("You have " + count + " contacts in Address book");
                    break;
                case 7:
                    book.printContacts();
                    break;
                case 8:
                    filewrite();
                    break;
                case 9:
                    menu();
                    break;
            }
        }


    }

    public static void menu() {
        System.out.println(ConsoleColors.RED + "0 - To quit\n" + ConsoleColors.RESET +
                "1 - To Add new person to address book\n" +
                "2 - To Edit person information\n" +
                "3 - To delete person information from addressbook\n" +
                "4 - To sort person alphabetically\n" +
                "5 - To sort person from zip code\n" +
                "6 - To print Number of entries in the addressbook\n" +
                "7 - To print all the entries from the addressbook\n" +
                "8 - To save this addressbook as a text file\n" +
                "9 - To print menu again");
    }

    public static void adddetail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Person Details in following manner");

        System.out.println("Please Enter First name");
        String firstname = sc.next();
        System.out.println("Please Enter Last name");
        String lastname = sc.next();
        System.out.println("Please Enter Address");
        String address = sc.next();
        System.out.println("Please Enter City");
        String city = sc.next();
        System.out.println("Please Enter State");
        String state = sc.next();
        System.out.println("Please Enter Zip");
        int zip = sc.nextInt();
        System.out.println("Please Enter Phone Number");
        String phoneNo = sc.next();
        book.addContact(new Contact(firstname, lastname, address, city, state, zip, phoneNo));

    }

    public static void sortZip() {
        book.sortZip();
    }

    public static void sortAlphabetic() {
        book.sortAlphabatic();
    }
    public static void filewrite() throws IOException {
        book.file();
    }
}