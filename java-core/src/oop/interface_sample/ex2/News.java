package oop.interface_sample.ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class News implements INews {
    private int id;
    private String title;
    private String content;
    private String author;
    private String publishDate;
    private float averageRate;
    private  int[] rateList = new int[3];

    public News(int id, String title, String content, String author, String publishDate) {}

    public float getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(float averageRate) {
        this.averageRate = averageRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public void display() {
        System.out.println(title + "\t" + content + "\t" + author + "\t" + publishDate);
    }

    public void setRateList(int[] rates) {
        this.rateList = rates;
    }

    public int calculate() {
        int sum = 0;
        for (int r : rateList) sum += r;
        this.averageRate = sum / 3.0f;
        return Math.round(this.averageRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<News> newsList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- NEWS MANAGEMENT ---");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter publish date: ");
                    String date = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter content: ");
                    String content = sc.nextLine();

                    System.out.println("Enter 3 ratings (0-5): ");
                    int[] rates = new int[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Rate " + (i+1) + ": ");
                        rates[i] = sc.nextInt();
                    }

                    News news = new News(id, title, content, author, date);
                    news.setRateList(rates);
                    newsList.add(news);
                    System.out.println("News added!");
                    break;

                case 2:
                    for (News n : newsList) {
                        n.display();
                    }
                    break;

                case 3:
                    for (News n : newsList) {
                        n.calculate();
                        n.display();
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
