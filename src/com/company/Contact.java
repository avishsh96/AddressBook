 package com.company;

import java.util.Comparator;

public class Contact {
    public static class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String CYAN = "\033[0;36m";    // CYAN
    }

    private final String firstname;
    private final String lastname;
    private final String address;
    private final String city;
    private final String state;
    private final int zip;
    private final String phonenumber;

    public Contact(String fname, String lname, String addr, String cy, String st, int z, String pnum) {
        firstname = fname;
        lastname = lname;
        address = addr;
        city = cy;
        state = st;
        zip = z;
        phonenumber = pnum;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getZip() {
        return zip;
    }


    @Override
    public String toString() {
        System.out.println(ConsoleColors.CYAN+"Addressbook");
        return  "First Name:'" + firstname + '\'' +
                ", Last Name:'" + lastname + '\'' +
                ", Address:'" + address + '\'' +
                ", City:'" + city + '\'' +
                ", State:'" + state + '\'' +
                ", Zip:'" + zip + '\'' +
                ", Phone Number:'" + phonenumber + '\''+ConsoleColors.RESET;
    }

    public static Comparator<Contact> zipComparator = (s1, s2) -> {
        int zip1 = s1.getZip();
        int zip2 = s2.getZip();
        return zip1 - zip2;
    };
    public static Comparator<Contact> nameComparator = (s1, s2) -> {
        String StudentName1 = s1.getFirstname().toUpperCase();
        String StudentName2 = s2.getFirstname().toUpperCase();

        return StudentName1.compareTo(StudentName2);
        //return StudentName2.compareTo(StudentName1);
    };
}


