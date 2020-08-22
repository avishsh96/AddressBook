package com.company;

import java.util.ArrayList;

public class Sorter {
    ArrayList<Contact> contacts;
    public Sorter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<Contact> getSortedByName() {
        contacts.sort(Contact.nameComparator);
        return contacts;
    }
    public ArrayList<Contact> getSortedByZip() {
        contacts.sort(Contact.zipComparator);
        return contacts;
    }
}

