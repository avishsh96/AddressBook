 package com.company;

import java.util.Comparator;

public class Contact {

    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phonenumber;

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
        System.out.println("Addressbook");
        return  "First Name:'" + firstname + '\'' +
                ", Last Name:'" + lastname + '\'' +
                ", Address:'" + address + '\'' +
                ", City:'" + city + '\'' +
                ", State:'" + state + '\'' +
                ", Zip:'" + zip + '\'' +
                ", Phone Number:'" + phonenumber + '\'';
    }

    public static Comparator<Contact> zipComparator = new Comparator<Contact>() {
        public int compare(Contact s1, Contact s2) {
            int zip1 = s1.getZip();
            int zip2 = s2.getZip();
            return zip1 - zip2;
        }
    };
    public static Comparator<Contact> nameComparator = new Comparator<Contact>() {

        public int compare(Contact s1, Contact s2) {
            String StudentName1 = s1.getFirstname().toUpperCase();
            String StudentName2 = s2.getFirstname().toUpperCase();

            return StudentName1.compareTo(StudentName2);
            //return StudentName2.compareTo(StudentName1);
        }
    };
}


