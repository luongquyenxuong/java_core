package service;

import entity.Book;


import java.util.List;

public interface LibraryService {
    String addBookToLibrary(Book book);

    List<Book> sortBooksByPriceAscending();

    List<Book> sortBooksByPriceDescending();

    List<Book> sortBooksByTitle();

    List<Book> getBooks();

    String saveLibraryToFile(String filename);

    List<Book> loadLibraryFromFile(String filename);
    List<Book> searchBooksByTitle(String title);
}
