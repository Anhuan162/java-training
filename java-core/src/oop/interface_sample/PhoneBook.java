package oop.interface_sample;

import java.awt.print.Book;
import java.util.ArrayList;

public class PhoneBook extends Phone {
    static ArrayList<Phone> phoneList = new ArrayList<Phone>();

    public PhoneBook(String name, String phone) {
        super(name, phone);
    }

    @Override
    void insertPhone(String name, String phone) throws Exception {
        boolean nameExists = phoneList.stream().anyMatch(p -> p.getName().equals(name));
        boolean phoneExists = phoneList.stream().anyMatch(p -> p.getName().equals(phone));
        if (nameExists) {
            if (!phoneExists) {
                Phone p = phoneList.stream().filter(phone1 -> phone1.getName().equals(name) && phone1.getPhone().equals(phone))
                        .findFirst().orElse(null);
                p.setPhone(p.getPhone() + ":" + phone);
            } else {
                throw new Exception("Phone existed");
            }
        } else {
            phoneList.add(new PhoneBook(name, phone));
        }
    }

    @Override
    void removePhone(String name) {

    }

    @Override
    void updatePhone(String name, String newphone) {

    }

    @Override
    void searchPhone(String name) {

    }

    @Override
    void sort() {

    }
}
