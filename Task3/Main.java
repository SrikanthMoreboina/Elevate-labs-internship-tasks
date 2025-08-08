import java.util.*;

class Book{
    String title;
    String author;
    boolean isIssued;

    Book(String title, String author){
        this.title=title;
        this.author=author;
        this.isIssued=false;
    }

}
class User{
    String name;
    ArrayList<Book> issuedBooks = new ArrayList<>();

    User (String name){
        this.name=name;
    }

    void issueBook(Book book){
        if (!book.isIssued){
            book.isIssued=true;
            issuedBooks.remove(book);
            System.out.println("issued book " + book.title);
        }
        else{
            System.out.println(book.title+" Already issued book "  );
        }

    }

    void returnbook(Book book){
        if (issuedBooks.contains(book)){
            book.isIssued=false;
            issuedBooks.remove(book);
             System.out.println(book.title+" returned"  );
        }
        else{
            System.out.println(book.title+" not issued to return " + name  );
        }
    } 
}
class Library{

    ArrayList<Book> books = new ArrayList<>();

    void add(Book book){
        books.add(book);
        System.out.println("Addded Book "+ book.title);
    }

    void viewBooks(){
        System.out.println(" Availble books"  );
        for (Book book : books){
            if (!book.isIssued){
                System.out.println("- " + book.title + " by " + book.author);
            }
        }
    }

    Book findBook(String title){
        for (Book book:books){
            if (book.title.equalsIgnoreCase(title)){
                return book;
            }
        }
        return null;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        User user = new User("Srikanth");

        // Adding some books
        library.add(new Book("Java Basics", "James Gosling"));
        library.add(new Book("Python Fundamentals", "Guido van Rossum"));
        library.add(new Book("C++ Primer", "Bjarne Stroustrup"));

        while (true) {
            System.out.println("\n1. View Available Books");
            System.out.println("2. Issue a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear input buffer

            switch (choice) {
                case 1:
                    library.viewBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String titleToIssue = sc.nextLine();
                    Book bookToIssue = library.findBook(titleToIssue);
                    if (bookToIssue != null) {
                        user.issueBook(bookToIssue);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String titleToReturn = sc.nextLine();
                    Book bookToReturn = library.findBook(titleToReturn);
                    if (bookToReturn != null) {
                        user.returnbook(bookToReturn);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}