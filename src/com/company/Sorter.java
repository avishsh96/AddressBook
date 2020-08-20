package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Sorter {
    ArrayList<Contact> contacts;
    public Sorter(ArrayList<Contact> jobCandidate) {
        this.contacts = jobCandidate;
    }

    public ArrayList<Contact> getSortedByName() {
        Collections.sort(contacts, Contact.nameComparator);
        return contacts;
    }
    public ArrayList<Contact> getSortedByZip() {
        Collections.sort(contacts, Contact.zipComparator);
        return contacts;
    }
}

