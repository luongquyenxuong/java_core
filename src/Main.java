import entity.Book;
import exception.BookException;
import service.ChoiceService;
import service.impl.ChoiceServiceImpl;
import util.Menu;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ChoiceService choiceService = new ChoiceServiceImpl();

    public static void main(String[] args) {
        boolean stop = false;
        do {
            Menu.printMenu();

            String choice = getUserChoice();

            switch (choice) {
                case "1":
                    System.out.println(choiceService.addBook(scanner));
                    break;
                case "2":
                    List<Book> books = choiceService.getBooks();
                    displayBooks(books);
                        break;
                case "3":
                    choiceService.sortBooksByPriceAscending();
                    break;
                case "4":
                    choiceService.sortBooksByPriceDescending();
                    break;
                case "5":
                    choiceService.sortBooksByTitle();
                    break;
                case "6":
                    choiceService.saveLibraryToFile();
                    break;
                case "7":
                    choiceService.loadLibraryFromFile();
                    break;
                case "8":
                    handleSearchBooksByTitle(scanner);
                    break;
                case "0":
                    stop = true;
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (!stop);
        scanner.close();
    }

    private static String getUserChoice() throws BookException, InputMismatchException {
        System.out.print("Nhập lựa chọn của bạn: ");
        return scanner.nextLine();
    }

    private static void displayBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    private static void handleSearchBooksByTitle(Scanner scanner) {
        System.out.print("Nhập tên sách cần tìm: ");
        String searchTitle = scanner.nextLine();
        List<Book> result = choiceService.searchBooksByTitle(searchTitle);

        if (!result.isEmpty()) {
            System.out.println("Kết quả tìm kiếm:");
            for (Book book : result) {
                System.out.println(book);
            }
        } else {
            System.out.println("Không tìm thấy sách phù hợp.");
        }
    }
}