import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        this.isBorrowed = true;
    }

    public void returnBook() {
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isBorrowed ? " (Borrowed)" : "");
    }
}

class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class LibraryManagementCode {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. View Books");
            System.out.println("4. View Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    addMember(scanner);
                    break;
                case 3:
                    viewBooks();
                    break;
                case 4:
                    viewMembers();
                    break;
                case 5:
                    borrowBook(scanner);
                    break;
                case 6:
                    returnBook(scanner);
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    private static void addMember(Scanner scanner) {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        members.add(new Member(name));
        System.out.println("Member added successfully!");
    }

    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    private static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
        } else {
            System.out.println("Library Members:");
            for (int i = 0; i < members.size(); i++) {
                System.out.println((i + 1) + ". " + members.get(i));
            }
        }
    }

    private static void borrowBook(Scanner scanner) {
        if (books.isEmpty()) {
            System.out.println("No books available to borrow.");
            return;
        }

        viewBooks();
        System.out.print("Enter the number of the book to borrow: ");
        int bookNumber = scanner.nextInt();

        if (bookNumber > 0 && bookNumber <= books.size()) {
            Book book = books.get(bookNumber - 1);
            if (book.isBorrowed()) {
                System.out.println("Sorry, this book is already borrowed.");
            } else {
                book.borrow();
                System.out.println("You have borrowed: " + book.getTitle());
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private static void returnBook(Scanner scanner) {
        if (books.isEmpty()) {
            System.out.println("No books available to return.");
            return;
        }

        viewBooks();
        System.out.print("Enter the number of the book to return: ");
        int bookNumber = scanner.nextInt();

        if (bookNumber > 0 && bookNumber <= books.size()) {
            Book book = books.get(bookNumber - 1);
            if (!book.isBorrowed()) {
                System.out.println("This book is not currently borrowed.");
            } else {
                book.returnBook();
                System.out.println("You have returned: " + book.getTitle());
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }
}