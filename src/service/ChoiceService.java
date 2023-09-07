package service;

import entity.Book;

import java.util.List;
import java.util.Scanner;

public interface ChoiceService {
    String addBook(Scanner scanner);

    List<Book> getBooks();

    List<Book> sortBooksByPriceAscending();

    List<Book> sortBooksByPriceDescending();

    List<Book> sortBooksByTitle();

    String saveLibraryToFile();

    List<Book> loadLibraryFromFile();
    List<Book> searchBooksByTitle(String title);


}
