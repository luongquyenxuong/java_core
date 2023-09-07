package entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();


    // Thêm sách vào danh sách
    public String addBook(Book book) {
        books.add(book);
        return "Đã thêm thành công";
    }

    public List<Book> getBooks() {
        return this.books;
    }

    // Sắp xếp danh sách sách theo tiêu chí cụ thể (sử dụng Lambda Expression)
    public List<Book> sortBooks(Comparator<Book> comparator) {
        if (books.isEmpty()) {
            System.out.println("Danh sách rỗng");
            return null;
        }
        books.sort(comparator);
        return books;
    }


    // Serialization - Lưu danh sách sách vào tệp
    public String serializeBooks(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(books);
            return "Serialization thành công.";
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    // Deserialization - Đọc danh sách sách từ tệp
    @SuppressWarnings("unchecked")
    public List<Book> deserializeBooks(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            books = (List<Book>) inputStream.readObject();
            System.out.println("Danh sách sách sau khi deserialization:");
            return books;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}
