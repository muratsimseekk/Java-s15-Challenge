import com.workintech.enums.Edition;
import com.workintech.enums.Status;

import java.util.HashSet;
import java.util.Set;

public class Journals extends Book {

    private static Set<Journals> journalsList = new HashSet<>();
    public Journals(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }

    public static Set<Journals> getJournalsList() {
        return journalsList;
    }


    @Override
    public void getTitle() {
        System.out.println("The book title is Journal.");
    }

    @Override
    public void addBook(Book book) {
        Book.getBookList().add(book);
        if (book instanceof Journals){
            journalsList.add((Journals) book);
        }
    }
}
