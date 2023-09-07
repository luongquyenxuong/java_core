package service.impl;

import entity.Book;
import entity.Library;

import service.ChoiceService;
import service.LibraryService;


import java.util.List;
import java.util.Scanner;

public class ChoiceServiceImpl implements ChoiceService {
    LibraryService libraryService = new LibraryServiceImpl(new Library());

    @Override
    public String addBook(Scanner scanner) {
        Book book = readBookDataFromUser(scanner);
        return libraryService.addBookToLibrary(book);

    }

    @Override
    public List<Book> getBooks() {
        return libraryService.getBooks();
    }

    @Override
    public List<Book> sortBooksByPriceAscending() {
        return libraryService.sortBooksByPriceAscending();
    }

    @Override
    public List<Book> sortBooksByPriceDescending() {
        return libraryService.sortBooksByPriceDescending();
    }

    @Override
    public List<Book> sortBooksByTitle() {
        return libraryService.sortBooksByTitle();
    }

    @Override
    public String saveLibraryToFile() {
        return libraryService.saveLibraryToFile("library.ser");
    }

    @Override
    public List<Book> loadLibraryFromFile() {
        return libraryService.loadLibraryFromFile("library.ser");
    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        return libraryService.searchBooksByTitle(title);
    }

    private Book readBookDataFromUser(Scanner scanner) {
        System.out.print("Nhập tên sách: ");
        String nameBook = scanner.nextLine();
        System.out.print("Nhập tên tác giả: ");
        String nameAuthor = scanner.nextLine();
        System.out.print("Nhập tên nhà xuất bản: ");
        String namePublisher = scanner.nextLine();
        float price = readFloatInput(scanner);

        return new Book(nameBook, nameAuthor, namePublisher, price);
    }

    private float readFloatInput(Scanner scanner) {
        float value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Nhập giá sách: ");
                String input = scanner.nextLine();
                value = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một giá trị số hợp lệ.");
            }
        }
        return value;
    }
}
