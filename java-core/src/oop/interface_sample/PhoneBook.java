package oop.interface_sample;

import java.util.ArrayList;
import java.util.Comparator;

public class PhoneBook extends Phone {
    static ArrayList<Phone> phoneList = new ArrayList<>();

    public PhoneBook(String name, String phone) {
        super(name, phone);
    }

    public PhoneBook() {
        super("", "");
    }

    @Override
    void insertPhone(String name, String phone) throws Exception {
        for (Phone p : phoneList) {
            if (p.getName().equals(name)) {
                if (!p.getPhone().contains(phone)) {
                    p.setPhone(p.getPhone() + " : " + phone);
                } else {
                    throw new Exception("Phone existed");
                }
                return;
            }
        }
        phoneList.add(new PhoneBook(name, phone));
    }

    @Override
    void removePhone(String name) {
        phoneList.removeIf(p -> p.getName().equals(name));
    }

    @Override
    void updatePhone(String name, String newphone) {
        for (Phone p : phoneList) {
            if (p.getName().equals(name)) {
                p.setPhone(newphone);
                return;
            }
        }
    }

    @Override
    void searchPhone(String name) {
        for (Phone p : phoneList) {
            if (p.getName().equals(name)) {
                System.out.println("Found: " + p.getName() + " - " + p.getPhone());
                return;
            }
        }
        System.out.println("Not found");
    }

    @Override
    void sort() {
        phoneList.sort(Comparator.comparing(Phone::getName));
        System.out.println("Sorted Phone List:");
        for (Phone p : phoneList) {
            System.out.println(p.getName() + ": " + p.getPhone());
        }
    }
}
