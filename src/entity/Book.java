package entity;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String publisher;
    private double price;

    public Book(String title, String author, String publisher, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Ghi đè phương thức toString để tùy chỉnh cách hiển thị sách
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Price: $" + price;
    }

    public double getPrice() {
        return price;
    }
}
