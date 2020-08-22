package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    Scanner sc = new Scanner(System.in);
    public static class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN


    }

    private final ArrayList<Contact> friends;

    //CONSTRUCTOR
    public AddressBook() {
        friends = new ArrayList<>();
    }

    //TO ADD NEW CONTACT IN THE CONTACT ARRAYLIST
    public void addContact(Contact c) {
        friends.add(c);
    }

    //TO PRINT ALL THE CONTACTS
    public void printContacts() {
        for (Contact friend : friends) System.out.println(friend);
    }

    //METHOD TO RETURN SIZE OF CONTACT ARRAYLIST
    public int numContacts() {
        return friends.size();
    }

    //METHOD TO CHECK INDEX OF FIRSTNAME
    private int haveContact(String s) {
        for (int i = 0; i < friends.size(); i++)
            if (friends.get(i).getFirstname().equals(s))
                return i;
        return -1;
    }

    //METHOD TO CHECK INDEX LASTNAME
    private int haveContactLast(String s) {
        for (int i = 0; i < friends.size(); i++)
            if (friends.get(i).getLastname().equals(s))
                return i;
        return -1;
    }

    //METHOD TO CHECK AND DELETE A CONTACT FROM CONTACT ARRAYLIST
    public void deleteContact() {

            System.out.println("What is the First Name of the contact you want to delete?");
            String searchName = sc.next();
            int firstNameDel = haveContact(searchName);
            int lastNameDel;
            String lNameDel = "";
            if (firstNameDel >= 0) {
                System.out.println("What is the Last Name of the contact you want to delete?");
                lNameDel = sc.nextLine();
                lastNameDel = haveContactLast(lNameDel);
                if (lastNameDel >= 0) {
                    friends.remove(firstNameDel);
                    System.out.println(searchName + " " + lNameDel + ConsoleColors.RED + " Contact Deleted From Address Book" + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + "Contact Not Present in Address Book with name " + searchName + " " + lNameDel + ConsoleColors.RESET);
                }
            } else {
                System.out.println(ConsoleColors.RED + "Contact Not Present in Address Book with name " + searchName + " " + lNameDel + ConsoleColors.RESET);
            }
        }


    //METHOD TO EDIT A CONTACT IN CONTACT ARRAYLIST
    public void editContactDetail() {
        try {
            int lastName;
            String lName = "";
            System.out.println("Please Enter the First Name to search and EDIT");
            String fName = sc.nextLine();
            int firstName = haveContact(fName);

            if (firstName >= 0) {
                System.out.println("Please Enter the Last Name to search and EDIT");
                lName = sc.nextLine();
                lastName = haveContactLast(lName);
                if (lastName >= 0) {
                    System.out.println("Enter Contact Details To EDIT");
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
                    friends.set(firstName, new Contact(firstname, lastname, address, city, state, zip, phoneNo));
                    System.out.println(ConsoleColors.GREEN + "Contact Detail Updated with the new Detail" + ConsoleColors.RESET);
                } else {
                    System.out.println(ConsoleColors.RED + "Contact Not Present in Address Book with name " + fName + " " + lName + ConsoleColors.RESET);
                }

            } else {
                System.out.println(ConsoleColors.RED + "Contact Not Present in Address Book with name " + fName + " " + lName + ConsoleColors.RESET);
            }
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED + "Please give Proper input" + ConsoleColors.RESET);
        }

    }

    //TO SORT ALPHABETICALLY
    public void sortAlphabetic() {
        Sorter sorter = new Sorter(friends);
        System.out.println("Address book sorted in alphabetic order");
        ArrayList<Contact> sorted = sorter.getSortedByName();
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }

    //TO SORT USING ZIP
    public void sortZip() {
        Sorter sorter = new Sorter(friends);
        System.out.println("Address book sorted in zip order");
        ArrayList<Contact> sorted = sorter.getSortedByZip();
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }

    public void fileSave() throws IOException {

        System.out.println("Please Enter File Name You want to save with");
        String name = sc.nextLine();
        String fileName = name + ".txt";
        FileWriter writer = new FileWriter(fileName);
        for (Contact str : friends) {
            System.out.println(str);
            writer.write(str + System.lineSeparator());
        }
        System.out.println(ConsoleColors.GREEN+"Address Book Saved with Name " + fileName+ConsoleColors.RESET);
        writer.close();
    }
}