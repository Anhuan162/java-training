package oop.interface_sample.ex3;

import java.util.ArrayList;
import java.util.Scanner;

public class Book implements IBook {
    private static int idCounter = 1;

    private int id;
    private String name;
    private String publishDate;
    private String author;
    private String language;
    private float averagePrice;

    private int[] priceList = new int[5];

    public Book(int id, String name, String publishDate, String author, String language) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
        this.author = author;
        this.language = language;
    }

    public void setPriceList(int[] priceList) {
        if (priceList.length == 5) {
            this.priceList = priceList;
        } else {
            throw new IllegalArgumentException("Price list must contain exactly 5 elements.");
        }
    }

    public void calculate() {
        int sum = 0;
        for (int price : priceList) {
            sum += price;
        }
        this.averagePrice = sum / 5.0f;
    }

    @Override
    public void display() {
        System.out.println("\nID: " + id);
        System.out.println("Book Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average Price: " + averagePrice);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();

        while (true) {
            System.out.println("\n=== BOOK MANAGEMENT SYSTEM ===");
            System.out.println("1. Insert new book");
            System.out.println("2. View list of books");
            System.out.println("3. Average Price");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.println("\n--- Insert new book ---");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter publish date: ");
                    String publishDate = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter language: ");
                    String language = sc.nextLine();

                    Book newBook = new Book(idCounter++, name, publishDate, author, language);

                    System.out.println("Enter 5 prices:");
                    int[] prices = new int[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Price " + (i + 1) + ": ");
                        prices[i] = Integer.parseInt(sc.nextLine());
                    }

                    newBook.setPriceList(prices);
                    bookList.add(newBook);
                    System.out.println("Book added successfully!");
                    break;
                }

                case 2: {
                    System.out.println("\n--- View list of books ---");
                    if (bookList.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : bookList) {
                            b.display();
                        }
                    }
                    break;
                }

                case 3: {
                    System.out.println("\n--- Average Price ---");
                    if (bookList.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : bookList) {
                            b.calculate();
                            b.display();
                        }
                    }
                    break;
                }

                case 4: {
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("Invalid option. Please choose 1–4.");
            }
        }
    }
}
