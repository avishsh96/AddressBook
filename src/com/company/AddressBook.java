package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

    private final ArrayList<Contact> friends;

    public AddressBook() {
        friends = new ArrayList<>();
    }

    public void addContact(Contact c) {
        friends.add(c);
    }

    public void printContacts() {
        if (friends.size()==0){
            System.out.println("Adressbook is empty");
        }
        for (Contact friend : friends) System.out.println(friend);
    }

    public int numContacts() {
        return friends.size();
    }

    private int haveContact(String s) {
        for (int i = 0; i < friends.size(); i++)
            if (friends.get(i).getFirstname().equals(s))
                return i;
        return -1;
    }
    private int haveContactlast(String s) {
        for (int i = 0; i < friends.size(); i++)
            if (friends.get(i).getLastname().equals(s))
                return i;
        return -1;
    }

    public void deleteContact(String s) {
        int place = haveContact(s);
        if (place >= 0)
            friends.remove(place);
    }

    public void editdetail(String s) {
        Scanner sc = new Scanner(System.in);
        int firstplace = haveContact(s);
        System.out.println(firstplace);
        System.out.println("Please Enter the last name");
        String l = sc.nextLine();
        int lastplace = haveContactlast(l);
        System.out.println(lastplace);

        if ( firstplace>= 0 && lastplace >=0) {
            System.out.println("Enter Person Details To EDIT");
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
            friends.set(firstplace, new Contact(firstname, lastname, address, city, state, zip, phoneNo));
        } else
            System.out.println("Person not presnt in addressbook with the name " + s);
    }


    public void sortAlphabatic(){
        Sorter sorter = new Sorter(friends);
        System.out.println("Address book sorted in aplphabetic order");
        ArrayList<Contact> sorted = sorter.getSortedByName();
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
    public void sortZip() {
        Sorter sorter = new Sorter(friends);
        System.out.println("Address book sorted in zip order");
        ArrayList<Contact> sorted = sorter.getSortedByZip();
        for (Contact contact : sorted) {
            System.out.println(contact);
        }
    }
    public void file() throws IOException {
        FileWriter writer = new FileWriter("AdressBook.txt");
        for (Contact str :friends){
            System.out.println(str);
            writer.write(str+System.lineSeparator());
        }
        writer.close();
    }
}