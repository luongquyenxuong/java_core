package service.impl;

import entity.Book;
import entity.Library;
import service.LibraryService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {
    private final Library library;

    public LibraryServiceImpl(Library library) {
        this.library = library;
    }

    // Thêm sách vào thư viện
    @Override
    public String addBookToLibrary(Book book) {
        return library.addBook(book);
    }

    // Sắp xếp sách theo tiêu chí giá tăng dần
    @Override
    public List<Book> sortBooksByPriceAscending() {
        return library.sortBooks(Comparator.comparing(Book::getPrice));
    }

    @Override
    public List<Book> sortBooksByPriceDescending() {
        return library.sortBooks((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice()));
    }

    // Sắp xếp sách theo tiêu chí tên sách
    @Override
    public List<Book> sortBooksByTitle() {
        return library.sortBooks(Comparator.comparing(Book::getTitle));
    }

    @Override
    public List<Book> getBooks() {
        return library.getBooks();
    }


    @Override
    public String saveLibraryToFile(String filename) {
        return library.serializeBooks(filename);
    }

    @Override
    public List<Book> loadLibraryFromFile(String filename) {
       return library.deserializeBooks(filename);
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return library.getBooks()
                .stream()
                .filter(book -> book.getTitle().contains(title))
                .collect(Collectors.toList());
    }

}
