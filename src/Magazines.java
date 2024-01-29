import com.workintech.enums.Edition;
import com.workintech.enums.Status;

import java.util.HashSet;
import java.util.Set;

public class Magazines extends Book {

    private static Set<Magazines> magazinesSet = new HashSet<>();

    public Magazines(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }

    public Set<Magazines> getMagazinesSet() {
        return magazinesSet;
    }

    @Override
    public void getTitle() {
        System.out.println("The book title is Magazine .");
    }

    @Override
    public void addBook(Book book) {
        Book.getBookList().add(book);
        if (book instanceof Magazines){
        magazinesSet.add((Magazines) book);
        }
    }
}
