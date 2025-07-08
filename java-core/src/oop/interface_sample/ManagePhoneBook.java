package oop.interface_sample;

import java.util.Scanner;

public class ManagePhoneBook {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        int choice;

        do {
            System.out.println("PHONEBOOK MANAGEMENT SYSTEM");
            System.out.println("1. Insert Phone");
            System.out.println("2. Remove Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Search Phone");
            System.out.println("5. Sort");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    phoneBook.insertPhone(name, phone);
                    break;
                case 2:
                    System.out.print("Enter name to remove: ");
                    name = sc.nextLine();
                    phoneBook.removePhone(name);
                    break;
                case 3:
                    System.out.print("Enter name to update: ");
                    name = sc.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhone = sc.nextLine();
                    phoneBook.updatePhone(name, newPhone);
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    name = sc.nextLine();
                    phoneBook.searchPhone(name);
                    break;
                case 5:
                    phoneBook.sort();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println(); // blank line

        } while (choice != 6);

        sc.close();
    }
}
