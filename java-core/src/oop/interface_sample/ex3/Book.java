package oop.interface_sample.ex3;

public class Book implements IBook {
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

    public float getAveragePrice() {
        return averagePrice;
    }

    @Override
    public void display() {
        System.out.println("Book Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average Price: " + averagePrice);
        System.out.println("------");
    }
}
