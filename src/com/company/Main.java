package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String msg = ConsoleColors.YELLOW + "Address Book is Empty" + ConsoleColors.RESET;

    public static AddressBook book = new AddressBook();

    public static class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        // public static final String CYAN = "\033[0;36m";    // CYAN
        //public static final String WHITE = "\033[0;37m";   // WHITE


    }

    public static void main(String[] args){
        System.out.println(ConsoleColors.BLUE + "Welcome to Command Line AddressBook Application" + ConsoleColors.RESET);
        mainMenu();
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);

      try {
            boolean quit = false;
            while (!quit) {
                menu();
                System.out.println("\nPlease Enter Your Choice:");
                int action = sc.nextInt();
                sc.nextLine();
                switch (action) {
                    case 0:
                        System.out.println(ConsoleColors.GREEN + "Address Book console App quiting.." + ConsoleColors.RESET);
                        quit = true;
                        break;
                    case 1:
                        if (book.numContacts() < 50) {
                            addContact();
                        }
                        break;
                    case 2:
                        if (book.numContacts() > 0) {
                            System.out.println("You have following Person Details in your Address Book");
                            book.printContacts();
                            book.editContactDetail();
                        } else {
                            System.out.println(msg);
                        }
                        break;
                    case 3:
                        if (book.numContacts() > 0) {
                            book.printContacts();
                            book.deleteContact();
                        } else {
                            System.out.println(msg);
                        }
                        break;
                    case 4:
                        int countAZ = book.numContacts();
                        if (countAZ == 0) {
                            System.out.println(msg);
                        } else if (countAZ == 1) {
                            System.out.println("You Have Only 1 Contact in Address Book Can't Sort ");
                        } else {
                            sortAlphabetic();
                        }
                        break;
                    case 5:
                        int countZip = book.numContacts();
                        if (countZip == 0) {
                            System.out.println(msg);
                        } else if (countZip == 1) {
                            System.out.println("You Have Only 1 Contact in Address Book Can't Sort ");
                        } else {
                            sortZip();
                        }
                        break;
                    case 6:
                        int count = book.numContacts();
                        if (count == 0) {
                            System.out.println(msg);
                        } else
                            System.out.println(ConsoleColors.BLUE + "You have " + count + " contacts in Address book" + ConsoleColors.RESET);
                        break;
                    case 7:
                        if (book.numContacts() == 0) {
                            System.out.println(msg);
                        }
                        book.printContacts();
                        break;
                    case 8:
                        fileWrite();
                        break;
                    case 9:
                        menu();
                        break;
                    default:
                        System.out.println("Please Give Proper Input");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Please Give Proper Input");
            mainMenu();
        }
    }


    public static void menu() {
        System.out.println(ConsoleColors.PURPLE + "MENU\n" + ConsoleColors.RESET + ConsoleColors.RED + "0 - To quit\n" + ConsoleColors.RESET +
                "1 - To Add new person to address book\n" +
                "2 - To Edit person information\n" +
                "3 - To delete person information from Address Book\n" +
                "4 - To sort person alphabetically\n" +
                "5 - To sort person from zip code\n" +
                "6 - To print Number of entries in the Address Book\n" +
                "7 - To print all the entries from the Address Book\n" +
                "8 - To save this Address Book as a text file\n" +
                "9 - To print menu again");
    }

    public static void addContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Person Details in following manner");
        try {
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
            System.out.println(ConsoleColors.GREEN + "Person Detail Added" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "you entered String value for int Value Retry" + ConsoleColors.RESET);
        }
    }

    public static void sortZip() {
        book.sortZip();
    }

    public static void sortAlphabetic() {
        book.sortAlphabetic();
    }

    public static void fileWrite() throws IOException {
        if (book.numContacts() == 0) {
            System.out.println(msg + ConsoleColors.YELLOW + " Couldn't Save " + ConsoleColors.RESET);
        } else {
            book.fileSave();
        }

    }
}